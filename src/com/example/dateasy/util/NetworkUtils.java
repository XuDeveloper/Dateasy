package com.example.dateasy.util;

/**
 * 网络访问工具类
 * @author Xu
 * 
 */
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

public class NetworkUtils {

	public static <T> void getData(String url, Callback<T> callback) {
		OkHttpUtils.get().url(url).build().execute(callback);
	}

	public static <T> void postData(String url, Callback<T> callback, Object src) {
		OkHttpUtils.postString().url(url).content(new Gson().toJson(src))
				.build().execute(callback);
	}
}
