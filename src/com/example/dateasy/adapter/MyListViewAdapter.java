package com.example.dateasy.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dateasy.R;
import com.example.dateasy.model.Event;

/**
 * 精选页面和发现页面中ListView的Adapter
 * 
 * @author Xu
 * 
 */
public class MyListViewAdapter extends BaseAdapter {

	private Context mContext;
	private ArrayList<Event> mContent;

	public MyListViewAdapter(Context context, ArrayList<Event> mEvents,
			String city) {
		mContext = context;
//		mContent = new ArrayList<>();
//
//		for (Event item: mEvents) {
//			if (item.getmLocation().substring(0, 2).equals(city)) {
//				mContent.add(item);
//			}
//		}
		mContent = mEvents;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mContent.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mContent.get(position);
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
		Event mEvent = mContent.get(position);
		if (convertView == null) {
			view = LayoutInflater.from(mContext).inflate(
					R.layout.favourite_listview_item, null);
			viewholder = new Viewholder();
			viewholder.mEventNameTextView = (TextView) view
					.findViewById(R.id.favourite_event_name_tv);
			viewholder.mTimeTextView = (TextView) view
					.findViewById(R.id.favourite_event_time_tv);
			viewholder.mLocationTextView = (TextView) view
					.findViewById(R.id.favourite_event_location_tv);
			viewholder.mCountTextView = (TextView) view
					.findViewById(R.id.favourite_event_count_tv);
			view.setTag(viewholder);
		} else {
			view = convertView;
			viewholder = (Viewholder) view.getTag();
		}
		// viewholder.mImageView.setImageBitmap(mEvent.getmEventCover());
		viewholder.mEventNameTextView.setText(mEvent.getmEventName());
		viewholder.mTimeTextView.setText(mEvent.getmStartTime());
		viewholder.mCountTextView.setText(mEvent.getmCount() + "报名");
		viewholder.mLocationTextView.setText(mEvent.getmLocation());

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
