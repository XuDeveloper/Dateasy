package com.example.dateasy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dateasy.R;
import com.example.dateasy.util.Utils;

public class TypeActivity extends Activity {

	private TextView mTitleTextView;
	private ImageView mImageView;
	private ImageButton mBackImageButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.type_activity_xml);
		initViews();
		// 设置标题和封面图片
		setTitleAndImage();
		mBackImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	private void initViews() {
		// TODO Auto-generated method stub
		mTitleTextView = (TextView) findViewById(R.id.type_activity_title);
		mImageView = (ImageView) findViewById(R.id.type_activity_iv);
		mBackImageButton = (ImageButton) findViewById(R.id.type_activity_back);
	}

	private void setTitleAndImage() {
		Bundle bundle = getIntent().getExtras();
		String title = bundle.getString("NAME");
		int imageId = bundle.getInt("IMAGE");
		mTitleTextView.setText(title);
		mImageView.setBackgroundResource(imageId);
	}
}
