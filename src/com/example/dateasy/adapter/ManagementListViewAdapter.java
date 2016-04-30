package com.example.dateasy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.dateasy.R;

/**
 * 管理界面的listview adapter
 * @author Xu
 *
 */
public class ManagementListViewAdapter extends BaseAdapter{
	private Context mContext;
	public ManagementListViewAdapter(Context mContext){
		this.mContext = mContext;
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
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view;
		Viewholder viewholder;
		if (convertView == null) {
			view = LayoutInflater.from(mContext).inflate(
					R.layout.management_listview_item, null);
			viewholder = new Viewholder();
			viewholder.mEventNameTextView = (TextView) view.findViewById(R.id.management_event_name_tv);
			viewholder.mTimeTextView = (TextView) view.findViewById(R.id.management_event_time_tv);
			viewholder.mIsSignupTextView = (TextView) view.findViewById(R.id.management_event_issignup_tv);
			viewholder.mCostFrameLayout = (FrameLayout) view.findViewById(R.id.management_event_cost_fl);
			viewholder.mNoCostFrameLayout = (FrameLayout) view.findViewById(R.id.management_event_nocost_fl);
			viewholder.mCountTextView = (TextView) view.findViewById(R.id.management_event_count_tv);
			view.setTag(viewholder);
		}else {
			view = convertView;
			viewholder = (Viewholder) view.getTag();
		}
		return view;
	}
	
	class Viewholder {
		/**
		 * 活动标题
		 */
		TextView mEventNameTextView;
		
		/**
		 * 活动时间
		 */
		TextView mTimeTextView;
		
		/**
		 * 活动类型
		 */
		TextView mTypeTextView;
		
		/**
		 * 活动是否能继续报名
		 */
		TextView mIsSignupTextView;
		
		/**
		 * 活动收费
		 */
		FrameLayout mCostFrameLayout;
		
		/**
		 * 活动免费
		 */
		FrameLayout mNoCostFrameLayout;
		
		/**
		 * 报名人数
		 */
		TextView mCountTextView;
	}

}
