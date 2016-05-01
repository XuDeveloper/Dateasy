package com.example.dateasy.net;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

public class NetworkUtils {

	public static <T> void getData(String url, Callback<T> callback) {
		OkHttpUtils.get().url(url).build().execute(callback);
	}
	
}
