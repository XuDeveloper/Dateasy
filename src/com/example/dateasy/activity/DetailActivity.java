package com.example.dateasy.activity;

import com.example.dateasy.R;
import com.example.dateasy.util.Utils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * 新建活动详情页
 * @author Xu
 *
 */
public class DetailActivity extends Activity implements OnClickListener {

	private ImageButton mBackImageButton;
	private EditText mNewActivityNameEditText;
	private EditText mNewActivityTimeEditText;
	private EditText mNewActivityEndTimeEditText;
	private EditText mNewActivityAddressEditText;
	private EditText mNewActivityDescriptionEditText;
	private Button mAnnounceButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_activity_detail);
		initViews();

		Utils.setActivityTitle(this, R.id.detail_topbar_title_tv, "TITLE");
	}

	private void initViews() {
		mBackImageButton = (ImageButton) findViewById(R.id.detail_back_ib);
		mNewActivityNameEditText = (EditText) findViewById(R.id.new_activity_name);
		mNewActivityTimeEditText = (EditText) findViewById(R.id.new_activity_time);
		mNewActivityEndTimeEditText = (EditText) findViewById(R.id.new_activity_end_time);
		mNewActivityAddressEditText = (EditText) findViewById(R.id.new_activity_address);
		mNewActivityDescriptionEditText = (EditText) findViewById(R.id.new_activity_description);
		mAnnounceButton = (Button) findViewById(R.id.announce_bt);
		mBackImageButton.setOnClickListener(this);
		mAnnounceButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.detail_back_ib:
			finish();
			break;

		case R.id.announce_bt:
			finish();
			Utils.toAnotherActivity(DetailActivity.this, AnnounceSuccessActivity.class);
			break;
		}
	}

}
