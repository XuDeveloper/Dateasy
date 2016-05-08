package com.example.dateasy.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;

import com.example.dateasy.R;
import com.example.dateasy.activity.ManagementActivity;
import com.example.dateasy.activity.SignupActivity;
import com.example.dateasy.adapter.ManagementReleaseListViewAdapter;
import com.example.dateasy.adapter.MyListViewAdapter;
import com.example.dateasy.consts.Const;
import com.example.dateasy.model.Event;
import com.example.dateasy.model.ManageEvent;
import com.example.dateasy.net.EventCallback;
import com.example.dateasy.util.NetworkUtils;
import com.example.dateasy.util.Utils;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * 管理界面中我发布的Fragment
 * 
 * @author Xu
 * 
 */
public class ReleaseFragment extends SingleFragment {
	private ListView mListView;
	private ManagementReleaseListViewAdapter mAdapter;
	private TextView mReleaseEventNumbersTextView;

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.management_release_fragment;
	}

	@Override
	protected void createView(View view) {
		// TODO Auto-generated method stub
		loadDataFromServer();
		mListView = (ListView) view.findViewById(R.id.management_release_lv);
		mReleaseEventNumbersTextView = (TextView) view
				.findViewById(R.id.management_tv_number);
	}

	private void loadDataFromServer() {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				NetworkUtils.postData(Const.USER_RELEASE_EVENTS, Utils
						.getmCurrentUser().getNick_name(), new EventCallback() {

					@Override
					public void onResponse(final ArrayList<Event> arg0) {
						// TODO Auto-generated method stub
						mReleaseEventNumbersTextView.setText(arg0.size() + "");
						mAdapter = new ManagementReleaseListViewAdapter(
								getActivity(), arg0);
						mListView.setAdapter(mAdapter);
						mListView
								.setOnItemClickListener(new OnItemClickListener() {

									@Override
									public void onItemClick(
											AdapterView<?> parent, View view,
											int position, long id) {
										// TODO Auto-generated method stub
										Bundle bundle = new Bundle();
										Event event = arg0.get(position);
										bundle.putSerializable("DATA", event);
										bundle.putString("EVENTNAME", event.getmEventName());
										Utils.toAnotherActivity(getActivity(),
												ManagementActivity.class,
												bundle);

									}
								});
					}

					@Override
					public void onError(Call arg0, Exception arg1) {
						// TODO Auto-generated method stub
						mReleaseEventNumbersTextView.setText(0 + "");
						Toast.makeText(getActivity(), Const.ERROR_MESSAGE,
								Toast.LENGTH_LONG).show();
					}
				});
			}
		}, Const.START_TIME, Const.REFRESH_TIME);
	}

}
