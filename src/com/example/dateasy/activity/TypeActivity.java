package com.example.dateasy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.dateasy.R;
import com.example.dateasy.adapter.FindActivityListViewAdapter;
import com.example.dateasy.util.Utils;

public class TypeActivity extends Activity {

	private ImageView mImageView;
	private ImageButton mBackImageButton;
	private ListView mListView;
	private FindActivityListViewAdapter mAdapter;

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
		mImageView = (ImageView) findViewById(R.id.type_activity_iv);
		mBackImageButton = (ImageButton) findViewById(R.id.type_activity_back);
		mListView = (ListView) findViewById(R.id.type_activity_lv);
		mAdapter = new FindActivityListViewAdapter(TypeActivity.this);
		mListView.setAdapter(mAdapter);
	}

	private void setTitleAndImage() {
		Utils.setActivityTitle(this, R.id.type_activity_title, "NAME");
		Bundle bundle = getIntent().getExtras();
		int imageId = bundle.getInt("IMAGE");
		mImageView.setBackgroundResource(imageId);
	}
}
