package com.example.dateasy.util;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class Utils {

	/**
	 * Activity跳转
	 * @param from
	 * @param to
	 */
	public static void toAnotherActivity(Context from, Class to) {
		Intent intent = new Intent(from, to);
		from.startActivity(intent);
	}
	
	
}
