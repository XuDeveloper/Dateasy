package com.example.dateasy.ui;

import android.content.Context;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dateasy.*;
import java.lang.reflect.Field;

public class CirclePoint extends LinearLayout implements
		ViewPager.OnPageChangeListener, OnClickListener {
	private int mFocusCirclePoint = R.drawable.yellowdot;
	private int mDefaultCirclePoint = R.drawable.greendot;
	private OnPageChangeListener mListener;
	private ImageView[] mCirclePoints;
	private ViewPager mViewPager;

	public CirclePoint(Context context) {
		this(context, null);
	}

	public CirclePoint(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CirclePoint(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

	}

	private void init(int count) {
		removeIndicator();
		if (count <= 0) {
			return;
		}
		mCirclePoints = new ImageView[count];
		setOrientation(HORIZONTAL);

		for (int i = 0; i < count; i++) {
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					30, 30);
			params.setMargins(0, 0, 20, 0);
			ImageView iv = new ImageView(getContext());
			iv.setLayoutParams(params);
			mCirclePoints[i] = iv;

			if (i == 0) {
				mCirclePoints[i].setBackgroundResource(mFocusCirclePoint);
			} else {
				mCirclePoints[i].setBackgroundResource(mDefaultCirclePoint);
			}
			addView(iv);
		}
		updateIndicator(mViewPager.getCurrentItem());
	}

	public void setViewPager(ViewPager pager) {
		mViewPager = pager;
		mListener = getOnPageChangeListener(pager);
		pager.addOnPageChangeListener(this);
		init(pager.getAdapter().getCount());
	}

	private void removeIndicator() {
		removeAllViews();
	}

	private void updateIndicator(int position) {
		int count = mViewPager.getAdapter().getCount();
		for (int i = 0; i < count; i++) {
			if (i == position) {
				mCirclePoints[i].setBackgroundResource(mFocusCirclePoint);
			} else {
				mCirclePoints[i].setBackgroundResource(mDefaultCirclePoint);
			}
		}
	}

	/**
	 * {@link android.support.v4.view.ViewPager#setOnPageChangeListener(ViewPager.OnPageChangeListener)}
	 * is deprecated. We could keep a list of listeners by
	 * {@link android.support.v4.view.ViewPager#addOnPageChangeListener(ViewPager.OnPageChangeListener)}
	 * .
	 */
	@Deprecated
	private ViewPager.OnPageChangeListener getOnPageChangeListener(
			ViewPager pager) {
		try {
			Field f = pager.getClass()
					.getDeclaredField("mOnPageChangeListener");
			f.setAccessible(true);
			return (ViewPager.OnPageChangeListener) f.get(pager);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void onPageScrolled(int position, float positionOffset,
			int positionOffsetPixels) {

	}

	@Override
	public void onPageSelected(int position) {
		updateIndicator(position);
	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}
}
