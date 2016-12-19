package com.example.dateasy.application;

import android.app.Application;

public class MyApplication extends Application {

	private static MyApplication myApplication;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		myApplication = this;  
	}
	
	public static MyApplication getInstance() {
		return myApplication;
	}
	
}
