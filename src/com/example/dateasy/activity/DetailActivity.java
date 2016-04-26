package com.example.dateasy.activity;

import com.example.dateasy.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class DetailActivity extends Activity implements OnClickListener{

	private ImageButton mBackImageButton;
	private TextView mTitleTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_activity_detail);
		initViews();
		
		String title = getIntent().getStringExtra("TITLE");
		setTitleText(title);		
	}

	private void initViews() {
		mBackImageButton = (ImageButton) findViewById(R.id.detail_back_ib);
		mTitleTextView = (TextView) findViewById(R.id.detail_topbar_title_tv);
		mBackImageButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.detail_back_ib:
			finish();
			break;

		default:
			break;
		}
	}
	
	private void setTitleText(String title) {
		mTitleTextView.setText(title);
	}
}
