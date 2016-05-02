package com.example.dateasy.adapter;

import java.util.List;

import com.example.dateasy.R;
import com.example.dateasy.activity.TypeActivity;
import com.example.dateasy.consts.Const;
import com.example.dateasy.util.Utils;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * 首页轮转的图片Adapter
 * 
 * @author Xu
 * 
 */
public class FavouriteAdvViewPagerAdapter extends PagerAdapter implements
		OnClickListener {
	private List<Integer> imageList;
	private Context mContext;

	public FavouriteAdvViewPagerAdapter(Context mContext,
			List<Integer> imageList) {
		this.imageList = imageList;
		this.mContext = mContext;
	}

	@Override
	public int getCount() {
		return imageList.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, final int position) {
		ImageView iv = new ImageView(mContext);
		iv.setBackgroundResource(imageList.get(position));
		switch (position) {
		case 1:
			iv.setId(R.id.img2_id);
			break;

		case 2:
			iv.setId(R.id.img3_id);
			break;

		case 3:
			iv.setId(R.id.img4_id);
			break;

		case 4:
			iv.setId(R.id.img5_id);
			break;

		case 5:
			iv.setId(R.id.img0_id);
			break;

		case 0:
			iv.setId(R.id.img1_id);
			break;
		}
		container.addView(iv);
		iv.setOnClickListener(this);
		return iv;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Bundle bundle = new Bundle();
		switch (v.getId()) {
		case R.id.img1_id:
			bundle.putString("NAME", Const.OTHERS);
			bundle.putInt("IMAGE", imageList.get(0));
			Utils.toAnotherActivity(mContext, TypeActivity.class, bundle);
			break;

		case R.id.img2_id:
			bundle.putString("NAME", Const.ACTIVITY_SIGNUP);
			bundle.putInt("IMAGE", imageList.get(1));
			Utils.toAnotherActivity(mContext, TypeActivity.class, bundle);
			break;

		case R.id.img3_id:
			bundle.putString("NAME", Const.MEETING);
			bundle.putInt("IMAGE", imageList.get(2));
			Utils.toAnotherActivity(mContext, TypeActivity.class, bundle);
			break;

		case R.id.img4_id:
			bundle.putString("NAME", Const.OUTDOOR_ACTIVITIES);
			bundle.putInt("IMAGE", imageList.get(3));
			Utils.toAnotherActivity(mContext, TypeActivity.class, bundle);
			break;

		case R.id.img5_id:
			bundle.putString("NAME", Const.GATHERING);
			bundle.putInt("IMAGE", imageList.get(4));
			Utils.toAnotherActivity(mContext, TypeActivity.class, bundle);
			break;

		case R.id.img0_id:
			bundle.putString("NAME", Const.ENTERTAINMENT);
			bundle.putInt("IMAGE", imageList.get(5));
			Utils.toAnotherActivity(mContext, TypeActivity.class, bundle);
			break;
		}
	}

}
