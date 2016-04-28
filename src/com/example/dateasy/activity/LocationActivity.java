package com.example.dateasy.activity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.dateasy.R;
import com.example.dateasy.util.Utils;
import com.example.pinnedheaderlistviewdemo.City;
import com.example.pinnedheaderlistviewdemo.MyComparator;
import com.example.pinnedheaderlistviewdemo.MySectionIndexer;
import com.example.pinnedheaderlistviewdemo.adapter.CityListAdapter;
import com.example.pinnedheaderlistviewdemo.adapter.LocationGridViewAdapter;
import com.example.pinnedheaderlistviewdemo.db.CityDao;
import com.example.pinnedheaderlistviewdemo.db.DBHelper;
import com.example.pinnedheaderlistviewdemo.view.BladeView;

import com.example.pinnedheaderlistviewdemo.view.NoScrollGridView;
import com.example.pinnedheaderlistviewdemo.view.PinnedHeaderListView;

/**
 * LocationActivity，选择城市界面
 * 
 * @author Administrator
 * 
 */
public class LocationActivity extends Activity implements OnClickListener,
		com.example.pinnedheaderlistviewdemo.view.BladeView.OnItemClickListener {
	private static final int LISTVIEW = 0;
	private static final int GRIDVIEW = 1;
	private static final int COPY_DB_SUCCESS = 10;
	private static final int COPY_DB_FAILED = 11;
	protected static final int QUERY_CITY_FINISH = 12;
	// 获取存储地址
	public static String APP_DIR = Environment.getExternalStorageDirectory()
			.getAbsolutePath() + "/test/";
	private static final String ALL_CHARACTER = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	protected static final String TAG = null;
	private String[] sections = { "热门", "A", "B", "C", "D", "E", "F", "G", "H",
			"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
			"V", "W", "X", "Y", "Z" };

	private MySectionIndexer mIndexer;
	private NoScrollGridView mGridView;
	private LocationGridViewAdapter mGridViewAdapter;
	private float scale;
	private List<City> cityList = new ArrayList<City>();
	private List<City> allCityList = new ArrayList<City>();
	private DBHelper helper;
	private ImageButton mBack_ib;
	private CityListAdapter mCityListAdapter;

	private int[] counts;
	private int[] countsAll;
	private PinnedHeaderListView mListView;
	private Handler handler = new Handler() {

		public void handleMessage(Message msg) {
			switch (msg.what) {
			case QUERY_CITY_FINISH:

				if (mCityListAdapter == null) {

					mIndexer = new MySectionIndexer(sections, countsAll);

					mCityListAdapter = new CityListAdapter(allCityList,
							mIndexer, getApplicationContext());
					mGridViewAdapter = new LocationGridViewAdapter(
							getApplicationContext(), cityList, 12);
					Log.i("TAG", cityList.size() + "");
					mListView.addHeaderView(mGridView);
					mGridView.setAdapter(mGridViewAdapter);
					mGridView.setPadding(0, (int) (40 * scale + 0.5f), 25, 0);
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.location_activity_xml);

		helper = new DBHelper();

		copyDBFile();
		findView();
	}

	/**
	 * 复制数据库文件到手机内存卡
	 */
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

	/**
	 * 将Assets的数据库文件复制到手机内存卡
	 */
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
		mListView.setLabelFor(LISTVIEW);
		BladeView mLetterListView = (BladeView) findViewById(R.id.mLetterListView);
		mBack_ib = (ImageButton) findViewById(R.id.location_back_ib);
		mGridView = new NoScrollGridView(this);
		mGridView.setLabelFor(GRIDVIEW);
		mGridView.setNumColumns(4);

		scale = this.getResources().getDisplayMetrics().density;
		mLetterListView.setOnItemClickListener(this);
		mBack_ib.setOnClickListener(this);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Bundle bundle = new Bundle();
				bundle.putString("CITY", allCityList.get(position - 1)
						.getName());
				Utils.toAnotherActivity(LocationActivity.this,
						MainActivity.class, bundle);
			}
		});
		mGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Bundle bundle = new Bundle();
				bundle.putString("CITY", cityList.get(position).getName());
				Utils.toAnotherActivity(LocationActivity.this,
						MainActivity.class, bundle);
			}
		});

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.location_back_ib:
			finish();
		}
	}

	@Override
	public void onItemClick(String s) {
		// TODO Auto-generated method stub
		if (s != null) {
			if (s.compareTo("热点") == 0) {
				s = "#";
			}
			int section = ALL_CHARACTER.indexOf(s);

			int position = mIndexer.getPositionForSection(section);

			if (position != -1) {
				mListView.setSelection(position);
			}
		}
	}

}