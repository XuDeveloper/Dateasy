package com.example.dateasy.util;

import android.content.Context;
import android.content.Intent;

public class Utils {

	public static void toAnotherActivity(Context from, Class to) {
		Intent intent = new Intent(from, to);
		from.startActivity(intent);
	}

	public static void toAnotherActivity(Context from, Class to, String name,
			String data) {
		Intent intent = new Intent(from, to);
		intent.putExtra(name, data);
		from.startActivity(intent);
	}

}
