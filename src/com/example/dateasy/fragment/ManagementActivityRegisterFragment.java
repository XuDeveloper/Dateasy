package com.example.dateasy.fragment;

import com.example.dateasy.R;
import com.example.dateasy.adapter.ManagementActivityRegisterListViewAdapter;

import android.view.View;
import android.widget.ListView;

public class ManagementActivityRegisterFragment extends SingleFragment {
	private ListView mListView;
	private ManagementActivityRegisterListViewAdapter mAdapter;
	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.management_activity_register_fragment;
	}

	@Override
	protected void createView(View view) {
		// TODO Auto-generated method stub
		initView(view);
	}
	private void initView(View view){
		mListView = (ListView) view.findViewById(R.id.management_activity_register_lv);
		mAdapter = new ManagementActivityRegisterListViewAdapter(getActivity());
		mListView.setAdapter(mAdapter);
	}

}
