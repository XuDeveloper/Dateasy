package com.example.dateasy.fragment;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import android.content.SharedPreferences;
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
import com.example.dateasy.application.MyApplication;
import com.example.dateasy.consts.Const;
import com.example.dateasy.model.Event;
import com.example.dateasy.util.LazyLoadFragment;
import com.example.dateasy.util.NetworkUtils;
import com.example.dateasy.net.EventCallback;
import com.example.dateasy.util.Utils;

/**
 * 发现Fragment
 * 
 * @author Xu
 * 
 */
public class ViewFragment extends LazyLoadFragment implements OnClickListener {

	private ListView mListView;
	private MyListViewAdapter mAdapter;
	private ImageView mOutDoorActivitiesImageView;
	private ImageView mGatheringImageView;
	private ImageView mMeetingImageView;
	private ImageView mEntertainmentImageView;
	private ImageView mActiviySignUpImageView;
	private ImageButton mSurroundingsImageButton;
	private ImageButton mWeekendImageButton;

	/**
	 * 从服务器端加载数据
	 */
	private void loadDataFromServer() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				NetworkUtils.getData(Const.VIEW_URL, new EventCallback() {

					@Override
					public void onResponse(final ArrayList<Event> arg0) {
						// TODO Auto-generated method stub
						mAdapter = new MyListViewAdapter(getActivity(), arg0,
								Utils.getCity());
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
										Utils.toAnotherActivity(getActivity(),
												SignupActivity.class, bundle);
									}
								});
					}

					@Override
					public void onError(Call arg0, Exception arg1) {
						// TODO Auto-generated method stub
						Toast.makeText(MyApplication.getInstance(),
								Const.ERROR_MESSAGE, Toast.LENGTH_LONG).show();
					}
				});
			}
		}, Const.START_TIME, Const.REFRESH_TIME);

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
			bundle.putString("TITLE", Const.ACTIVITY_SIGNUP);
			Utils.toAnotherActivity(getActivity(), FindActivity.class, bundle);
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

	@Override
	protected int setContentView() {
		// TODO Auto-generated method stub
		return R.layout.view_fragment;
	}

	@Override
	protected void lazyLoad() {
		// TODO Auto-generated method stub
		// 读取数据
		loadDataFromServer();
	}

	@Override
	protected void initViews() {
		// TODO Auto-generated method stub
		mOutDoorActivitiesImageView = findViewById(R.id.outdooractivities);
		mGatheringImageView = findViewById(R.id.gathering);
		mMeetingImageView = findViewById(R.id.meeting);
		mEntertainmentImageView = findViewById(R.id.entertainment);
		mActiviySignUpImageView = findViewById(R.id.activities_signup);
		mSurroundingsImageButton = findViewById(R.id.surroundings_ib);
		mWeekendImageButton = findViewById(R.id.weekend_ib);
		mOutDoorActivitiesImageView.setOnClickListener(this);
		mGatheringImageView.setOnClickListener(this);
		mMeetingImageView.setOnClickListener(this);
		mEntertainmentImageView.setOnClickListener(this);
		mActiviySignUpImageView.setOnClickListener(this);
		mOutDoorActivitiesImageView.setOnClickListener(this);
		mSurroundingsImageButton.setOnClickListener(this);
		mWeekendImageButton.setOnClickListener(this);
		mListView = findViewById(R.id.view_lv);
	}

}
