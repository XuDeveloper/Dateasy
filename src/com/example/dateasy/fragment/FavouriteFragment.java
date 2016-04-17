package com.example.dateasy.fragment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.example.dateasy.R;
import com.example.dateasy.adapter.FavouriteAdvViewPagerAdapter;
import com.example.dateasy.ui.AdvViewPagerScroller;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FavouriteFragment extends SingleFragment {
	private LinearLayout viewPagerContent;
	private ViewPager viewPager;
	private List<ImageView> views;
	private FavouriteAdvViewPagerAdapter viewPagerAdapter;
	private ImageView[] advImageViews;
	private boolean ifContinue = true;
	private AdvViewPagerScroller scroller;
	private ViewGroup viewGroup;

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
		viewPager.setCurrentItem(Integer.MAX_VALUE / 2);
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
						viewHandler.sendEmptyMessage(viewPager.getCurrentItem() + 1);
						atomicOption();
					}
				}
			}
		}).start();
	}

	// 设置3s的延迟时间
	private void atomicOption() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}
	}

	/*
	 * 每隔固定时间切换广告栏图片
	 */
	private final Handler viewHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			viewPager.setCurrentItem(msg.what);
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
		views.add(img1);
		views.add(img2);
		views.add(img3);
		views.add(img4);
		views.add(img5);
		views.add(img6);
		viewPagerAdapter = new FavouriteAdvViewPagerAdapter(views);
	}

	private void initCirclePoint() {

		advImageViews = new ImageView[views.size()];
		// 广告栏的小圆点图标
		for (int i = 0; i < views.size(); i++) {
			// 创建一个ImageView, 并设置宽高. 将该对象放入到数组中
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					30, 30);
			params.setMargins(0, 0, 20, 0);
			ImageView iv = new ImageView(getActivity());
			iv.setLayoutParams(params);
			advImageViews[i] = iv;

			// 初始值, 默认第0个选中
			if (i == 0) {
				advImageViews[i].setBackgroundResource(R.drawable.yellowdot);
			} else {
				advImageViews[i].setBackgroundResource(R.drawable.greendot);
			}
			// 将小圆点放入到布局中
			viewGroup.addView(advImageViews[i]);
		}
	}

	private final class AdPageChangeListener implements
			ViewPager.OnPageChangeListener {
		/**
		 * 页面滚动状态发生改变的时候触发
		 */
		@Override
		public void onPageScrollStateChanged(int arg0) {
			if (arg0 == ViewPager.SCROLL_STATE_DRAGGING
					|| arg0 == ViewPager.SCROLL_STATE_SETTLING) {
				ifContinue = false;
			} else {
				ifContinue = true;
			}

		}

		/**
		 * 页面滚动的时候触发
		 */
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		/**
		 * 页面选中的时候触发
		 */
		@Override
		public void onPageSelected(int arg0) {
			// 获取当前显示的页面是哪个页面
			int position = ((arg0 - Integer.MAX_VALUE / 2) % advImageViews.length) - 1;
			if (position < 0) {
				position = advImageViews.length + position;
			}
			for (int i = 0; i < advImageViews.length; i++) {
				advImageViews[position]
						.setBackgroundResource(R.drawable.yellowdot);
				if (position != i) {
					advImageViews[i].setBackgroundResource(R.drawable.greendot);
				}
			}
		}
	}

}
