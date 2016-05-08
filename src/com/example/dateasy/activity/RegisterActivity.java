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
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.dateasy.R;
import com.example.dateasy.util.CheckUtils;
import com.example.dateasy.util.Utils;

public class RegisterActivity extends Activity implements OnClickListener {

	private ImageButton mBackImageButton;
	private Button mRegisterAndLoginButton;
	private EditText mUserAccountEditText;
	private EditText mUserPasswordEditText;
	private EditText mUserConfirmPasswordEditText;
	private EditText mVertificationCodeEditText;
	private CheckUtils mCheck;

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
		mRegisterAndLoginButton = (Button) findViewById(R.id.register_and_login_bt);
		mUserAccountEditText = (EditText) findViewById(R.id.register_account);
		mUserPasswordEditText = (EditText) findViewById(R.id.register_password);
		mUserConfirmPasswordEditText = (EditText) findViewById(R.id.register_confirm_password);
		mVertificationCodeEditText = (EditText) findViewById(R.id.register_vertification_code);
		mCheck = new CheckUtils(this);
		mBackImageButton.setOnClickListener(this);
		mRegisterAndLoginButton.setOnClickListener(this);
	}

	private boolean registerCheck() {
		String mUserAccount = mUserAccountEditText.getText().toString();
		String mUserPassword = mUserPasswordEditText.getText().toString();
		String mUserConfirmPassword = mUserConfirmPasswordEditText.getText()
				.toString();
		String mVertificationCode = mVertificationCodeEditText.getText()
				.toString();
		boolean result = mCheck.registerCheck(mUserAccount, mUserPassword,
				mUserConfirmPassword, mVertificationCode);
		if (!result) {
			mUserAccountEditText.setText("");
			mUserPasswordEditText.setText("");
			mUserConfirmPasswordEditText.setText("");
			mVertificationCodeEditText.setText("");
		}
		return result;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.register_back_ib:
			finish();
			break;

		case R.id.register_and_login_bt:
			if (registerCheck()) {
				Utils.toAnotherActivity(RegisterActivity.this,
						DetailActivity.class);
			}
			break;
		}
	}

}
