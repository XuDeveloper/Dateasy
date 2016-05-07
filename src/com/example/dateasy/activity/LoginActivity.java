package com.example.dateasy.activity;

/**
 * 登录界面
 * @author Xu
 * 
 */
import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.dateasy.R;
import com.example.dateasy.util.CheckUtils;
import com.example.dateasy.util.Utils;

public class LoginActivity extends Activity implements OnClickListener {

	private Button mRegisterButton;
	private Button mLoginButton;
	private ImageButton mBackImageButton;
	private EditText mUserAccountEditText;
	private EditText mUserPasswordEditText;
	private CheckUtils mCheck;

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
		mUserAccountEditText = (EditText) findViewById(R.id.login_account);
		mUserPasswordEditText = (EditText) findViewById(R.id.login_password);
		mBackImageButton = (ImageButton) findViewById(R.id.login_back_ib);
		mBackImageButton.setOnClickListener(this);
		mRegisterButton.setOnClickListener(this);
		mLoginButton.setOnClickListener(this);
		mCheck = new CheckUtils(this);
	}

	private boolean loginCheck() {
		String mUserAccount = mUserAccountEditText.getText().toString();
		String mUserPassword = mUserPasswordEditText.getText().toString();
		boolean result = mCheck.loginCheck(mUserAccount, mUserPassword);
		if (!result) {
			mUserAccountEditText.setText("");
			mUserPasswordEditText.setText("");
		}
		return result;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.register_bt:
			Utils.toAnotherActivity(LoginActivity.this, RegisterActivity.class);
			break;

		case R.id.login_bt:
			if (loginCheck() && !isToMain()) {
				Utils.toAnotherActivity(LoginActivity.this, DetailActivity.class);
				finish();
			}else {
				Utils.toAnotherActivity(LoginActivity.this, MainActivity.class);
				finish();
			}
			break;
			
		case R.id.login_back_ib:
			finish();
			break;
		}
		
	}
	
	/**
	 * 判断是否返回MainActivity
	 */
	private boolean isToMain() {
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			return bundle.getBoolean("MANAGEMENT");
		}
		return false;
	}
	
}
