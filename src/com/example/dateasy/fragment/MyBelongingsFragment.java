package com.example.dateasy.fragment;

import com.example.dateasy.R;
import com.example.dateasy.activity.MyBelongingsEditActivity;
import com.example.dateasy.util.Utils;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
/**
 * 我的界面Fragment
 * @author Xu
 *
 */
public class MyBelongingsFragment extends SingleFragment implements OnClickListener{

	private ImageView mUserHeadImageView;
	
	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.mybelongings_fragment;
	}

	@Override
	protected void createView(View view) {
		// TODO Auto-generated method stub
		initViews(view);
	}

	private void initViews(View view) {
		// TODO Auto-generated method stub
		mUserHeadImageView = (ImageView) view.findViewById(R.id.mybelongings_user_head);
		mUserHeadImageView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Bundle bundle = new Bundle();
		switch (v.getId()) {
		case R.id.mybelongings_user_head:
			Utils.toAnotherActivity(getActivity(), MyBelongingsEditActivity.class);
			break;

		default:
			break;
		}
	}
}
