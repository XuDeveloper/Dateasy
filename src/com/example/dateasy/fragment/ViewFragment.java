package com.example.dateasy.fragment;

import com.example.dateasy.R;
import com.example.dateasy.adapter.MyListViewAdapter;

import android.view.View;
import android.widget.ListView;

public class ViewFragment extends SingleFragment {

	private ListView mListView;
	private MyListViewAdapter mAdapter;
	
	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.view_fragment;
	}

	@Override
	protected void createView(View view) {
		// TODO Auto-generated method stub
		mListView = (ListView) view.findViewById(R.id.view_lv);
		mAdapter = new MyListViewAdapter(this.getActivity());
		mListView.setAdapter(mAdapter);
	}

	
}
