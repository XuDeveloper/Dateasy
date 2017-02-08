package com.example.dateasy.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.dateasy.R;
import com.example.dateasy.activity.AddNewActivity;
import com.example.dateasy.activity.SignupActivity;
import com.example.dateasy.model.Event;
import com.example.dateasy.util.LazyLoadFragment;
import com.example.dateasy.util.Utils;

public class ManagementActivityManageFragment extends LazyLoadFragment implements
		OnClickListener {

	public static final int COST = 0;
	public static final int NOCOST = 1;

	private FrameLayout mCostFrameLayout;
	private FrameLayout mNoCostFrameLayout;
	private EditText mChangeEventNameEditText;
	private Button mChangeEventNameButton;
	private TextView mEventNameTextView;
	private TextView mEventTypeTextView;
	private TextView mEventCountTextView;
	private ImageButton mAddNewImageButton;
	private ImageButton mCheckActivityImageButton;

	private String mEventName;

	private void setData() {
		// TODO Auto-generated method stub
		Event event = (Event) getArguments().getSerializable("DATA");
		mEventNameTextView.setText(event.getmEventName());
		mEventTypeTextView.setText(event.getmType());
		mEventCountTextView.setText(event.getmCount() + "");
		if (event.getmCost() == 0) {
			changeCostStatus(NOCOST);
		} else {
			changeCostStatus(COST);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Bundle bundle = new Bundle();
		switch (v.getId()) {
		case R.id.management_event_manage_cost_fl:
			changeCostStatus(NOCOST);
			break;

		case R.id.management_event_manage_nocost_fl:
			changeCostStatus(COST);
			break;

		case R.id.management_event_manage_change_eventname_bt:
			mEventName = mChangeEventNameEditText.getText().toString();
			getActivity().runOnUiThread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					mEventNameTextView.setText(mEventName);
				}
			});
			break;

		case R.id.management_event_manage_checkactivity_ib:
			Utils.toAnotherActivity(getActivity(), SignupActivity.class);
			break;

		case R.id.management_event_manage_addnew_ib:
			Utils.toAnotherActivity(getActivity(), AddNewActivity.class);
			break;
		}
	}

	/**
	 * 收费框逻辑
	 */
	public void changeCostStatus(int choose) {
		if (choose == COST) {
			mCostFrameLayout.setVisibility(View.VISIBLE);
			mNoCostFrameLayout.setVisibility(View.GONE);
		} else {
			mCostFrameLayout.setVisibility(View.GONE);
			mNoCostFrameLayout.setVisibility(View.VISIBLE);
		}
	}

	@Override
	protected int setContentView() {
		// TODO Auto-generated method stub
		return R.layout.management_activity_manage_fragment;
	}

	@Override
	protected void lazyLoad() {
		// TODO Auto-generated method stub
		setData();
	}

	@Override
	protected void initViews() {
		// TODO Auto-generated method stub
		mCostFrameLayout = findViewById(R.id.management_event_manage_cost_fl);
		mNoCostFrameLayout = findViewById(R.id.management_event_manage_nocost_fl);
		mChangeEventNameEditText = findViewById(R.id.management_event_manage_change_eventname_et);
		mChangeEventNameButton = findViewById(R.id.management_event_manage_change_eventname_bt);
		mEventNameTextView = findViewById(R.id.management_event_manage_name_tv);
		mEventTypeTextView = findViewById(R.id.management_event_manage_type_tv);
		mEventCountTextView = findViewById(R.id.management_event_manage_count_tv);
		mAddNewImageButton = findViewById(R.id.management_event_manage_addnew_ib);
		mCheckActivityImageButton = findViewById(R.id.management_event_manage_checkactivity_ib);
		mCostFrameLayout.setOnClickListener(this);
		mNoCostFrameLayout.setOnClickListener(this);
		mChangeEventNameButton.setOnClickListener(this);
		mAddNewImageButton.setOnClickListener(this);
		mCheckActivityImageButton.setOnClickListener(this);
	}

}
