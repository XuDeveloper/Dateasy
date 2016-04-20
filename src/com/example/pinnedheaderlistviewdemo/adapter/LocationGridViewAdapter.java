package com.example.pinnedheaderlistviewdemo.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.pinnedheaderlistviewdemo.City;
import com.example.dateasy.*;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class LocationGridViewAdapter extends BaseAdapter {
	private List<City> mList;
	private Context mContext;
	private LayoutInflater mInflater;

	public LocationGridViewAdapter(Context mContext, List<City> mList, int count) {
		this.mContext = mContext;
		this.mList = new ArrayList<City>();
		for (int i = 0; i < count; i++) {
			this.mList.add(mList.get(i));
		}
		mInflater = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
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
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			view = mInflater.inflate(R.layout.location_gv_item, null);
			holder.city_name_tv = (TextView) view
					.findViewById(R.id.gv_city_name_tv);
			view.setTag(holder);
		} else {
			view = convertView;
			holder = (ViewHolder) view.getTag();
		}
		City city = mList.get(position);
		holder.city_name_tv.setText(city.getName());
		Log.i("adapter", city.getName());
		return view;
	}

	private class ViewHolder {
		TextView city_name_tv;

	}

}
