package com.example.dateasy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.dateasy.R;

/**
 * 活动报名页
 * @author Xu
 *
 */
public class SignupActivity extends Activity implements OnClickListener{

	private ImageButton mBackImageButton;
	private TextView mEventNameTextView;
	private TextView mReleaseUserTextView;
	private TextView mTimeTextView;
	private TextView mLocationTextView;
	private TextView mCountTextView;
	private TextView mDescriptionTextView;
	private Button mSignupButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup_activity);
		initViews();
	}

	private void initViews() {
		// TODO Auto-generated method stub
		mBackImageButton = (ImageButton) findViewById(R.id.signup_back_ib);
		mEventNameTextView = (TextView) findViewById(R.id.signup_event_name_tv);
		mReleaseUserTextView = (TextView) findViewById(R.id.signup_event_releaseuser_tv);
		mTimeTextView = (TextView) findViewById(R.id.signup_event_time_tv);
		mLocationTextView = (TextView) findViewById(R.id.signup_event_location_tv);
		mCountTextView = (TextView) findViewById(R.id.signup_event_count_tv);
		mDescriptionTextView = (TextView) findViewById(R.id.signup_event_description_tv);
		mSignupButton = (Button) findViewById(R.id.signup_event_bt);
		mBackImageButton.setOnClickListener(this);
		mSignupButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.signup_back_ib:
			finish();
			break;

		case R.id.signup_event_bt:
			
			break;
		}
	}
}
