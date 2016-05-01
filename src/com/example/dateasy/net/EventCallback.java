package com.example.dateasy.net;

/**
 * 活动回调接口
 * @author Xu
 * 
 */
import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Response;

import com.example.dateasy.model.Event;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.callback.Callback;

public abstract class EventCallback extends Callback<ArrayList<Event>> {
	@Override
	public ArrayList<Event> parseNetworkResponse(Response response) throws IOException {
		String string = response.body().string();
		ArrayList<Event> events = new Gson().fromJson(string, new TypeToken<ArrayList<Event>>(){}.getType());
		return events;
	}
}
