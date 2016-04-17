package com.example.dateasy.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class SingleFragment extends Fragment {

	protected abstract int getLayoutId();
	
	protected abstract void createView(View view);
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(getLayoutId(), container, false);
		createView(view);
		return view;
	}
}
