package com.example.dateasy.fragment;

import com.example.dateasy.R;
import com.example.dateasy.activity.TypeActivity;
import com.example.dateasy.adapter.MyListViewAdapter;
import com.example.dateasy.consts.Const;
import com.example.dateasy.util.Utils;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * 发现Fragment
 * 
 * @author Xu
 * 
 */
public class ViewFragment extends SingleFragment implements OnClickListener {

	private ListView mListView;
	private MyListViewAdapter mAdapter;
	private ImageView mOutDoorActivitiesImageView;
	private ImageView mGatheringImageView;
	private ImageView mMeetingImageView;
	private ImageView mEntertainmentImageView;
	private ImageView mActiviySignUpImageView;
	private ImageButton mSurroundingsImageButton;
	private ImageButton mWeekendImageButton;

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.view_fragment;
	}

	@Override
	protected void createView(View view) {
		// TODO Auto-generated method stub
		mListView = (ListView) view.findViewById(R.id.view_lv);
		mAdapter = new MyListViewAdapter(this.getActivity());
		mListView.setAdapter(mAdapter);

		initViews(view);
	}

	private void initViews(View view) {
		// TODO Auto-generated method stub
		mOutDoorActivitiesImageView = (ImageView) view
				.findViewById(R.id.outdooractivities);
		mGatheringImageView = (ImageView) view.findViewById(R.id.gathering);
		mMeetingImageView = (ImageView) view.findViewById(R.id.meeting);
		mEntertainmentImageView = (ImageView) view
				.findViewById(R.id.entertainment);
		mActiviySignUpImageView = (ImageView) view
				.findViewById(R.id.activities_signup);
		mSurroundingsImageButton = (ImageButton) view
				.findViewById(R.id.surroundings_ib);
		mWeekendImageButton = (ImageButton) view.findViewById(R.id.weekend_ib);
		mOutDoorActivitiesImageView.setOnClickListener(this);
		mGatheringImageView.setOnClickListener(this);
		mMeetingImageView.setOnClickListener(this);
		mEntertainmentImageView.setOnClickListener(this);
		mActiviySignUpImageView.setOnClickListener(this);
		mOutDoorActivitiesImageView.setOnClickListener(this);
		mSurroundingsImageButton.setOnClickListener(this);
		mWeekendImageButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Bundle bundle = new Bundle();
		switch (v.getId()) {
		case R.id.outdooractivities:

			break;

		case R.id.gathering:

			break;

		case R.id.meeting:

			break;

		case R.id.entertainment:

			break;

		case R.id.activities_signup:

			break;

		case R.id.surroundings_ib:
			bundle.putString("NAME", Const.SURROUNDINGS);
			bundle.putInt("IMAGE", R.drawable.surroundings_hdpi);
			Utils.toAnotherActivity(getActivity(), TypeActivity.class, bundle);
			break;

		case R.id.weekend_ib:
			bundle.putString("NAME", Const.WEEKEND);
			bundle.putInt("IMAGE", R.drawable.weekend_hdpi);
			Utils.toAnotherActivity(getActivity(), TypeActivity.class, bundle);
			break;

		}
	}

}
