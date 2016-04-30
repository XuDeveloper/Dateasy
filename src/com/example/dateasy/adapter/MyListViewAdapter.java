package com.example.dateasy.adapter;

import com.example.dateasy.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 精选页面和发现页面中ListView的Adapter
 * @author Xu
 *
 */
public class MyListViewAdapter extends BaseAdapter {

	private Context mContext;

	public MyListViewAdapter(Context context) {
		mContext = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view;
		Viewholder viewholder;
		if (convertView == null) {
			view = LayoutInflater.from(mContext).inflate(
					R.layout.favourite_listview_item, null);
			viewholder = new Viewholder();
			viewholder.mEventNameTextView = (TextView) view.findViewById(R.id.favourite_event_name_tv);
			viewholder.mTimeTextView = (TextView) view.findViewById(R.id.favourite_event_time_tv);
			viewholder.mLocationTextView = (TextView) view.findViewById(R.id.favourite_event_location_tv);
			viewholder.mCountTextView = (TextView) view.findViewById(R.id.favourite_event_count_tv);
			view.setTag(viewholder);
		}else {
			view = convertView;
			viewholder = (Viewholder) view.getTag();
		}
		return view;
	}
	
	class Viewholder {
		/**
		 * 封面图片
		 */
		ImageView mImageView;
		
		/**
		 * 活动标题
		 */
		TextView mEventNameTextView;
		
		/**
		 * 活动时间
		 */
		TextView mTimeTextView;
		
		/**
		 * 活动地点
		 */
		TextView mLocationTextView;
		
		/**
		 * 报名人数
		 */
		TextView mCountTextView;
	}

}
