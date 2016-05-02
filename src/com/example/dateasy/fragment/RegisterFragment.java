package com.example.dateasy.fragment;

import java.util.ArrayList;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.dateasy.R;
import com.example.dateasy.adapter.ManagementRegisterListViewAdapter;
import com.example.dateasy.model.User;

/**
 * 管理界面的管理报名界面Fragment
 * 
 * @author Xu
 * 
 */
public class RegisterFragment extends SingleFragment {
	private ListView mListView;
	private ArrayList<User> mSignupUsers;

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.management_register_fragment;
	}

	@Override
	protected void createView(View view) {
		// TODO Auto-generated method stub
		mListView = (ListView) view.findViewById(R.id.management_register_lv);
		mListView.setAdapter(new ManagementRegisterListViewAdapter(
				getActivity(), mSignupUsers));
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

			}
		});
	}

}
