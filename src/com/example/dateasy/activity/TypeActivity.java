package com.example.dateasy.activity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.example.dateasy.R;
import com.example.dateasy.adapter.MyListViewAdapter;
import com.example.dateasy.adapter.TypeAndFindActivityListViewAdapter;
import com.example.dateasy.consts.Const;
import com.example.dateasy.model.Event;
import com.example.dateasy.net.EventCallback;
import com.example.dateasy.util.NetworkUtils;
import com.example.dateasy.util.Utils;

public class TypeActivity extends Activity {

	private ImageView mImageView;
	private ImageButton mBackImageButton;
	private ListView mListView;
	private TypeAndFindActivityListViewAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.type_activity_xml);
		initViews();
		// 设置标题和封面图片
		setTitleAndImage();
		mBackImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

		loadDataFromServer();
	}

	private void initViews() {
		// TODO Auto-generated method stub
		mImageView = (ImageView) findViewById(R.id.type_activity_iv);
		mBackImageButton = (ImageButton) findViewById(R.id.type_activity_back);
		mListView = (ListView) findViewById(R.id.type_activity_lv);

	}

	private void setTitleAndImage() {
		Utils.setActivityTitle(this, R.id.type_activity_title, "NAME");
		Bundle bundle = getIntent().getExtras();
		int imageId = bundle.getInt("IMAGE");
		mImageView.setBackgroundResource(imageId);
	}

	/**
	 * 从服务器端加载数据
	 */
	private void loadDataFromServer() {
		String url = null;
		Bundle bundle = getIntent().getExtras();
		switch (bundle.getString("NAME")) {
		case "文娱活动":
			url = Const.TYPE_ENTERTAINMENT_URL;
			break;

		case "户外活动":
			url = Const.TYPE_OUTDOOR_URL;
			break;
			
		case "组织聚会":
			url = Const.TYPE_GATHERING_URL;
			break;
			
		case "行业会议":
			url = Const.TYPE_MEETING_URL;
			break;
			
		case "活动报名":
			url = Const.TYPE_ACTIVITY_SIGNUP_URL;
			break;
			
		case "自定义活动":
			url = Const.TYPE_OTHERS_URL;
			break;
		}
		NetworkUtils.getData(url, new EventCallback() {

			@Override
			public void onResponse(final ArrayList<Event> arg0) {
				// TODO Auto-generated method stub
				mAdapter = new TypeAndFindActivityListViewAdapter(TypeActivity.this,
						arg0, Utils.getCity());
				mListView.setAdapter(mAdapter);
				mListView.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// TODO Auto-generated method stub
						Bundle bundle = new Bundle();
						Event event = arg0.get(position);
						bundle.putSerializable("DATA", event);
						Utils.toAnotherActivity(TypeActivity.this,
								SignupActivity.class, bundle);
					}
				});
			}

			@Override
			public void onError(Call arg0, Exception arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(TypeActivity.this, "网络连接失败，请检查你的网络连接",
						Toast.LENGTH_LONG).show();
			}
		});

	}
}
