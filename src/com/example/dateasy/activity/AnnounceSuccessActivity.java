package com.example.dateasy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.dateasy.R;
import com.example.dateasy.util.Utils;
/**
 * 发布成功页
 * @author Xu
 *
 */
public class AnnounceSuccessActivity extends Activity {

	private TextView mReturnToManagementTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_activity_success);
		initViews();
	}

	private void initViews() {
		mReturnToManagementTextView = (TextView) findViewById(R.id.return_to_management);
		mReturnToManagementTextView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Bundle bundle = new Bundle();
				bundle.putBoolean("RETURN_TO_MANAGEMENT", true);
				Utils.toAnotherActivity(AnnounceSuccessActivity.this,
						MainActivity.class, bundle);
			}
		});
	}
}
