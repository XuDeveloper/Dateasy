package com.example.dateasy.ui;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class AdvViewPagerScroller extends Scroller {
	private int mScrollDuration = 2000;
	private boolean zero;

	public AdvViewPagerScroller(Context context) {
		super(context);
	}

	public AdvViewPagerScroller(Context context, Interpolator interpolator, int mScrollDuration) {
		super(context, interpolator);
		this.mScrollDuration = mScrollDuration;
	}

	public AdvViewPagerScroller(Context context, Interpolator interpolator,
			boolean flywheel) {
		super(context, interpolator, flywheel);
	}

	@Override
	public void startScroll(int startX, int startY, int dx, int dy, int duration) {
		super.startScroll(startX, startY, dx, dy, zero ? 0 : mScrollDuration);
	}

	@Override
	public void startScroll(int startX, int startY, int dx, int dy) {
		super.startScroll(startX, startY, dx, dy, zero ? 0 : mScrollDuration);
	}

	public int getScrollDuration() {
		return mScrollDuration;
	}

	public void setScrollDuration(int scrollDuration) {
		this.mScrollDuration = scrollDuration;
	}

	public boolean isZero() {
		return zero;
	}

	public void setZero(boolean zero) {
		this.zero = zero;
	}
}
