package com.example.dateasy.fragment;

import com.example.dateasy.R;
import com.example.dateasy.adapter.ManagementListViewAdapter;

import android.view.View;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class ReleaseFragment extends SingleFragment {
	private ListView mListView;
	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.release_fragment;
	}

	@Override
	protected void createView(View view) {
		// TODO Auto-generated method stub
		mListView = (ListView) view.findViewById(R.id.management_lv);
		mListView.setAdapter(new ManagementListViewAdapter(getActivity()));
	}



}
