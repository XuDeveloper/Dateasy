package com.example.dateasy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

import com.example.dateasy.R;

/**
 * 活动报名页
 * @author Xu
 *
 */
public class SignupActivity extends Activity implements OnClickListener, OnDismissListener{

	private ImageButton mBackImageButton;
	private TextView mEventNameTextView;
	private TextView mReleaseUserTextView;
	private TextView mTimeTextView;
	private TextView mLocationTextView;
	private TextView mCountTextView;
	private ImageView mDescriptionImageView;
	private Button mSignupButton;
	private ImageButton mSignupShareButton;
	private PopupWindow mShareMenu;
	private View mShareMenuView;
	private int mScreenWidth;
	private int mScreenHeight;
	private ImageButton mShareMenuCloseImageButton;
	private WindowManager mWindowManager;
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
		mDescriptionImageView = (ImageView) findViewById(R.id.signup_event_description_iv);
		mSignupShareButton = (ImageButton) findViewById(R.id.signup_share_ib);
//		mDescriptionTextView = (TextView) findViewById(R.id.signup_event_description_tv);
		mSignupButton = (Button) findViewById(R.id.signup_event_bt);
		mShareMenuView = getLayoutInflater().inflate(R.layout.share_menu, null);
		mWindowManager = getWindowManager();
		mScreenWidth = mWindowManager.getDefaultDisplay().getWidth();
		mScreenHeight = mWindowManager.getDefaultDisplay().getHeight();
		mBackImageButton.setOnClickListener(this);
		mSignupButton.setOnClickListener(this);
		mSignupShareButton.setOnClickListener(this);
		mShareMenu = new PopupWindow(mShareMenuView, mScreenWidth, 500, true);
		mShareMenu.setAnimationStyle(R.style.anim_sharemenu_inandout);
		mShareMenuCloseImageButton = (ImageButton)mShareMenuView.findViewById(R.id.share_menu_close);
		mShareMenu.setOnDismissListener(this);
		mShareMenuCloseImageButton.setOnClickListener(this);
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
		case R.id.signup_share_ib:
			mShareMenu.showAtLocation(findViewById(R.id.signup_activity), Gravity.NO_GRAVITY, 0, mScreenHeight);
			break;
		case R.id.share_menu_close:
			if(mShareMenu.isShowing()){
				mShareMenu.dismiss();
			}
		}
	}

	@Override
	public void onDismiss() {
		// TODO Auto-generated method stub
		
	}
}
