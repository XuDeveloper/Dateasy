package com.example.dateasy.fragment;

import com.example.dateasy.R;
import com.example.dateasy.adapter.ManagementReleaseListViewAdapter;
import com.example.dateasy.util.LazyLoadFragment;
import com.example.dateasy.util.Utils;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * 管理界面Fragment
 * 
 * @author Xu
 * 
 */
public class ManagementFragment extends LazyLoadFragment implements
		OnCheckedChangeListener {
	private RadioGroup mRadioGroup;
	private RadioButton mRadioButton;
	private ReleaseFragment mReleaseFragment;
	private RegisterFragment mRegisterFragment;
	private TextView mUserNameTextView;


	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		FragmentManager fm = getChildFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		hideAllFragment(transaction);
		switch (checkedId) {
		case R.id.management_release:
			if (mReleaseFragment == null) {
				mReleaseFragment = new ReleaseFragment();
				transaction.add(R.id.management_fragment_container,
						mReleaseFragment);
			} else {
				transaction.show(mReleaseFragment);
			}
			break;

		case R.id.management_register:
			if (mRegisterFragment == null) {
				mRegisterFragment = new RegisterFragment();
				transaction.add(R.id.management_fragment_container,
						mRegisterFragment);
			} else {
				transaction.show(mRegisterFragment);
			}

			break;

		}
		transaction.commit();
	}

	private void hideAllFragment(FragmentTransaction transaction) {
		if (mReleaseFragment != null) {
			transaction.hide(mReleaseFragment);
		}
		if (mRegisterFragment != null) {
			transaction.hide(mRegisterFragment);
		}
	}

	@Override
	protected int setContentView() {
		// TODO Auto-generated method stub
		return R.layout.management_fragment;
	}

	@Override
	protected void lazyLoad() {
		// TODO Auto-generated method stub
		mUserNameTextView.setText(Utils.getmCurrentUser().getNick_name());
		mRadioGroup.setOnCheckedChangeListener(this);
		mRadioButton.setChecked(true);
	}

	@Override
	protected void initViews() {
		// TODO Auto-generated method stub
		mRadioGroup = findViewById(R.id.management_navigation);
		mRadioButton = findViewById(R.id.management_release);
		mUserNameTextView = findViewById(R.id.management_user_name);	
	}

}
