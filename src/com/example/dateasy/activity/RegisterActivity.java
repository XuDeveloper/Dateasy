package com.example.dateasy.activity;
/**
 * 注册Activity
 * @author Xu
 * 
 */
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.dateasy.R;
import com.example.dateasy.util.Utils;

public class RegisterActivity extends Activity implements OnClickListener{

	private ImageButton mBackImageButton;
	private Button mLoginButton;
	private Button mRegisterAndLoginButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_xml);
		initViews();
	}

	private void initViews() {
		// TODO Auto-generated method stub
		mBackImageButton = (ImageButton) findViewById(R.id.register_back_ib);
		mLoginButton = (Button) findViewById(R.id.register_login_bt);
		mRegisterAndLoginButton = (Button) findViewById(R.id.register_and_login_bt);
		mBackImageButton.setOnClickListener(this);
		mLoginButton.setOnClickListener(this);
		mRegisterAndLoginButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.register_back_ib:
			finish();
			break;

		case R.id.register_login_bt:
			Utils.toAnotherActivity(RegisterActivity.this, MainActivity.class);
			break;
			
		case R.id.register_and_login_bt:
			Utils.toAnotherActivity(RegisterActivity.this, MainActivity.class);
			break;
		}
	}

}
