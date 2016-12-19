package com.example.dateasy.fragment;

/**
 * 精选Fragment
 * @author Xu
 *  
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dateasy.R;
import com.example.dateasy.activity.SignupActivity;
import com.example.dateasy.adapter.FavouriteAdvViewPagerAdapter;
import com.example.dateasy.adapter.MyListViewAdapter;
import com.example.dateasy.application.MyApplication;
import com.example.dateasy.consts.Const;
import com.example.dateasy.model.Event;
import com.example.dateasy.net.EventCallback;
import com.example.dateasy.ui.AutoScrollViewPager;
import com.example.dateasy.util.NetworkUtils;
import com.example.dateasy.util.Utils;
import com.example.dateasy.ui.CirclePoint;

public class FavouriteFragment extends SingleFragment {
	private LinearLayout mViewPagerContent;
	private AutoScrollViewPager mAutoScrollViewPager;
	private List<Integer> mImageList = new ArrayList<>();
	private CirclePoint mCirclePoint;
	private ListView mListView;
	private MyListViewAdapter mAdapter;

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.favourite_fragment;
	}

	@Override
	protected void createView(View view) {
		// TODO Auto-generated method stub
		mViewPagerContent = (LinearLayout) view
				.findViewById(R.id.favourite_viewpager_content);
		mCirclePoint = (CirclePoint) view
				.findViewById(R.id.favourite_circlepoint_group);
		mListView = (ListView) view.findViewById(R.id.favourite_lv);
		initViewPager();
		// 获取数据
		loadDataFromServer();
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Utils.toAnotherActivity(getActivity(), SignupActivity.class);
			}
		});

	}

	private void initViewPager() {
		mAutoScrollViewPager = new AutoScrollViewPager(getActivity());
		DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

		mAutoScrollViewPager.setLayoutParams(new LinearLayout.LayoutParams(
				dm.widthPixels, dm.heightPixels * 2 / 5));
		initList();
		if (mImageList.size() > 0) {
			mAutoScrollViewPager.setAdapter(new FavouriteAdvViewPagerAdapter(
					getActivity(), mImageList));
		}

		mAutoScrollViewPager.startAutoScroll(5000);
		mCirclePoint.setViewPager(mAutoScrollViewPager);
		mViewPagerContent.addView(mAutoScrollViewPager);
	}

	private void initList() {
		mImageList.add(R.drawable.custom);
		mImageList.add(R.drawable.activities_enrollment);
		mImageList.add(R.drawable.meeting);
		mImageList.add(R.drawable.outdoor_activities);
		mImageList.add(R.drawable.party);
		mImageList.add(R.drawable.recreational_activities);
	}

	/**
	 * 从服务器端加载数据
	 */
	private void loadDataFromServer() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				NetworkUtils.getData(Const.FAVOURITE_URL, new EventCallback() {

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
						Toast.makeText(MyApplication.getInstance(), Const.ERROR_MESSAGE,
								Toast.LENGTH_LONG).show();
					}
				});
			}
		}, Const.START_TIME, Const.REFRESH_TIME);
	}
}
