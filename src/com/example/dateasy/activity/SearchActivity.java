package com.example.dateasy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dateasy.R;
import com.example.dateasy.util.Utils;

/**
 * 启动搜索Activity
 * 
 * @author Xu
 * 
 */
public class SearchActivity extends Activity implements OnClickListener {

	private ImageButton mBackImageButton;
	private ImageButton mSearchImageButton;
	private TextView mHint1TextView;
	private TextView mHint2TextView;
	private TextView mHint3TextView;
	private TextView mHint4TextView;
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
		mHint1TextView = (TextView) findViewById(R.id.search_1_tv);
		mHint2TextView = (TextView) findViewById(R.id.search_2_tv);
		mHint3TextView = (TextView) findViewById(R.id.search_3_tv);
		mHint4TextView = (TextView) findViewById(R.id.search_4_tv);
		mBackImageButton.setOnClickListener(this);
		mSearchImageButton.setOnClickListener(this);
		mHint1TextView.setOnClickListener(this);
		mHint2TextView.setOnClickListener(this);
		mHint3TextView.setOnClickListener(this);
		mHint4TextView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Bundle bundle = new Bundle();
		switch (v.getId()) {
		case R.id.search_back:
			Utils.toAnotherActivity(SearchActivity.this, MainActivity.class);
			finish();
			break;

		case R.id.search_search_ib:
			bundle.putString("TITLE", mEditText.getText().toString());
			Utils.toAnotherActivity(SearchActivity.this, FindActivity.class, bundle);
			finish();
			break;
			
		case R.id.search_1_tv:
			mEditText.setText(mHint1TextView.getText().toString());
			break;
			
		case R.id.search_2_tv:
			mEditText.setText(mHint2TextView.getText().toString());
			break;
			
		case R.id.search_3_tv:
			mEditText.setText(mHint3TextView.getText().toString());
			break;
			
		case R.id.search_4_tv:
			mEditText.setText(mHint4TextView.getText().toString());
			break;
		}
		

	}
}
