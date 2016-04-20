package com.example.dateasy.activity;

import com.example.dateasy.R;
import com.example.dateasy.fragment.ManagementFragment;
import com.example.dateasy.fragment.MyBelongingsFragment;
import com.example.dateasy.fragment.FavouriteFragment;
import com.example.dateasy.fragment.ViewFragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity implements OnCheckedChangeListener,OnClickListener{

	private RadioGroup mRadioGroup;
	private RadioButton mRadioButton;
	private ImageButton mLocationImageButton;
	private FavouriteFragment mFavouriteFragment;
	private ViewFragment mViewFragment;
	private ManagementFragment mManagementFragment;
	private MyBelongingsFragment mMyBelongingsFragment;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRadioGroup = (RadioGroup) findViewById(R.id.bottom_bar_rg);
        mRadioGroup.setOnCheckedChangeListener(this);
        mRadioButton = (RadioButton) findViewById(R.id.star_rb);
        
        mRadioButton.setChecked(true);
        mLocationImageButton = (ImageButton)findViewById(R.id.location_ib);
        mLocationImageButton.setOnClickListener(this);
    }

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
			}
			else {
				transaction.show(mFavouriteFragment);
			}
			break;

		case R.id.view_rb:
			if (mViewFragment == null) {
				mViewFragment = new ViewFragment();
				transaction.add(R.id.fragment_container, mViewFragment);
			}
			else {
				transaction.show(mViewFragment);
			}
			break;
			
		case R.id.management_rb:
			if (mManagementFragment == null) {
				mManagementFragment = new ManagementFragment();
				transaction.add(R.id.fragment_container, mManagementFragment);
			}
			else {
				transaction.show(mManagementFragment);
			}
			break;
			
		case R.id.mybelongings_rb:
			if (mMyBelongingsFragment == null) {
				mMyBelongingsFragment = new MyBelongingsFragment();
				transaction.add(R.id.fragment_container, mMyBelongingsFragment);
			}
			else {
				transaction.show(mMyBelongingsFragment);
			}
			break;
		}
		transaction.commit();
	}

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
		switch(v.getId()){
			case R.id.location_ib:
				Intent intent = new Intent(MainActivity.this, LocationActivity.class);
				startActivity(intent);
		}
	}

}
