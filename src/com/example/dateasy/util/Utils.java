package com.example.dateasy.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class Utils {

	public static void toAnotherActivity(Context from, Class to) {
		Intent intent = new Intent(from, to);
		from.startActivity(intent);
	}

	public static void toAnotherActivity(Context from, Class to, Bundle bundle) {
		Intent intent = new Intent(from, to);
		intent.putExtras(bundle);
		from.startActivity(intent);

	}

}
