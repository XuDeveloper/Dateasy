package com.example.dateasy.activity;

import com.example.dateasy.R;
import com.example.dateasy.fragment.ManagementFragment;
import com.example.dateasy.fragment.MyBelongingsFragment;
import com.example.dateasy.fragment.FavouriteFragment;
import com.example.dateasy.fragment.ViewFragment;
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

/**
 * 主Activity，生成主界面
 * @author Administrator
 *
 */
public class MainActivity extends Activity implements OnCheckedChangeListener,
		OnClickListener {

	private RadioGroup mRadioGroup;
	private RadioButton mRadioButton;
	private RadioButton mAddImageButton;
	private ImageButton mLocationImageButton;
	private FavouriteFragment mFavouriteFragment;
	private ViewFragment mViewFragment;
	private ManagementFragment mManagementFragment;
	private MyBelongingsFragment mMyBelongingsFragment;
	private TextView mActionBar_tv;
	private ImageButton mSearch_bt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();
	}

	private void initViews() {
		mRadioGroup = (RadioGroup) findViewById(R.id.bottom_bar_rg);
		mRadioGroup.setOnCheckedChangeListener(this);
		mRadioButton = (RadioButton) findViewById(R.id.star_rb);
		mActionBar_tv = (TextView) findViewById(R.id.main_actionbar_tv);
		mSearch_bt = (ImageButton) findViewById(R.id.search_ib);
		mRadioButton.setChecked(true);
		mLocationImageButton = (ImageButton) findViewById(R.id.main_location_ib);
		mLocationImageButton.setOnClickListener(this);
		mAddImageButton = (RadioButton) findViewById(R.id.add_rb);
		mAddImageButton.setOnClickListener(this);
		mSearch_bt.setOnClickListener(this);
	}

	/**
	 * 处理底部导航栏的fragment事务
	 */
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		FragmentManager fm = getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		hideAllFragment(transaction);
		switch (checkedId) {
		case R.id.star_rb:
			if (mFavouriteFragment == null) {
				mFavouriteFragment = new FavouriteFragment();
				transaction.add(R.id.fragment_container, mFavouriteFragment);
			} else {
				transaction.show(mFavouriteFragment);
			}
			mActionBar_tv.setText("精选");
			break;

		case R.id.view_rb:
			if (mViewFragment == null) {
				mViewFragment = new ViewFragment();
				transaction.add(R.id.fragment_container, mViewFragment);
			} else {
				transaction.show(mViewFragment);
			}
			mActionBar_tv.setText("发现");
			break;

		case R.id.management_rb:
			if (mManagementFragment == null) {
				mManagementFragment = new ManagementFragment();
				transaction.add(R.id.fragment_container, mManagementFragment);
			} else {
				transaction.show(mManagementFragment);
			}
			mActionBar_tv.setText("管理");
			break;

		case R.id.mybelongings_rb:
			if (mMyBelongingsFragment == null) {
				mMyBelongingsFragment = new MyBelongingsFragment();
				transaction.add(R.id.fragment_container, mMyBelongingsFragment);
			} else {
				transaction.show(mMyBelongingsFragment);
			}
			mActionBar_tv.setText("我的");
			break;
		}
		transaction.commit();
	}

	/**
	 * 隐藏所有Fragment
	 * @param transaction
	 */
	private void hideAllFragment(FragmentTransaction transaction) {
		if (mFavouriteFragment != null) {
			transaction.hide(mFavouriteFragment);
		}
		if (mViewFragment != null) {
			transaction.hide(mViewFragment);
		}
		if (mManagementFragment != null) {
			transaction.hide(mManagementFragment);
		}
		if (mMyBelongingsFragment != null) {
			transaction.hide(mMyBelongingsFragment);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.main_location_ib:
			Utils.toAnotherActivity(MainActivity.this, LocationActivity.class);
			break;
		case R.id.add_rb:
			Utils.toAnotherActivity(MainActivity.this, AddNewActivity.class);
			break;
		case R.id.search_ib:
			Utils.toAnotherActivity(MainActivity.this, SearchActivity.class);
			break;
		}
	}

}
