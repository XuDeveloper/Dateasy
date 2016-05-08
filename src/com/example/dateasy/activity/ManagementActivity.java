package com.example.dateasy.activity;

/**
 * 管理界面的item视图
 * @author Xu
 * 
 */
import com.example.dateasy.R;
import com.example.dateasy.fragment.*;

import com.example.dateasy.util.Utils;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class ManagementActivity extends Activity implements
		OnCheckedChangeListener, OnClickListener {
	private ImageButton mBackImageButton;
	private RadioGroup mRadioGroup;
	private RadioButton mRadioButton;
	private ManagementActivityManageFragment mManagementFragment;
	private ManagementActivityRegisterFragment mRegisterFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.management_activity);
		initViews();
		setTitle();
	}

	private void initViews() {
		// TODO Auto-generated method stub
		mBackImageButton = (ImageButton) findViewById(R.id.management_activity_back_ib);
		mRadioGroup = (RadioGroup) findViewById(R.id.management_activity_top_bar);
		mRadioButton = (RadioButton) findViewById(R.id.management_activity_manage);
		mRadioGroup.setOnCheckedChangeListener(this);
		mRadioButton.setChecked(true);
		mBackImageButton.setOnClickListener(this);
	}

	private void setTitle() {
		Utils.setActivityTitle(this, R.id.management_activity_topbar_title_tv,
				"EVENTNAME");
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		FragmentManager fm = getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		hideAllFragment(transaction);
		Bundle bundle = new Bundle();
		switch (checkedId) {
		case R.id.management_activity_manage:
			if (mManagementFragment == null) {
				bundle.putSerializable("DATA", getIntent().getExtras()
						.getSerializable("DATA"));
				mManagementFragment = new ManagementActivityManageFragment();
				mManagementFragment.setArguments(bundle);
				transaction.add(R.id.management_activity_container,
						mManagementFragment);
			} else {
				transaction.show(mManagementFragment);
			}
			break;

		case R.id.management_activity_register:
			if (mRegisterFragment == null) {
				mRegisterFragment = new ManagementActivityRegisterFragment();
				transaction.add(R.id.management_activity_container,
						mRegisterFragment);
			} else {
				transaction.show(mRegisterFragment);
			}

			break;

		}
		transaction.commit();
	}

	private void hideAllFragment(FragmentTransaction transaction) {
		if (mManagementFragment != null) {
			transaction.hide(mManagementFragment);
		}
		if (mRegisterFragment != null) {
			transaction.hide(mRegisterFragment);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Bundle bundle = new Bundle();
		switch (v.getId()) {
		case R.id.management_activity_back_ib:
			bundle.putBoolean("RETURN_TO_MANAGEMENT", true);
			Utils.toAnotherActivity(ManagementActivity.this,
					MainActivity.class, bundle);
			finish();
			break;

		default:
			break;
		}
	}
}
