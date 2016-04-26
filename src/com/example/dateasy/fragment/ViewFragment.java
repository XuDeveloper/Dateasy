package com.example.dateasy.fragment;

import com.example.dateasy.R;
import com.example.dateasy.adapter.MyListViewAdapter;

import android.view.View;
import android.view.View.OnClickListener;
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
		mOutDoorActivitiesImageView.setOnClickListener(this);
		mGatheringImageView.setOnClickListener(this);
		mMeetingImageView.setOnClickListener(this);
		mEntertainmentImageView.setOnClickListener(this);
		mActiviySignUpImageView.setOnClickListener(this);
		mOutDoorActivitiesImageView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
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

		}
	}

}
