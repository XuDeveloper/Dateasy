package com.example.dateasy.net;

/**
 * 用户信息回调接口
 * @author Xu
 * 
 */

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Response;

import com.example.dateasy.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.callback.Callback;

public abstract class UserCallback extends Callback<ArrayList<User>> {

	@Override
	public ArrayList<User> parseNetworkResponse(Response response)
			throws IOException {
		String string = response.body().string();
		ArrayList<User> users = new Gson().fromJson(string,
				new TypeToken<ArrayList<User>>() {
				}.getType());
		return users;
	}
}
