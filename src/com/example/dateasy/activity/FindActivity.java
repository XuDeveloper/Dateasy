package com.example.dateasy.activity;

/**
 * 发现Activity
 * @author Xu
 */
import com.example.dateasy.R;
import com.example.dateasy.consts.Const;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FindActivity extends Activity implements OnClickListener {

	private static int TYPE_CHECKED = 0;
	private static int LOCATION_CHECKED = 1;
	private static int TIME_CHECKED = 2;

	private ImageButton mBackImageButton;
	private TextView mTypeTextView;
	private TextView mTypeBottomTextView;
	private TextView mLocationTextView;
	private TextView mLocationBottomTextView;
	private TextView mTimeTextView;
	private TextView mTimeBottomTextView;
	private RadioGroup mTypeRadioGroup;
	private RadioButton mTypeOutDoorActivitiesRadioButton;
	private RadioButton mTypeGatheringRadioButton;
	private RadioButton mTypeEntertainmentRadioButton;
	private RadioButton mTypeMeetingRadioButton;
	private RadioButton mTypeActivitySignupRadioButton;
	private RadioButton mTypeOthersRadioButton;
	private RadioGroup mLocationRadioGroup;
	private RadioButton mLocation1RadioButton;
	private RadioButton mLocation2RadioButton;
	private RadioButton mLocation3RadioButton;
	private RadioButton mLocation4RadioButton;
	private RadioButton mLocation5RadioButton;
	private RadioButton mLocation6RadioButton;
	private RadioGroup mTimeRadioGroup;
	private RadioButton mTime1RadioButton;
	private RadioButton mTime2RadioButton;
	private RadioButton mTime3RadioButton;
	private RadioButton mTime4RadioButton;
	private RadioButton mTime5RadioButton;
	private TextView mTitleTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.find_activity);
		initViews();

		setTitleText();

	}

	/**
	 * 设置标题
	 */
	private void setTitleText() {
		// TODO Auto-generated method stub
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			String title = bundle.getString("TITLE");
			mTitleTextView.setText(title);
			if (title.equals(Const.OUTDOOR_ACTIVITIES)) {
				mTypeOutDoorActivitiesRadioButton.setChecked(true);
			} else if (title.equals(Const.GATHERING)) {
				mTypeGatheringRadioButton.setChecked(true);
			} else if (title.equals(Const.ENTERTAINMENT)) {
				mTypeEntertainmentRadioButton.setChecked(true);
			} else if (title.equals(Const.MEETING)) {
				mTypeMeetingRadioButton.setChecked(true);
			} else if (title.equals(Const.ACTIVITY_SIGNUP)) {
				mTypeActivitySignupRadioButton.setChecked(true);
			} else {
				mTypeOthersRadioButton.setChecked(true);
			}
		} else {
			mTypeOutDoorActivitiesRadioButton.setChecked(true);
		}
	}

	/**
	 * 处理逻辑
	 */
	private void setChecked(int choose) {
		mLocation1RadioButton.setChecked(true);
		mTime1RadioButton.setChecked(true);
		if (choose == TYPE_CHECKED) {
			mTypeBottomTextView.setVisibility(View.VISIBLE);
			mLocationBottomTextView.setVisibility(View.INVISIBLE);
			mTimeBottomTextView.setVisibility(View.INVISIBLE);
			mTypeRadioGroup.setVisibility(View.VISIBLE);
			mLocationRadioGroup.setVisibility(View.INVISIBLE);
			mTimeRadioGroup.setVisibility(View.INVISIBLE);
		} else if (choose == LOCATION_CHECKED) {
			mTypeBottomTextView.setVisibility(View.INVISIBLE);
			mLocationBottomTextView.setVisibility(View.VISIBLE);
			mTimeBottomTextView.setVisibility(View.INVISIBLE);
			mTypeRadioGroup.setVisibility(View.INVISIBLE);
			mLocationRadioGroup.setVisibility(View.VISIBLE);
			mTimeRadioGroup.setVisibility(View.INVISIBLE);
		} else {
			mTypeBottomTextView.setVisibility(View.INVISIBLE);
			mLocationBottomTextView.setVisibility(View.INVISIBLE);
			mTimeBottomTextView.setVisibility(View.VISIBLE);
			mTypeRadioGroup.setVisibility(View.INVISIBLE);
			mLocationRadioGroup.setVisibility(View.INVISIBLE);
			mTimeRadioGroup.setVisibility(View.VISIBLE);
		}
	}

	private void initViews() {
		// TODO Auto-generated method stub
		mBackImageButton = (ImageButton) findViewById(R.id.find_activity_back_ib);
		mTypeTextView = (TextView) findViewById(R.id.find_activity_type);
		mTypeBottomTextView = (TextView) findViewById(R.id.find_activity_type_bottombar);
		mLocationTextView = (TextView) findViewById(R.id.find_activity_location);
		mLocationBottomTextView = (TextView) findViewById(R.id.find_activity_location_bottombar);
		mTimeTextView = (TextView) findViewById(R.id.find_activity_time);
		mTimeBottomTextView = (TextView) findViewById(R.id.find_activity_time_bottombar);
		mTypeRadioGroup = (RadioGroup) findViewById(R.id.find_activity_type_detail);
		mLocationRadioGroup = (RadioGroup) findViewById(R.id.find_activity_location_detail);
		mTimeRadioGroup = (RadioGroup) findViewById(R.id.find_activity_time_detail);
		mTitleTextView = (TextView) findViewById(R.id.find_activity_title);
		mTypeOutDoorActivitiesRadioButton = (RadioButton) findViewById(R.id.find_activity_type_1);
		mTypeGatheringRadioButton = (RadioButton) findViewById(R.id.find_activity_type_2);
		mTypeEntertainmentRadioButton = (RadioButton) findViewById(R.id.find_activity_type_3);
		mTypeMeetingRadioButton = (RadioButton) findViewById(R.id.find_activity_type_4);
		mTypeActivitySignupRadioButton = (RadioButton) findViewById(R.id.find_activity_type_5);
		mTypeOthersRadioButton = (RadioButton) findViewById(R.id.find_activity_type_6);
		mLocation1RadioButton = (RadioButton) findViewById(R.id.find_activity_location_1);
		mLocation2RadioButton = (RadioButton) findViewById(R.id.find_activity_location_2);
		mLocation3RadioButton = (RadioButton) findViewById(R.id.find_activity_location_3);
		mLocation4RadioButton = (RadioButton) findViewById(R.id.find_activity_location_4);
		mLocation5RadioButton = (RadioButton) findViewById(R.id.find_activity_location_5);
		mLocation6RadioButton = (RadioButton) findViewById(R.id.find_activity_location_6);
		mTime1RadioButton = (RadioButton) findViewById(R.id.find_activity_time_1);
		mTime2RadioButton = (RadioButton) findViewById(R.id.find_activity_time_2);
		mTime3RadioButton = (RadioButton) findViewById(R.id.find_activity_time_3);
		mTime4RadioButton = (RadioButton) findViewById(R.id.find_activity_time_4);
		mTime5RadioButton = (RadioButton) findViewById(R.id.find_activity_time_5);
		mTypeTextView.setOnClickListener(this);
		mLocationTextView.setOnClickListener(this);
		mTimeTextView.setOnClickListener(this);
		mBackImageButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.find_activity_back_ib:
			finish();
			break;

		case R.id.find_activity_type:
			setChecked(TYPE_CHECKED);
			break;

		case R.id.find_activity_location:
			setChecked(LOCATION_CHECKED);
			break;

		case R.id.find_activity_time:
			setChecked(TIME_CHECKED);
			break;
		}
	}
}
