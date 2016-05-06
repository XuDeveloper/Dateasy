package com.example.dateasy.adapter;

import java.util.ArrayList;

import com.example.dateasy.R;
import com.example.dateasy.model.Event;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * FindActivity中ListView的Adapter
 * @author Xu
 *
 */
public class TypeAndFindActivityListViewAdapter extends BaseAdapter {

	private Context mContext;
	private ArrayList<Event> mContent;

	public TypeAndFindActivityListViewAdapter(Context context, ArrayList<Event> mEvents, String city) {
		mContext = context;
//		mContent = new ArrayList<>();
//		
//		for (Event item : mEvents) {
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
		Event event = mContent.get(position);
		if (convertView == null) {
			view = LayoutInflater.from(mContext).inflate(
					R.layout.find_activity_lv_item, null);
			viewholder = new Viewholder();
			viewholder.mEventNameTextView = (TextView) view.findViewById(R.id.find_activity_event_name_tv);
			viewholder.mTimeTextView = (TextView) view.findViewById(R.id.find_activity_event_time_tv);
			viewholder.mLocationTextView = (TextView) view.findViewById(R.id.find_activity_event_location_tv);
			viewholder.mReleaseUserTextView = (TextView) view
					.findViewById(R.id.find_activity_event_releaseuser_tv);
			viewholder.mCountTextView = (TextView) view.findViewById(R.id.find_activity_event_count_tv);
			view.setTag(viewholder);
		}else {
			view = convertView;
			viewholder = (Viewholder) view.getTag();
		}
		viewholder.mEventNameTextView.setText(event.getmEventName());
		viewholder.mTimeTextView.setText(event.getmStartTime());
		viewholder.mLocationTextView.setText(event.getmLocation());
		viewholder.mReleaseUserTextView.setText(event.getmReleaseUser().getNick_name());
		viewholder.mCountTextView.setText(event.getmCount() + "报名");
		
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
		 * 活动发起人
		 */
		TextView mReleaseUserTextView;
		
		/**
		 * 报名人数
		 */
		TextView mCountTextView;
	}

}
