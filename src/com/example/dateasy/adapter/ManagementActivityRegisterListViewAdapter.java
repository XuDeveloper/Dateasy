package com.example.dateasy.adapter;

import com.example.dateasy.R;
import com.example.dateasy.adapter.ManagementRegisterListViewAdapter.Viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ManagementActivityRegisterListViewAdapter extends BaseAdapter {
	private Context mContext;

	public ManagementActivityRegisterListViewAdapter(Context mContext) {
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
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view;
		Viewholder viewholder;
		// User user = mUser.get(position);
		if (convertView == null) {
			view = LayoutInflater.from(mContext).inflate(
					R.layout.management_activity_register_listview_item, null);
			viewholder = new Viewholder();
			viewholder.mUserHeadImageView = (ImageView) view
					.findViewById(R.id.management_activity_register_user_head_iv);
			viewholder.mUserNameTextView = (TextView) view
					.findViewById(R.id.management_activity_register_user_name_tv);
			viewholder.mUserSignUpTimeTextView = (TextView) view
					.findViewById(R.id.management__activity_register_user_signuptime_tv);
			viewholder.mSignupEventNameTextView = (TextView) view
					.findViewById(R.id.management_activity_register_user_signupevent_name_tv);
			viewholder.mSignupStatusTextView = (TextView) view
					.findViewById(R.id.management_activity_register_user_signupevent_name_tv);
			viewholder.mUserTelephoneTextView = (TextView) view
					.findViewById(R.id.management_activity_register_user_telephone_tv);
			view.setTag(viewholder);
		} else {
			view = convertView;
			viewholder = (Viewholder) view.getTag();
		}
		return view;
	}

	class Viewholder {
		/**
		 * 用户头像
		 */
		ImageView mUserHeadImageView;

		/**
		 * 用户姓名
		 */
		TextView mUserNameTextView;

		/**
		 * 用户报名时间
		 */
		TextView mUserSignUpTimeTextView;

		/**
		 * 用户报名的活动名称
		 */
		TextView mSignupEventNameTextView;

		/**
		 * 用户报名状态
		 */
		TextView mSignupStatusTextView;

		/**
		 * 用户电话
		 */
		TextView mUserTelephoneTextView;
	}

}
