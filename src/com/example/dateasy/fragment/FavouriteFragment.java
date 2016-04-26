package com.example.dateasy.fragment;

/**
 * 精选Fragment
 * @author Xu
 *  
 */
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.example.dateasy.R;
import com.example.dateasy.activity.MainActivity;
import com.example.dateasy.adapter.FavouriteAdvViewPagerAdapter;
import com.example.dateasy.adapter.MyListViewAdapter;
import com.example.dateasy.ui.AdvViewPagerScroller;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class FavouriteFragment extends SingleFragment {
	private LinearLayout viewPagerContent;
	private ViewPager viewPager;
	private List<ImageView> views;
	private FavouriteAdvViewPagerAdapter viewPagerAdapter;
	private ImageView[] advImageViews;
	private boolean ifContinue = true;
	private AdvViewPagerScroller scroller;
	private ViewGroup viewGroup;
	private ListView mListView;
	private int mCurrentItem;
	private MyListViewAdapter mAdapter;

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.favourite_fragment;
	}

	@Override
	protected void createView(View view) {
		// TODO Auto-generated method stub
		viewPagerContent = (LinearLayout) view
				.findViewById(R.id.favourite_viewpager_content);
		viewGroup = (ViewGroup) view
				.findViewById(R.id.favourite_circlepoint_group);

		mListView = (ListView) view.findViewById(R.id.favourite_lv);
		mAdapter = new MyListViewAdapter(getActivity());
		mListView.setAdapter(mAdapter);
		initViewPager();
	}

	private void initViewPager() {
		viewPager = new ViewPager(getActivity());
		DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
		viewPager.setLayoutParams(new LinearLayout.LayoutParams(dm.widthPixels,
				(dm.heightPixels / 5) * 2));
		viewPagerContent.addView(viewPager);
		initPageAdapter();
		initCirclePoint();
		viewPager.setAdapter(viewPagerAdapter);
		viewPager.addOnPageChangeListener(new AdPageChangeListener());
		try {
			Field mScroller = null;
			mScroller = ViewPager.class.getDeclaredField("mScroller");
			mScroller.setAccessible(true);
			scroller = new AdvViewPagerScroller(viewPager.getContext());
			mScroller.set(viewPager, scroller);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (ifContinue) {
						int position = viewPager.getCurrentItem() + 1;
						viewHandler.sendEmptyMessage(position);
						atomicOption();
					}
				}
			}
		}).start();
	}

	private void atomicOption() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}
	}

	private final Handler viewHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			int position = msg.what;
			ifContinue = false;
			Log.i("TAG", position + "");
			if (position == views.size()) {
				Log.i("show", "1");
				viewPager.setCurrentItem(1, false);
				Log.i("show", "2");
				viewPager.setCurrentItem(2);
				Log.i("show", "3");
			} else {
				viewPager.setCurrentItem(position);
			}
			ifContinue = true;
			super.handleMessage(msg);
		}

	};

	private void initPageAdapter() {
		views = new ArrayList<ImageView>();
		ImageView img1 = new ImageView(getActivity());
		ImageView img2 = new ImageView(getActivity());
		ImageView img3 = new ImageView(getActivity());
		ImageView img4 = new ImageView(getActivity());
		ImageView img5 = new ImageView(getActivity());
		ImageView img6 = new ImageView(getActivity());
		img1.setBackgroundResource(R.drawable.custom);
		img2.setBackgroundResource(R.drawable.activities_enrollment);
		img3.setBackgroundResource(R.drawable.meeting);
		img4.setBackgroundResource(R.drawable.outdoor_activities);
		img5.setBackgroundResource(R.drawable.party);
		img6.setBackgroundResource(R.drawable.recreational_activities);
		views.add(img6);
		views.add(img1);
		views.add(img2);
		views.add(img3);
		views.add(img4);
		views.add(img5);
		views.add(img6);
		views.add(img1);
		viewPagerAdapter = new FavouriteAdvViewPagerAdapter(views);
	}

	private void initCirclePoint() {

		advImageViews = new ImageView[views.size() - 2];
		for (int i = 0; i < views.size() - 2; i++) {
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					30, 30);
			params.setMargins(0, 0, 20, 0);
			ImageView iv = new ImageView(getActivity());
			iv.setLayoutParams(params);
			advImageViews[i] = iv;

			if (i == 0) {
				advImageViews[i].setBackgroundResource(R.drawable.yellowdot);
			} else {
				advImageViews[i].setBackgroundResource(R.drawable.greendot);
			}
			viewGroup.addView(advImageViews[i]);
		}
	}

	private final class AdPageChangeListener implements
			ViewPager.OnPageChangeListener {
		@Override
		public void onPageScrollStateChanged(int arg0) {
			if (arg0 == ViewPager.SCROLL_STATE_DRAGGING
					|| arg0 == ViewPager.SCROLL_STATE_SETTLING) {
				ifContinue = false;
			} else {
				ifContinue = true;
			}

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageSelected(int arg0) {
			int position = arg0;
			if (position == 0) {
				viewPager.setCurrentItem(views.size() - 1, false);
				viewPager.setCurrentItem(views.size() - 2);
				position = advImageViews.length - 1;
			} else if (position == views.size() - 1) {
				position = 0;
			} else {
				position = position - 1;
			}
			advImageViews[position].setBackgroundResource(R.drawable.yellowdot);
			if (position == 0) {
				advImageViews[advImageViews.length - 1]
						.setBackgroundResource(R.drawable.greendot);
				advImageViews[position + 1]
						.setBackgroundResource(R.drawable.greendot);
			} else if (position == (advImageViews.length - 1)) {
				advImageViews[position - 1]
						.setBackgroundResource(R.drawable.greendot);
				advImageViews[0].setBackgroundResource(R.drawable.greendot);
			} else {
				advImageViews[position + 1]
						.setBackgroundResource(R.drawable.greendot);
				advImageViews[position - 1]
						.setBackgroundResource(R.drawable.greendot);
			}

			// for (int i = 0; i < advImageViews.length; i++) {
			// advImageViews[position]
			// .setBackgroundResource(R.drawable.yellowdot);
			// if (position != i) {
			// advImageViews[i].setBackgroundResource(R.drawable.greendot);
			// }
			// }
		}
	}

}
