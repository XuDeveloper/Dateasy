package com.example.dateasy.adapter;

import com.example.dateasy.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ManagementListViewAdapter extends BaseAdapter{
	private Context mContext;
	public ManagementListViewAdapter(Context mContext){
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
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view;
		if (convertView == null) {
			view = LayoutInflater.from(mContext).inflate(
					R.layout.management_listview_item, null);
		}else {
			view = convertView;
		}
		return view;
	}

}
