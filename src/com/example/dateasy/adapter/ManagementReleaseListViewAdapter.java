package com.example.dateasy.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.dateasy.R;
import com.example.dateasy.model.Event;

/**
 * 管理界面的listview adapter
 * 
 * @author Xu
 * 
 */
public class ManagementReleaseListViewAdapter extends BaseAdapter {
	private Context mContext;
	private ArrayList<Event> mContent;

	public ManagementReleaseListViewAdapter(Context mContext,
			ArrayList<Event> mContent) {
		this.mContext = mContext;
		this.mContent = mContent;
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
		Event me = mContent.get(position);
		if (convertView == null) {
			view = LayoutInflater.from(mContext).inflate(
					R.layout.management_release_listview_item, null);
			viewholder = new Viewholder();
			viewholder.mEventNameTextView = (TextView) view
					.findViewById(R.id.management_event_name_tv);
			viewholder.mTimeTextView = (TextView) view
					.findViewById(R.id.management_event_time_tv);
			viewholder.mIsSignupTextView = (TextView) view
					.findViewById(R.id.management_event_issignup_tv);
			viewholder.mCostFrameLayout = (FrameLayout) view
					.findViewById(R.id.management_event_cost_fl);
			viewholder.mNoCostFrameLayout = (FrameLayout) view
					.findViewById(R.id.management_event_nocost_fl);
			viewholder.mCountTextView = (TextView) view
					.findViewById(R.id.management_event_count_tv);
			view.setTag(viewholder);
		} else {
			view = convertView;
			viewholder = (Viewholder) view.getTag();
		}
		viewholder.mEventNameTextView.setText(me.getmEventName());
		viewholder.mTimeTextView.setText(me.getmStartTime());
		viewholder.mIsSignupTextView.setText("报名中");
		if (me.getmCost() != 0) {
			viewholder.mCostFrameLayout.setVisibility(View.VISIBLE);
			viewholder.mNoCostFrameLayout.setVisibility(View.INVISIBLE);
		} else {
			viewholder.mCostFrameLayout.setVisibility(View.INVISIBLE);
			viewholder.mNoCostFrameLayout.setVisibility(View.VISIBLE);
		}
		viewholder.mCountTextView.setText(me.getmCount() + "");
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
