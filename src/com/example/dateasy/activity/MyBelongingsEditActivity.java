package com.example.dateasy.activity;

/**
 * 编辑用户资料
 * @author Xu
 * 
 */
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.example.dateasy.R;
import com.example.dateasy.util.Utils;

public class MyBelongingsEditActivity extends Activity implements
		OnClickListener {

	private ImageButton mBackImageButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mybelongings_edit);
		initViews();
	}

	private void initViews() {
		// TODO Auto-generated method stub
		mBackImageButton = (ImageButton) findViewById(R.id.mybelongings_back_ib);
		mBackImageButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Bundle bundle = new Bundle();
		switch (v.getId()) {
		case R.id.mybelongings_back_ib:
			bundle.putBoolean("RETURN_TO_MYBELONGINGS", true);
			Utils.toAnotherActivity(MyBelongingsEditActivity.this, MainActivity.class, bundle);
			finish();
			break;

		default:
			break;
		}
	}

}
