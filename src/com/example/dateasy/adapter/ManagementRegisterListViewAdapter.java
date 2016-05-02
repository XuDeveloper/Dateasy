package com.example.dateasy.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dateasy.R;
import com.example.dateasy.activity.SignupActivity;
import com.example.dateasy.model.User;
import com.example.dateasy.util.Utils;

/**
 * 管理界面的listview adapter
 * 
 * @author Xu
 * 
 */
public class ManagementRegisterListViewAdapter extends BaseAdapter {
	private Context mContext;
	private List<User> mUser;

	public ManagementRegisterListViewAdapter(Context mContext, List<User> mUser) {
		this.mContext = mContext;
//		this.mUser = mUser;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return 1;
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
//		User user = mUser.get(position);
		if (convertView == null) {
			view = LayoutInflater.from(mContext).inflate(
					R.layout.management_register_listview_item, null);
			viewholder = new Viewholder();
			viewholder.mUserHeadImageView = (ImageView) view
					.findViewById(R.id.management_register_user_head_iv);
			viewholder.mUserNameTextView = (TextView) view
					.findViewById(R.id.management_register_user_name_tv);
			viewholder.mUserSignUpTimeTextView = (TextView) view
					.findViewById(R.id.management_register_user_signuptime_tv);
			viewholder.mSignupEventNameTextView = (TextView) view
					.findViewById(R.id.management_register_user_signupevent_name_tv);
			viewholder.mSignupStatusTextView = (TextView) view
					.findViewById(R.id.management_register_user_signupstatus_tv);
			view.setTag(viewholder);
		} else {
			view = convertView;
			viewholder = (Viewholder) view.getTag();
		}
//		viewholder.mUserHeadImageView.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Utils.toAnotherActivity(mContext, SignupActivity.class);
//			}
//		});
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
	}

}
