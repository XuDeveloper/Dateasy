package com.example.dateasy.fragment;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Response;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dateasy.R;
import com.example.dateasy.activity.FindActivity;
import com.example.dateasy.activity.SignupActivity;
import com.example.dateasy.activity.TypeActivity;
import com.example.dateasy.adapter.MyListViewAdapter;
import com.example.dateasy.consts.Const;
import com.example.dateasy.model.User;
import com.example.dateasy.net.NetworkUtils;
import com.example.dateasy.net.UserCallback;
import com.example.dateasy.util.Utils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

/**
 * 发现Fragment
 * 
 * @author Xu
 * 
 */
public class ViewFragment extends SingleFragment implements OnClickListener {

	private ListView mListView;
	private MyListViewAdapter mAdapter;
	private ImageView mOutDoorActivitiesImageView;
	private ImageView mGatheringImageView;
	private ImageView mMeetingImageView;
	private ImageView mEntertainmentImageView;
	private ImageView mActiviySignUpImageView;
	private ImageButton mSurroundingsImageButton;
	private ImageButton mWeekendImageButton;

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.view_fragment;
	}

	@Override
	protected void createView(View view) {
		// TODO Auto-generated method stub
		mListView = (ListView) view.findViewById(R.id.view_lv);
		mAdapter = new MyListViewAdapter(this.getActivity());
		mListView.setAdapter(mAdapter);

		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Utils.toAnotherActivity(getActivity(), SignupActivity.class);
			}
		});
		initViews(view);

		// url
//		NetworkUtils.getData(url,
//				new UserCallback() {
//
//					@Override
//					public void onResponse(ArrayList<User> arg0) {
//						// TODO Auto-generated method stub
//						Toast.makeText(
//								getActivity(),
//								arg0.get(0).toString() + "\n"
//										+ arg0.get(1).toString(),
//								Toast.LENGTH_LONG).show();
//					}
//
//					@Override
//					public void onError(Call arg0, Exception arg1) {
//						// TODO Auto-generated method stub
//						Toast.makeText(getActivity(), arg1.toString(), Toast.LENGTH_LONG).show();
//					}
//				});

	}

	private void initViews(View view) {
		// TODO Auto-generated method st
		mOutDoorActivitiesImageView = (ImageView) view
				.findViewById(R.id.outdooractivities);
		mGatheringImageView = (ImageView) view.findViewById(R.id.gathering);
		mMeetingImageView = (ImageView) view.findViewById(R.id.meeting);
		mEntertainmentImageView = (ImageView) view
				.findViewById(R.id.entertainment);
		mActiviySignUpImageView = (ImageView) view
				.findViewById(R.id.activities_signup);
		mSurroundingsImageButton = (ImageButton) view
				.findViewById(R.id.surroundings_ib);
		mWeekendImageButton = (ImageButton) view.findViewById(R.id.weekend_ib);
		mOutDoorActivitiesImageView.setOnClickListener(this);
		mGatheringImageView.setOnClickListener(this);
		mMeetingImageView.setOnClickListener(this);
		mEntertainmentImageView.setOnClickListener(this);
		mActiviySignUpImageView.setOnClickListener(this);
		mOutDoorActivitiesImageView.setOnClickListener(this);
		mSurroundingsImageButton.setOnClickListener(this);
		mWeekendImageButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Bundle bundle = new Bundle();
		switch (v.getId()) {
		case R.id.outdooractivities:
			bundle.putString("TITLE", Const.OUTDOOR_ACTIVITIES);
			Utils.toAnotherActivity(getActivity(), FindActivity.class, bundle);
			break;

		case R.id.gathering:
			bundle.putString("TITLE", Const.GATHERING);
			Utils.toAnotherActivity(getActivity(), FindActivity.class, bundle);
			break;

		case R.id.meeting:
			bundle.putString("TITLE", Const.MEETING);
			Utils.toAnotherActivity(getActivity(), FindActivity.class, bundle);
			break;

		case R.id.entertainment:
			bundle.putString("TITLE", Const.ENTERTAINMENT);
			Utils.toAnotherActivity(getActivity(), FindActivity.class, bundle);
			break;

		case R.id.activities_signup:
			// 有问题，逻辑？
			// Utils.toAnotherActivity(getActivity(), FindActivity.class);
			break;

		case R.id.surroundings_ib:
			bundle.putString("NAME", Const.SURROUNDINGS);
			bundle.putInt("IMAGE", R.drawable.surroundings_hdpi);
			Utils.toAnotherActivity(getActivity(), TypeActivity.class, bundle);
			break;

		case R.id.weekend_ib:
			bundle.putString("NAME", Const.WEEKEND);
			bundle.putInt("IMAGE", R.drawable.weekend_hdpi);
			Utils.toAnotherActivity(getActivity(), TypeActivity.class, bundle);
			break;

		}
	}

}
