package com.example.dateasy.fragment;

import com.example.dateasy.R;
import com.example.dateasy.adapter.ManagementActivityRegisterListViewAdapter;
import com.example.dateasy.util.LazyLoadFragment;

import android.view.View;
import android.widget.ListView;

public class ManagementActivityRegisterFragment extends LazyLoadFragment {
	private ListView mListView;
	private ManagementActivityRegisterListViewAdapter mAdapter;

	@Override
	protected int setContentView() {
		// TODO Auto-generated method stub
		return R.layout.management_activity_register_fragment;
	}

	@Override
	protected void lazyLoad() {
		// TODO Auto-generated method stub
		mAdapter = new ManagementActivityRegisterListViewAdapter(getActivity());
		mListView.setAdapter(mAdapter);
	}

	@Override
	protected void initViews() {
		// TODO Auto-generated method stub
		mListView = findViewById(R.id.management_activity_register_lv);
	}

}
