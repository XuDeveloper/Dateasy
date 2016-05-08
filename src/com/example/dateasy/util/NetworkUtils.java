package com.example.dateasy.util;

/**
 * 网络访问工具类
 * @author Xu
 * 
 */
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

public class NetworkUtils {

	public static <T> void getData(String url, Callback<T> callback) {
		OkHttpUtils.get().url(url).build().execute(callback);
	}

	public static <T> void postData(String url, Object src, Callback<T> callback) {
		OkHttpUtils.postString().url(url).content(new Gson().toJson(src))
				.build().execute(callback);
	}
	
	public static void postData(String url, String useraccount,
			String userpassword, StringCallback callback) {
		OkHttpUtils.post().url(url).addParams("useraccount", useraccount)
				.addParams("userpassword", userpassword).build()
				.execute(callback);
	}
	
	public static <T> void postData(String url, String content, Callback<T> callback) {
		OkHttpUtils.postString().url(url).content(content)
				.build().execute(callback);
	}
}
