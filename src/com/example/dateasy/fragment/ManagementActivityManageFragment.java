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
import com.example.dateasy.util.Utils;

public class ManagementActivityManageFragment extends SingleFragment implements
		OnClickListener {

	public static final int COST = 0;
	public static final int NOCOST = 1;

	private FrameLayout mCostFrameLayout;
	private FrameLayout mNoCostFrameLayout;
	private EditText mChangeEventNameEditText;
	private Button mChangeEventNameButton;
	private TextView mEventNameTextView;
	private ImageButton mAddNewImageButton;
	private ImageButton mCheckActivityImageButton;

	private String mEventName;

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.management_activity_manage_fragment;
	}

	@Override
	protected void createView(View view) {
		// TODO Auto-generated method stub
		initViews(view);

		mEventName = mEventNameTextView.getText().toString();
	}

	private void initViews(View view) {
		// TODO Auto-generated method stub
		mCostFrameLayout = (FrameLayout) view
				.findViewById(R.id.management_event_manage_cost_fl);
		mNoCostFrameLayout = (FrameLayout) view
				.findViewById(R.id.management_event_manage_nocost_fl);
		mChangeEventNameEditText = (EditText) view
				.findViewById(R.id.management_event_manage_change_eventname_et);
		mChangeEventNameButton = (Button) view
				.findViewById(R.id.management_event_manage_change_eventname_bt);
		mEventNameTextView = (TextView) view
				.findViewById(R.id.management_event_manage_name_tv);
		mAddNewImageButton = (ImageButton) view
				.findViewById(R.id.management_event_manage_addnew_ib);
		mCheckActivityImageButton = (ImageButton) view
				.findViewById(R.id.management_event_manage_checkactivity_ib);
		mCostFrameLayout.setOnClickListener(this);
		mNoCostFrameLayout.setOnClickListener(this);
		mChangeEventNameButton.setOnClickListener(this);
		mAddNewImageButton.setOnClickListener(this);
		mCheckActivityImageButton.setOnClickListener(this);
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

}
