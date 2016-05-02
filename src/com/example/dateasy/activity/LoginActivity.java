package com.example.dateasy.activity;

/**
 * 登录界面
 * @author Xu
 * 
 */
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.dateasy.R;
import com.example.dateasy.util.Utils;

public class LoginActivity extends Activity implements OnClickListener{

	private Button mRegisterButton;
	private Button mLoginButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_xml);
		initViews();
	}

	private void initViews() {
		// TODO Auto-generated method stub
		mRegisterButton = (Button) findViewById(R.id.register_bt);
		mLoginButton = (Button) findViewById(R.id.login_bt);
		mRegisterButton.setOnClickListener(this);
		mLoginButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.register_bt:
			Utils.toAnotherActivity(LoginActivity.this, RegisterActivity.class);
			break;

		case R.id.login_bt:
			Utils.toAnotherActivity(LoginActivity.this, MainActivity.class);
			finish();
			break;
		}
	}
	
}
