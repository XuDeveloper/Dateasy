package com.example.dateasy.activity;

/**
 * 点击报名者头像弹出的activity
 * @author Xu
 * 
 */
import com.example.dateasy.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class SignupUserDetailActivity extends Activity implements OnClickListener{
	private TextView mName;
	private TextView mTelephone;
	private ImageButton mBackImageButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.management_register_signup_user);
		initView();
	}
	private void initView(){
		mName = (TextView) findViewById(R.id.management_register_signup_user_name);
		mTelephone = (TextView) findViewById(R.id.management_register_signup_user_telephone);
		mBackImageButton = (ImageButton) findViewById(R.id.management_register_user_back_ib);
		mBackImageButton.setOnClickListener(this);
	}
	private void initUserDetail(){
		Bundle bundle = getIntent().getExtras();
		String mUserName = bundle.getString("NICKNAME");
		String mUserTelephone = bundle.getString("TELEPHONE");
//		mName.setText(mUserName);
//		mTelephone.setText(mUserTelephone);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.management_register_user_back_ib:
				finish();
				break;
		}
	}
}
