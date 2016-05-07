package com.example.dateasy.activity;

import com.example.dateasy.R;
import com.example.dateasy.model.Event;
import com.example.dateasy.model.User;
import com.example.dateasy.util.Utils;
import com.zhy.http.okhttp.OkHttpUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 新建活动详情页
 * 
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
	private EditText mNewActivityCostEditText;
	private TextView mIfRecommendTextView;
	private Button mAnnounceButton;
	private String mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_activity_detail);
		initViews();

		if (getIntent().getExtras() != null) {
			Utils.setActivityTitle(this, R.id.detail_topbar_title_tv, "TITLE");
			mTitle = getIntent().getExtras().getString("TITLE");
		} else {
			getData();
		}
	}

	/**
	 * 将数据包装
	 */
	private void setDataAndSendToServer() {
		// TODO Auto-generated method stub
		Event event = new Event();
		event.setmEventName(mNewActivityNameEditText.getText().toString());
		event.setmType(mTitle);
		event.setmEventCover(null);
		event.setmStartTime(mNewActivityTimeEditText.getText().toString());
		event.setmEndTime(mNewActivityEndTimeEditText.getText().toString());
		event.setmEndApplyTime(mNewActivityEndTimeEditText.getText().toString());
		event.setmLocation(mNewActivityAddressEditText.getText().toString());
		event.setmDescription(mNewActivityDescriptionEditText.getText()
				.toString());
		event.setmIsRecommand(mIfRecommendTextView.getText().toString()
				.equals("是") ? true : false);
		event.setmCapacity(0);
		event.setmCount(0);
		int cost = Integer.parseInt(mNewActivityCostEditText.getText()
				.toString());
		event.setmCost(cost);
		event.setmRegisterUsers(null);
		User user = Utils.getmCurrentUser();
		event.setmReleaseUser(user);
	}

	private void initViews() {
		mBackImageButton = (ImageButton) findViewById(R.id.detail_back_ib);
		mNewActivityNameEditText = (EditText) findViewById(R.id.new_activity_name);
		mNewActivityTimeEditText = (EditText) findViewById(R.id.new_activity_time);
		mNewActivityEndTimeEditText = (EditText) findViewById(R.id.new_activity_end_time);
		mNewActivityAddressEditText = (EditText) findViewById(R.id.new_activity_address);
		mNewActivityDescriptionEditText = (EditText) findViewById(R.id.new_activity_description);
		mNewActivityCostEditText = (EditText) findViewById(R.id.new_activity_cost);
		mAnnounceButton = (Button) findViewById(R.id.announce_bt);
		mIfRecommendTextView = (TextView) findViewById(R.id.detail_ifrecommend_tv);
		mBackImageButton.setOnClickListener(this);
		mAnnounceButton.setOnClickListener(this);
		mIfRecommendTextView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.detail_back_ib:
			finish();
			Utils.setmCurrentReleaseEvent(null);
			break;

		case R.id.announce_bt:
			if (isComplete()) {
				if (!Utils.isLogin()) {
					saveData();
					Utils.toAnotherActivity(DetailActivity.this,
							LoginActivity.class);
				} else {
					setDataAndSendToServer();
					Utils.toAnotherActivity(DetailActivity.this,
							AnnounceSuccessActivity.class);
				}
				finish();
			} else {
				Toast.makeText(DetailActivity.this, "填写信息不完整！",
						Toast.LENGTH_LONG).show();
			}
			break;

		case R.id.detail_ifrecommend_tv:
			if (mIfRecommendTextView.getText().toString().equals("是")) {
				mIfRecommendTextView.setText("否");
			} else {
				mIfRecommendTextView.setText("是");
			}
			break;
		}
	}

	/**
	 * 保存数据
	 */
	private void saveData() {
		Bundle bundle = getIntent().getExtras();
		String title = bundle.getString("TITLE");
		Event event = new Event();
		event.setmEventName(mNewActivityNameEditText.getText().toString());
		event.setmType(title);
		event.setmEventCover(null);
		event.setmStartTime(mNewActivityTimeEditText.getText().toString());
		event.setmEndTime(mNewActivityEndTimeEditText.getText().toString());
		event.setmEndApplyTime(mNewActivityEndTimeEditText.getText().toString());
		event.setmLocation(mNewActivityAddressEditText.getText().toString());
		event.setmDescription(mNewActivityDescriptionEditText.getText()
				.toString());
		event.setmIsRecommand(mIfRecommendTextView.getText().toString()
				.equals("是") ? true : false);
		event.setmCapacity(0);
		event.setmCount(0);
		int cost = Integer.parseInt(mNewActivityCostEditText.getText()
				.toString());
		event.setmCost(cost);
		event.setmRegisterUsers(null);
		User user = Utils.getmCurrentUser();
		event.setmReleaseUser(user);
		Utils.setmCurrentReleaseEvent(event);
	}

	/**
	 * 获取数据
	 */
	private void getData() {
		if (Utils.getmCurrentReleaseEvent() != null) {
			Event event = Utils.getmCurrentReleaseEvent();
			TextView mTitleTextView = (TextView) findViewById(R.id.detail_topbar_title_tv);
			mTitleTextView.setText(event.getmType());
			mNewActivityNameEditText.setText(event.getmEventName());
			mNewActivityTimeEditText.setText(event.getmStartTime());
			mNewActivityEndTimeEditText.setText(event.getmEndTime());
			mNewActivityAddressEditText.setText(event.getmLocation());
			mNewActivityDescriptionEditText.setText(event.getmDescription());
			mIfRecommendTextView.setText(event.ismIsRecommand() ? "是" : "否");
			mNewActivityCostEditText.setText(event.getmCost() + "");
		}
	}

	/**
	 * 判断数据是否填写完整
	 */
	private boolean isComplete() {
		if (!mNewActivityNameEditText.getText().toString().equals("")
				&& !mNewActivityTimeEditText.getText().toString().equals("")
				&& !mNewActivityEndTimeEditText.getText().toString().equals("")
				&& !mNewActivityAddressEditText.getText().toString().equals("")
				&& !mNewActivityDescriptionEditText.getText().toString()
						.equals("")
				&& !mNewActivityCostEditText.getText().toString().equals("")) {
			return true;
		}
		return false;
	}
}
