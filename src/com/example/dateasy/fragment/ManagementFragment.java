package com.example.dateasy.fragment;

import com.example.dateasy.R;
import com.example.dateasy.adapter.ManagementListViewAdapter;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * 管理界面Fragment
 * 
 * @author Xu
 * 
 */
public class ManagementFragment extends SingleFragment implements
		OnCheckedChangeListener {
	private RadioGroup mRadioGroup;
	private RadioButton mRadioButton;
	private ReleaseFragment mReleaseFragment;
	private RegisterFragment mRegisterFragment;

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.management_fragment;
	}

	@Override
	protected void createView(View view) {
		// TODO Auto-generated method stub
		mRadioGroup = (RadioGroup) view
				.findViewById(R.id.management_navigation);
		mRadioButton = (RadioButton) view.findViewById(R.id.management_release);
		mRadioGroup.setOnCheckedChangeListener(this);
		mRadioButton.setChecked(true);
		// FragmentManager fm = getChildFragmentManager();
		// FragmentTransaction transaction = fm.beginTransaction();
		// transaction.add(R.id.management_fragment_container, new
		// ReleaseFragment());
		// transaction.add(R.id.management_fragment_container, new
		// RegisterFragment());
		// transaction.commit();
	}

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

}
