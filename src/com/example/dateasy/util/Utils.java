package com.example.dateasy.util;

import android.content.Context;
import android.content.Intent;

public class Utils {

	public static void toAnotherActivity(Context from, Class to) {
		Intent intent = new Intent(from, to);
		from.startActivity(intent);
	}
	
}
