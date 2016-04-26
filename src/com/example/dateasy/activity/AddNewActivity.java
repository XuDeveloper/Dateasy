package com.example.dateasy.activity;

import com.example.dateasy.R;
import com.example.dateasy.consts.Const;
import com.example.dateasy.util.Utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

/**
 * 新建活动的Activity
 * 
 * @author Administrator
 * 
 */
public class AddNewActivity extends Activity implements OnClickListener {

	private ImageButton mBackImageButton;
	private ImageButton mOutDoorActivitiesImageButton;
	private ImageButton mGatheringImageButton;
	private ImageButton mMeetingImageButton;
	private ImageButton mEntertainmentImageButton;
	private ImageButton mActiviySignUpImageButton;
	private ImageButton mOthersImageButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_activity);
		initViews();
	}

	private void initViews() {
		mBackImageButton = (ImageButton) findViewById(R.id.location_back_ib);
		mOutDoorActivitiesImageButton = (ImageButton) findViewById(R.id.outdooractivities_new_ib);
		mGatheringImageButton = (ImageButton) findViewById(R.id.gathering_new_ib);
		mMeetingImageButton = (ImageButton) findViewById(R.id.meeting_new_ib);
		mEntertainmentImageButton = (ImageButton) findViewById(R.id.entertainment_new_ib);
		mActiviySignUpImageButton = (ImageButton) findViewById(R.id.activities_signup_new_ib);
		mOthersImageButton = (ImageButton) findViewById(R.id.others_ib);
		mBackImageButton.setOnClickListener(this);
		mOutDoorActivitiesImageButton.setOnClickListener(this);
		mGatheringImageButton.setOnClickListener(this);
		mMeetingImageButton.setOnClickListener(this);
		mEntertainmentImageButton.setOnClickListener(this);
		mActiviySignUpImageButton.setOnClickListener(this);
		mOthersImageButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.location_back_ib:
			finish();
			Intent intent = new Intent(AddNewActivity.this, MainActivity.class);
			startActivity(intent);
			break;

		case R.id.outdooractivities_new_ib:
			Utils.toAnotherActivity(AddNewActivity.this, DetailActivity.class,
					"TITLE", Const.OUTDOOR_ACTIVITIES);
			break;

		case R.id.gathering_new_ib:
			Utils.toAnotherActivity(AddNewActivity.this, DetailActivity.class,
					"TITLE", Const.GATHERING);
			break;

		case R.id.meeting_new_ib:
			Utils.toAnotherActivity(AddNewActivity.this, DetailActivity.class,
					"TITLE", Const.MEETING);
			break;

		case R.id.entertainment_new_ib:
			Utils.toAnotherActivity(AddNewActivity.this, DetailActivity.class,
					"TITLE", Const.ENTERTAINMENT);
			break;

		case R.id.activities_signup_new_ib:
			Utils.toAnotherActivity(AddNewActivity.this, DetailActivity.class,
					"TITLE", Const.ACTIVITY_SIGNUP);
			break;

		case R.id.others_ib:
			Utils.toAnotherActivity(AddNewActivity.this, DetailActivity.class,
					"TITLE", Const.OTHERS);
			break;
		}
	}

}
