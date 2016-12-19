package com.example.dateasy.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dateasy.R;
import com.example.dateasy.activity.LoginActivity;
import com.example.dateasy.activity.MyBelongingsEditActivity;
import com.example.dateasy.util.Utils;
import com.xu.ximageloader.core.XImageLoader;

/**
 * 我的界面Fragment
 * 
 * @author Xu
 * 
 */
public class MyBelongingsFragment extends SingleFragment implements
		OnClickListener {

	private ImageView mUserHeadImageView;
	private TextView mUserNameTextView;
	private Button mSignupProofButton;
	private Button mUserFollowButton;
	private Button mUserFriendsButton;
	private Button mMessageButton;
	private Button mSettingsButton;
	private Button mRespondButton;

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.mybelongings_fragment;
	}

	@Override
	protected void createView(View view) {
		// TODO Auto-generated method stub
		initViews(view);
		if (Utils.getmCurrentUser() != null) {
			mUserHeadImageView
					.setBackgroundResource(R.drawable.management_head);
			XImageLoader.build(getActivity()).imageview(mUserHeadImageView).load(Utils.getmCurrentUser().getmHead());
			mUserNameTextView.setText(Utils.getmCurrentUser().getNick_name());
		} 
	}

	private void initViews(View view) {
		// TODO Auto-generated method stub
		mUserHeadImageView = (ImageView) view
				.findViewById(R.id.mybelongings_user_head);
		mUserNameTextView = (TextView) view
				.findViewById(R.id.mybelongings_user_name);
		mSignupProofButton = (Button) view
				.findViewById(R.id.mybelongings_signup_proof_bt);
		mUserFollowButton = (Button) view
				.findViewById(R.id.mybelongings_user_follow_bt);
		mUserFriendsButton = (Button) view
				.findViewById(R.id.mybelongings_user_friends_bt);
		mMessageButton = (Button) view
				.findViewById(R.id.mybelongings_message_bt);
		mSettingsButton = (Button) view
				.findViewById(R.id.mybelongings_settings_bt);
		mRespondButton = (Button) view
				.findViewById(R.id.mybelongings_respond_bt);
		mSignupProofButton.setOnClickListener(this);
		mUserFollowButton.setOnClickListener(this);
		mUserFriendsButton.setOnClickListener(this);
		mMessageButton.setOnClickListener(this);
		mSettingsButton.setOnClickListener(this);
		mRespondButton.setOnClickListener(this);
		mUserHeadImageView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Bundle bundle = new Bundle();
		switch (v.getId()) {
		case R.id.mybelongings_user_head:
			if (Utils.getmCurrentUser() != null) {
				Utils.toAnotherActivity(getActivity(),
						MyBelongingsEditActivity.class);
			} else {	
				bundle.putBoolean("RETURN_TO_MAIN", true);
				Utils.toAnotherActivity(getActivity(), LoginActivity.class, bundle);
			}
			break;

		case R.id.mybelongings_signup_proof_bt:
			if (Utils.getmCurrentUser() != null) {

			} else {
				bundle.putBoolean("RETURN_TO_MAIN", true);
				Utils.toAnotherActivity(getActivity(), LoginActivity.class, bundle);
			}
			break;

		case R.id.mybelongings_user_follow_bt:
			if (Utils.getmCurrentUser() != null) {

			} else {
				bundle.putBoolean("RETURN_TO_MAIN", true);
				Utils.toAnotherActivity(getActivity(), LoginActivity.class, bundle);
			}
			break;

		case R.id.mybelongings_user_friends_bt:
			if (Utils.getmCurrentUser() != null) {

			} else {
				bundle.putBoolean("RETURN_TO_MAIN", true);
				Utils.toAnotherActivity(getActivity(), LoginActivity.class, bundle);
			}
			break;

		case R.id.mybelongings_message_bt:
			if (Utils.getmCurrentUser() != null) {

			} else {
				bundle.putBoolean("RETURN_TO_MAIN", true);
				Utils.toAnotherActivity(getActivity(), LoginActivity.class, bundle);
			}
			break;

		case R.id.mybelongings_settings_bt:
			if (Utils.getmCurrentUser() != null) {

			} else {
				bundle.putBoolean("RETURN_TO_MAIN", true);
				Utils.toAnotherActivity(getActivity(), LoginActivity.class, bundle);
			}
			break;

		case R.id.mybelongings_respond_bt:
			if (Utils.getmCurrentUser() != null) {

			} else {
				bundle.putBoolean("RETURN_TO_MAIN", true);
				Utils.toAnotherActivity(getActivity(), LoginActivity.class, bundle);
			}
			break;
		}
	}
}
