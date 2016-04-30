package com.example.dateasy.activity;

import java.util.Timer;
import java.util.TimerTask;

import com.example.dateasy.R;
import com.example.dateasy.consts.Const;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 主Activity，生成主界面
 * 
 * @author Xu
 * 
 */
public class MainActivity extends Activity implements OnCheckedChangeListener,
		OnClickListener {

	private RadioGroup mRadioGroup;
	private RadioButton mStarRadioButton;
	private RadioButton mAddImageButton;
	private RadioButton mManagementRadioButton;
	private ImageButton mLocationImageButton;
	private FavouriteFragment mFavouriteFragment;
	private ViewFragment mViewFragment;
	private ManagementFragment mManagementFragment;
	private MyBelongingsFragment mMyBelongingsFragment;
	private TextView mActionBarTextView;
	private TextView mCityTextView;
	private ImageButton mSearchImageButton;

	private String mCity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();

		// 判断当前显示哪一个framgent
		showFragment();

		// 更新城市
		updateCity();

	}


	/**
	 * 更新城市
	 */
	private void updateCity() {
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			mCity = bundle.getString("CITY");
			mCityTextView.setText(mCity);
		} else {
			mCity = Const.DEFAULT_CITY;
			mCityTextView.setText(mCity);
		}

	}

	/**
	 * 判断当前显示哪一个framgent
	 */
	private void showFragment() {
		if (getIntent().getExtras() != null) {
			if (getIntent().getExtras().getBoolean("RETURN_TO_MANAGEMENT")) {
				mManagementRadioButton.setChecked(true);
			} else {
				mStarRadioButton.setChecked(true);
			}
		} else {
			mStarRadioButton.setChecked(true);
		}
	}

	private void initViews() {
		mRadioGroup = (RadioGroup) findViewById(R.id.bottom_bar_rg);
		mStarRadioButton = (RadioButton) findViewById(R.id.star_rb);
		mManagementRadioButton = (RadioButton) findViewById(R.id.management_rb);
		mActionBarTextView = (TextView) findViewById(R.id.main_actionbar_tv);
		mSearchImageButton = (ImageButton) findViewById(R.id.search_ib);
		mLocationImageButton = (ImageButton) findViewById(R.id.main_location_ib);
		mAddImageButton = (RadioButton) findViewById(R.id.add_rb);
		mCityTextView = (TextView) findViewById(R.id.main_location_tv);
		mRadioGroup.setOnCheckedChangeListener(this);
		mLocationImageButton.setOnClickListener(this);
		mAddImageButton.setOnClickListener(this);
		mSearchImageButton.setOnClickListener(this);
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
			mActionBarTextView.setText("精选");
			break;

		case R.id.view_rb:
			if (mViewFragment == null) {
				mViewFragment = new ViewFragment();
				transaction.add(R.id.fragment_container, mViewFragment);
			} else {
				transaction.show(mViewFragment);
			}
			mActionBarTextView.setText("发现");
			break;

		case R.id.management_rb:
			if (mManagementFragment == null) {
				mManagementFragment = new ManagementFragment();
				transaction.add(R.id.fragment_container, mManagementFragment);
			} else {
				transaction.show(mManagementFragment);
			}
			mActionBarTextView.setText("管理");
			break;

		case R.id.mybelongings_rb:
			if (mMyBelongingsFragment == null) {
				mMyBelongingsFragment = new MyBelongingsFragment();
				transaction.add(R.id.fragment_container, mMyBelongingsFragment);
			} else {
				transaction.show(mMyBelongingsFragment);
			}
			mActionBarTextView.setText("我的");
			break;
		}
		transaction.commit();
	}

	/**
	 * 隐藏所有Fragment
	 * 
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
