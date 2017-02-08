package com.example.dateasy.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.dateasy.R;
import com.example.dateasy.activity.SignupUserDetailActivity;
import com.example.dateasy.adapter.ManagementRegisterListViewAdapter;
import com.example.dateasy.model.User;
import com.example.dateasy.util.LazyLoadFragment;
import com.example.dateasy.util.Utils;

/**
 * 管理界面的管理报名界面Fragment
 * 
 * @author Xu
 * 
 */
public class RegisterFragment extends LazyLoadFragment {
	private ListView mListView;
	private List<User> mSignupUsers= new ArrayList<User>();;

	@Override
	protected int setContentView() {
		// TODO Auto-generated method stub
		return R.layout.management_register_fragment;
	}

	@Override
	protected void lazyLoad() {
		// TODO Auto-generated method stub
		mListView.setAdapter(new ManagementRegisterListViewAdapter(
				getActivity(), mSignupUsers));
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
//				User mUser = mSignupUsers.get(position);
//				Bundle bundle = new Bundle();
//				bundle.putString("NICKNAME", mUser.getmNickName());
//				bundle.putString("TELEPHONE", mUser.getmTelephone());
//				Utils.toAnotherActivity(getActivity(), SignupUserDetailActivity.class, bundle);
				Utils.toAnotherActivity(getActivity(), SignupUserDetailActivity.class);
			}
		});
	}

	@Override
	protected void initViews() {
		// TODO Auto-generated method stub
		mListView = findViewById(R.id.management_register_lv);
	}

}
