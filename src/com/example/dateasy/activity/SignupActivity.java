package com.example.dateasy.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

import com.example.dateasy.R;
import com.example.dateasy.model.Event;

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
	private TextView mDescriptionTextView;
	private ImageView mDescriptionImageView;
	private Button mSignupButton;
	private ImageButton mSignupShareButton;
	private PopupWindow mShareMenu;
	private View mShareMenuView;
	private int mScreenWidth;
	private int mScreenHeight;
	private ImageButton mShareMenuCloseImageButton;
	private WindowManager mWindowManager;
	private Event mEvent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup_activity);
		initViews();
		
		setData();
	}

	/**
	 * 设置数据
	 */
	private void setData() {
		// TODO Auto-generated method stub
		mEvent = (Event) getIntent().getExtras().getSerializable("DATA");
		mEventNameTextView.setText(mEvent.getmEventName());
//		mReleaseUserTextView.setText(mEvent.getmReleaseUser().getNick_name());
		mTimeTextView.setText(mEvent.getmStartTime());
		mLocationTextView.setText(mEvent.getmLocation());
		mCountTextView.setText("已有" + mEvent.getmCount() + "人报名");
		mDescriptionTextView.setText(mEvent.getmDescription());
	}

	private void initViews() {
		// TODO Auto-generated method stub
		mBackImageButton = (ImageButton) findViewById(R.id.signup_back_ib);
		mEventNameTextView = (TextView) findViewById(R.id.signup_event_name_tv);
		mReleaseUserTextView = (TextView) findViewById(R.id.signup_event_releaseuser_tv);
		mTimeTextView = (TextView) findViewById(R.id.signup_event_time_tv);
		mLocationTextView = (TextView) findViewById(R.id.signup_event_location_tv);
		mCountTextView = (TextView) findViewById(R.id.signup_event_count_tv);
//		mDescriptionImageView = (ImageView) findViewById(R.id.signup_event_description_iv);
		mSignupShareButton = (ImageButton) findViewById(R.id.signup_share_ib);
		mDescriptionTextView = (TextView) findViewById(R.id.signup_event_description_tv);
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
			AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
			View view = getLayoutInflater().inflate(R.layout.signup_activity_user_detail, null);
			builder.setView(view).setPositiveButton("完 成", new AlertDialog.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
//					EditText mUserNameEditText = 
				}

			});
			
			break;
			
		case R.id.signup_share_ib:
			mShareMenu.showAtLocation(findViewById(R.id.signup_activity), Gravity.NO_GRAVITY, 0, mScreenHeight);
			setBackgroundDark();
			break;
		case R.id.share_menu_close:
			if(mShareMenu.isShowing()){
				mShareMenu.dismiss();
			}
		}
	}
	private void setBackgroundDark(){
		WindowManager.LayoutParams lp = getWindow().getAttributes();
		lp.alpha = 0.7f;
		getWindow().setAttributes(lp);
	}
	@Override
	public void onDismiss() {
		// TODO Auto-generated method stub
		WindowManager.LayoutParams lp = getWindow().getAttributes();
		lp.alpha = 1f;
		getWindow().setAttributes(lp);
	}
}
