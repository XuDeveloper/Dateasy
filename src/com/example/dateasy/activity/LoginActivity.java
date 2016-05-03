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
import android.widget.EditText;


import com.example.dateasy.R;
import com.example.dateasy.model.Check;
import com.example.dateasy.util.Utils;

public class LoginActivity extends Activity implements OnClickListener{

	private Button mRegisterButton;
	private Button mLoginButton;
	private EditText mUserAccountEditText;
	private EditText mUserPasswordEditText;
	private Check mCheck;
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
		mRegisterButton.setOnClickListener(this);
		mLoginButton.setOnClickListener(this);
		mCheck = new Check(this);
	}
	private boolean loginCheck(){
		String mUserAccount = mUserAccountEditText.getText().toString();
		String mUserPassword = mUserPasswordEditText.getText().toString();
		boolean result = mCheck.loginCheck(mUserAccount, mUserPassword);
		if(!result){
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
			if(loginCheck()){
				Utils.toAnotherActivity(LoginActivity.this, MainActivity.class);
				finish();
			}
			break;
		}
	}
	
}
