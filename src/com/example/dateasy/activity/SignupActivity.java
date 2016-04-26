package com.example.dateasy.activity;

import com.example.dateasy.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

/**
 * 报名页
 * @author Xu
 *
 */
public class SignupActivity extends Activity implements OnClickListener{

	private ImageButton mBackImageButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup_activity);
		initViews();
	}

	private void initViews() {
		// TODO Auto-generated method stub
		mBackImageButton = (ImageButton) findViewById(R.id.signup_back_ib);
		mBackImageButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.signup_back_ib:
			finish();
			break;

		default:
			break;
		}
	}
}
