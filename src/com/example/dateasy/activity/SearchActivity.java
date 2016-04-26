package com.example.dateasy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.dateasy.R;

/**
 * 启动搜索Activity
 * 
 * @author Xu
 * 
 */
public class SearchActivity extends Activity implements OnClickListener {

	private ImageButton mBackImageButton;
	private ImageButton mSearchImageButton;
	private EditText mEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		initViews();
	}

	private void initViews() {
		mBackImageButton = (ImageButton) findViewById(R.id.search_back);
		mSearchImageButton = (ImageButton) findViewById(R.id.search_search_ib);
		mEditText = (EditText) findViewById(R.id.search_content);
		mBackImageButton.setOnClickListener(this);
		mSearchImageButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.search_back:
			finish();
			break;

		case R.id.search_search_ib:

			break;
		}

	}
}
