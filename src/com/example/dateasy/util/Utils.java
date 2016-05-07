package com.example.dateasy.util;

/**
 * 工具类
 * @author Xu
 * 
 */

import com.example.dateasy.model.Event;
import com.example.dateasy.model.User;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Utils {

	private static String mCity;
	private static User mCurrentUser = null;
	private static boolean mIsLogin;
	private static Event mCurrentReleaseEvent = null;

	/**
	 * Activity跳转
	 * 
	 * @param from
	 * @param to
	 */
	public static void toAnotherActivity(Context from, Class to) {
		Intent intent = new Intent(from, to);
		from.startActivity(intent);
	}

	/**
	 * Activity跳转（带参数）
	 * 
	 * @param from
	 * @param to
	 * @param bundle
	 */

	public static void toAnotherActivity(Context from, Class to, Bundle bundle) {
		Intent intent = new Intent(from, to);
		intent.putExtras(bundle);
		from.startActivity(intent);
	}

	/**
	 * 设置标题
	 * 
	 * @param activity
	 * @param resID
	 * @param key
	 */
	public static void setActivityTitle(Activity activity, int resID, String key) {
		TextView titleTextView = (TextView) activity.findViewById(resID);
		Bundle bundle = activity.getIntent().getExtras();
		String title = bundle.getString(key);
		titleTextView.setText(title);
	}

	public static void setCity(String city) {
		Utils.mCity = city;
	}

	public static String getCity() {
		return mCity;
	}

	public static User getmCurrentUser() {
		return mCurrentUser;
	}

	public static void setmCurrentUser(User mCurrentUser) {
		Utils.mCurrentUser = mCurrentUser;
		mIsLogin = true;
	}
	
	public static boolean isLogin() {
		return mIsLogin;
	}

	public static Event getmCurrentReleaseEvent() {
		return mCurrentReleaseEvent;
	}

	public static void setmCurrentReleaseEvent(Event mCurrentReleaseEvent) {
		Utils.mCurrentReleaseEvent = mCurrentReleaseEvent;
	}
	
}
