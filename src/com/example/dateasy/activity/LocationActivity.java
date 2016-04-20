package com.example.dateasy.activity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.example.dateasy.*;

import com.example.pinnedheaderlistviewdemo.City;
import com.example.pinnedheaderlistviewdemo.MyComparator;
import com.example.pinnedheaderlistviewdemo.MySectionIndexer;
import com.example.pinnedheaderlistviewdemo.adapter.CityListAdapter;
import com.example.pinnedheaderlistviewdemo.adapter.LocationGridViewAdapter;
import com.example.pinnedheaderlistviewdemo.db.CityDao;
import com.example.pinnedheaderlistviewdemo.db.DBHelper;
import com.example.pinnedheaderlistviewdemo.view.BladeView;
import com.example.pinnedheaderlistviewdemo.view.BladeView.OnItemClickListener;
import com.example.pinnedheaderlistviewdemo.view.NoScrollGridView;
import com.example.pinnedheaderlistviewdemo.view.PinnedHeaderListView;

public class LocationActivity extends Activity {

	private static final int COPY_DB_SUCCESS = 10;
	private static final int COPY_DB_FAILED = 11;
	protected static final int QUERY_CITY_FINISH = 12;
	private MySectionIndexer mIndexer;
	private NoScrollGridView mGridView;
	private LocationGridViewAdapter mGridViewAdapter;
	private float scale;
	private List<City> cityList = new ArrayList<City>();
	private List<City> allCityList = new ArrayList<City>();
	public static String APP_DIR = Environment.getExternalStorageDirectory()
			.getAbsolutePath() + "/test/";
	private Handler handler = new Handler() {

		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case QUERY_CITY_FINISH:

				if (mCityListAdapter == null) {

					mIndexer = new MySectionIndexer(sections, countsAll);

					mCityListAdapter = new CityListAdapter(allCityList,
							mIndexer, getApplicationContext());
					mGridViewAdapter = new LocationGridViewAdapter(
							getApplicationContext(), cityList, 12);
					Log.i("TAG", cityList.size() + "");
					mGridView.setAdapter(mGridViewAdapter);
					mGridView.setPadding(0, 56, 20, 0);
					mListView.addHeaderView(mGridView);
					mListView.setAdapter(mCityListAdapter);

					mListView.setOnScrollListener(mCityListAdapter);

					mListView.setPinnedHeaderView(LayoutInflater.from(
							getApplicationContext()).inflate(
							R.layout.location_lv_group_item, mListView, false));

				} else if (mCityListAdapter != null) {
					mCityListAdapter.notifyDataSetChanged();
				}

				break;

			case COPY_DB_SUCCESS:
				requestData();
				break;
			default:
				break;
			}
		};
	};
	private DBHelper helper;

	private CityListAdapter mCityListAdapter;
	private static final String ALL_CHARACTER = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	protected static final String TAG = null;

	private String[] sections = { "热点", "A", "B", "C", "D", "E", "F", "G", "H",
			"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
			"V", "W", "X", "Y", "Z" };
	private int[] counts;
	private int[] countsAll;
	private PinnedHeaderListView mListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.location_activity_xml);

		helper = new DBHelper();

		copyDBFile();
		findView();
	}

	private void copyDBFile() {
		File file = new File(APP_DIR + "/city.db");
		if (file.exists()) {
			requestData();

		} else { 
			Runnable task = new Runnable() {

				@Override
				public void run() {

					copyAssetsFile2SDCard("city.db");
				}
			};

			new Thread(task).start();
		}
	}

	
	private void copyAssetsFile2SDCard(String fileName) {

		File desDir = new File(APP_DIR);
		if (!desDir.exists()) {
			desDir.mkdirs();
		}

		
		File file = new File(APP_DIR + fileName);
		if (file.exists()) {
			file.delete();
		}

		try {
			InputStream in = getAssets().open(fileName);
			FileOutputStream fos = new FileOutputStream(file);
			int len = -1;
			byte[] buf = new byte[1024];
			while ((len = in.read(buf)) > 0) {
				fos.write(buf, 0, len);
			}

			fos.flush();
			fos.close();

			handler.sendEmptyMessage(COPY_DB_SUCCESS);
			Log.i("TAG", COPY_DB_SUCCESS + "");
		} catch (Exception e) {
			e.printStackTrace();
			handler.sendEmptyMessage(COPY_DB_FAILED);
		}
	}

	private void requestData() {

		Runnable task = new Runnable() {

			@Override
			public void run() {
				CityDao dao = new CityDao(helper);

				List<City> hot = dao.getHotCities(); 
				List<City> all = dao.getAllCities(); 

				if (all != null) {

					Collections.sort(all, new MyComparator()); 

					cityList.addAll(hot);
					cityList.addAll(all);
					allCityList.addAll(all);

					
					counts = new int[sections.length];
					countsAll = new int[sections.length];
					countsAll[0] = 0;
					counts[0] = hot.size(); 

					for (City city : all) { 

						String firstCharacter = city.getSortKey();
						int index = ALL_CHARACTER.indexOf(firstCharacter);
						counts[index]++;
						countsAll[index]++;
					}

					handler.sendEmptyMessage(QUERY_CITY_FINISH);
					Log.i("TAG", QUERY_CITY_FINISH + "");
				}
			}
		};

		new Thread(task).start();
	}

	private void findView() {

		mListView = (PinnedHeaderListView) findViewById(R.id.mListView);
		BladeView mLetterListView = (BladeView) findViewById(R.id.mLetterListView);
		mGridView = new NoScrollGridView(this);
		mGridView.setNumColumns(4);
		scale = this.getResources().getDisplayMetrics().density;
		mLetterListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(String s) {
				if (s != null) {
					if (s.compareTo("热点") == 0) {
						s = "#";
					}
					int section = ALL_CHARACTER.indexOf(s);

					int position = mIndexer.getPositionForSection(section);

					Log.i(TAG, "s:" + s + ",section:" + section + ",position:"
							+ position);

					if (position != -1) {
						mListView.setSelection(position);
					} else {

					}
				}

			}
		});
	}

}