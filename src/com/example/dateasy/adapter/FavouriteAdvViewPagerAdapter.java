package com.example.dateasy.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/**
 * 首页轮转的图片Adapter
 * @author Xu
 *
 */
public class FavouriteAdvViewPagerAdapter extends PagerAdapter {
	private List views;

	public FavouriteAdvViewPagerAdapter(List views) {
		this.views = views;
	}

	@Override
	public int getCount() {
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {

	}

	@Override
	public Object instantiateItem(ViewGroup container, int args0) {
		int position = ((args0 - Integer.MAX_VALUE / 2) % views.size()) - 1;
		if (position < 0) {
			position = views.size() + position;
		}
		View view = (View) views.get(position);
		ViewParent vp = view.getParent();
		if (vp != null) {
			ViewGroup parent = (ViewGroup) vp;
			parent.removeView(view);
		}
		container.addView(view);
		return views.get(position);
	}

}
