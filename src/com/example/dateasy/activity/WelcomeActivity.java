package com.example.dateasy.activity;

/**
 * 欢迎界面
 * @author Xu
 */
import java.util.Timer;
import java.util.TimerTask;

import com.example.dateasy.R;
import com.example.dateasy.util.Utils;

import android.app.Activity;
import android.os.Bundle;

public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Utils.toAnotherActivity(WelcomeActivity.this, LoginActivity.class);
				finish();
			}
		};
		timer.schedule(task, 3000);
	}
}
