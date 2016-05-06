package com.example.dateasy.activity;

/**
 * 发现Activity
 * @author Xu
 */
import java.util.ArrayList;

import okhttp3.Call;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.aigestudio.wheelpicker.core.AbstractWheelDecor;
import com.aigestudio.wheelpicker.core.AbstractWheelPicker;
import com.aigestudio.wheelpicker.view.WheelCrossPicker;
import com.aigestudio.wheelpicker.widget.curved.WheelDayPicker;
import com.aigestudio.wheelpicker.widget.curved.WheelMonthPicker;
import com.aigestudio.wheelpicker.widget.curved.WheelYearPicker;
import com.example.dateasy.R;
import com.example.dateasy.adapter.TypeAndFindActivityListViewAdapter;
import com.example.dateasy.consts.Const;
import com.example.dateasy.model.Event;
import com.example.dateasy.net.EventCallback;
import com.example.dateasy.util.NetworkUtils;
import com.example.dateasy.util.Utils;

public class FindActivity extends Activity implements OnClickListener,
		OnDismissListener {

	private static int TYPE_CHECKED = 0;
	private static int LOCATION_CHECKED = 1;
	private static int TIME_CHECKED = 2;

	private ImageButton mBackImageButton;
	private TextView mTypeTextView;
	private TextView mTypeBottomTextView;
	private TextView mLocationTextView;
	private TextView mLocationBottomTextView;
	private TextView mTimeTextView;
	private TextView mTimeBottomTextView;
	private RadioGroup mTypeRadioGroup;
	private RadioButton mTypeOutDoorActivitiesRadioButton;
	private RadioButton mTypeGatheringRadioButton;
	private RadioButton mTypeEntertainmentRadioButton;
	private RadioButton mTypeMeetingRadioButton;
	private RadioButton mTypeActivitySignupRadioButton;
	private RadioButton mTypeOthersRadioButton;
	private RadioGroup mLocationRadioGroup;
	private RadioButton mLocation1RadioButton;
	private RadioButton mLocation2RadioButton;
	private RadioButton mLocation3RadioButton;
	private RadioButton mLocation4RadioButton;
	private RadioButton mLocation5RadioButton;
	private RadioButton mLocation6RadioButton;
	private RadioGroup mTimeRadioGroup;
	private RadioButton mTime1RadioButton;
	private RadioButton mTime2RadioButton;
	private RadioButton mTime3RadioButton;
	private RadioButton mTime4RadioButton;
	private RadioButton mTime5RadioButton;
	private PopupWindow mTimeWheelPicker;
	private View mTimeWheelPickerView;
	private TextView mTitleTextView;
	private ListView mListView;
	private TypeAndFindActivityListViewAdapter mAdapter;
	private int mScreenWidth;
	private int mScreenHeight;
	private WindowManager mWindowManager;
	private WheelYearPicker mPickerYear;
	private WheelMonthPicker mPickerMonth;
	private WheelDayPicker mPickerDay;
	private int padding;
	private int padding2x;
	private int mTextColor = 0xff666666;
	private int mCurrentTextColor = 0xff00b6bc;
	private int mLabelColor = 0xff00b6bc;
	private int mStateYear, mStateMonth, mStateDay;
	private String mYear, mMonth, mDay;
	private AbstractWheelPicker.OnWheelChangeListener mOnWheelChangeListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.find_activity);
		initViews();
		initPopupWindow();
		setTitleText();

	}

	private void initPopupWindow() {
		padding = getResources().getDimensionPixelSize(
				com.aigestudio.wheelpicker.R.dimen.WheelPadding);
		padding2x = padding * 2;
		mPickerYear.setPadding(0, padding, padding2x, padding);
		mPickerMonth.setPadding(0, padding, padding2x - 1, padding);
		mPickerDay.setPadding(0, padding, padding2x, padding);
		mPickerYear.setTextColor(mTextColor);
		mPickerMonth.setTextColor(mTextColor);
		mPickerDay.setTextColor(mTextColor);
		mPickerYear.setCurrentTextColor(mCurrentTextColor);
		mPickerMonth.setCurrentTextColor(mCurrentTextColor);
		mPickerDay.setCurrentTextColor(mCurrentTextColor);
		addLabel(mPickerYear, "年");
		addLabel(mPickerMonth, "月");
		addLabel(mPickerDay, "日");
		initListener(mPickerYear, 0);
		initListener(mPickerMonth, 1);
		initListener(mPickerDay, 2);
		mWindowManager = getWindowManager();
		mScreenWidth = mWindowManager.getDefaultDisplay().getWidth();
		mScreenHeight = mWindowManager.getDefaultDisplay().getHeight();
		mTimeWheelPicker = new PopupWindow(mTimeWheelPickerView, mScreenWidth,
				350, true);
		mTimeWheelPicker.setAnimationStyle(R.style.anim_sharemenu_inandout);
		mTimeWheelPicker.setBackgroundDrawable(new BitmapDrawable());
		mTimeWheelPicker.setOnDismissListener(this);
	}

	/**
	 * 设置标题逻辑
	 */
	private void setTitleText() {
		// TODO Auto-generated method stub
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			String title = bundle.getString("TITLE");
			mTitleTextView.setText(title);
			if (title.equals(Const.OUTDOOR_ACTIVITIES)) {
				mTypeOutDoorActivitiesRadioButton.setChecked(true);
			} else if (title.equals(Const.GATHERING)) {
				mTypeGatheringRadioButton.setChecked(true);
			} else if (title.equals(Const.ENTERTAINMENT)) {
				mTypeEntertainmentRadioButton.setChecked(true);
			} else if (title.equals(Const.MEETING)) {
				mTypeMeetingRadioButton.setChecked(true);
			} else if (title.equals(Const.ACTIVITY_SIGNUP)) {
				mTypeActivitySignupRadioButton.setChecked(true);
			} else if (title.equals(Const.OTHERS)) {
				mTypeOthersRadioButton.setChecked(true);
			}
			// 加载数据
			loadDataFromServer(title);
		} else {
			mTypeOutDoorActivitiesRadioButton.setChecked(true);
		}
	}

	/**
	 * 处理逻辑
	 */
	private void setChecked(int choose) {
		mLocation1RadioButton.setChecked(true);
		mTime1RadioButton.setChecked(true);
		if (choose == TYPE_CHECKED) {
			mTypeBottomTextView.setVisibility(View.VISIBLE);
			mLocationBottomTextView.setVisibility(View.INVISIBLE);
			mTimeBottomTextView.setVisibility(View.INVISIBLE);
			mTypeRadioGroup.setVisibility(View.VISIBLE);
			mLocationRadioGroup.setVisibility(View.INVISIBLE);
			mTimeRadioGroup.setVisibility(View.INVISIBLE);
		} else if (choose == LOCATION_CHECKED) {
			mTypeBottomTextView.setVisibility(View.INVISIBLE);
			mLocationBottomTextView.setVisibility(View.VISIBLE);
			mTimeBottomTextView.setVisibility(View.INVISIBLE);
			mTypeRadioGroup.setVisibility(View.INVISIBLE);
			mLocationRadioGroup.setVisibility(View.VISIBLE);
			mTimeRadioGroup.setVisibility(View.INVISIBLE);
		} else {
			mTypeBottomTextView.setVisibility(View.INVISIBLE);
			mLocationBottomTextView.setVisibility(View.INVISIBLE);
			mTimeBottomTextView.setVisibility(View.VISIBLE);
			mTypeRadioGroup.setVisibility(View.INVISIBLE);
			mLocationRadioGroup.setVisibility(View.INVISIBLE);
			mTimeRadioGroup.setVisibility(View.VISIBLE);
		}
	}

	private void initViews() {
		// TODO Auto-generated method stub
		mBackImageButton = (ImageButton) findViewById(R.id.find_activity_back_ib);
		mTypeTextView = (TextView) findViewById(R.id.find_activity_type);
		mTypeBottomTextView = (TextView) findViewById(R.id.find_activity_type_bottombar);
		mLocationTextView = (TextView) findViewById(R.id.find_activity_location);
		mLocationBottomTextView = (TextView) findViewById(R.id.find_activity_location_bottombar);
		mTimeTextView = (TextView) findViewById(R.id.find_activity_time);
		mTimeBottomTextView = (TextView) findViewById(R.id.find_activity_time_bottombar);
		mTypeRadioGroup = (RadioGroup) findViewById(R.id.find_activity_type_detail);
		mLocationRadioGroup = (RadioGroup) findViewById(R.id.find_activity_location_detail);
		mTimeRadioGroup = (RadioGroup) findViewById(R.id.find_activity_time_detail);
		mTitleTextView = (TextView) findViewById(R.id.find_activity_title);
		mTypeOutDoorActivitiesRadioButton = (RadioButton) findViewById(R.id.find_activity_type_1);
		mTypeGatheringRadioButton = (RadioButton) findViewById(R.id.find_activity_type_2);
		mTypeEntertainmentRadioButton = (RadioButton) findViewById(R.id.find_activity_type_3);
		mTypeMeetingRadioButton = (RadioButton) findViewById(R.id.find_activity_type_4);
		mTypeActivitySignupRadioButton = (RadioButton) findViewById(R.id.find_activity_type_5);
		mTypeOthersRadioButton = (RadioButton) findViewById(R.id.find_activity_type_6);
		mTypeOutDoorActivitiesRadioButton.setOnClickListener(this);
		mTypeGatheringRadioButton.setOnClickListener(this);
		mTypeEntertainmentRadioButton.setOnClickListener(this);
		mTypeMeetingRadioButton.setOnClickListener(this);
		mTypeActivitySignupRadioButton.setOnClickListener(this);
		mTypeOthersRadioButton.setOnClickListener(this);
		mLocation1RadioButton = (RadioButton) findViewById(R.id.find_activity_location_1);
		mLocation2RadioButton = (RadioButton) findViewById(R.id.find_activity_location_2);
		mLocation3RadioButton = (RadioButton) findViewById(R.id.find_activity_location_3);
		mLocation4RadioButton = (RadioButton) findViewById(R.id.find_activity_location_4);
		mLocation5RadioButton = (RadioButton) findViewById(R.id.find_activity_location_5);
		mLocation6RadioButton = (RadioButton) findViewById(R.id.find_activity_location_6);
		mTime1RadioButton = (RadioButton) findViewById(R.id.find_activity_time_1);
		mTime2RadioButton = (RadioButton) findViewById(R.id.find_activity_time_2);
		mTime3RadioButton = (RadioButton) findViewById(R.id.find_activity_time_3);
		mTime4RadioButton = (RadioButton) findViewById(R.id.find_activity_time_4);
		mTime5RadioButton = (RadioButton) findViewById(R.id.find_activity_time_5);
		mListView = (ListView) findViewById(R.id.find_lv);
		mTimeWheelPickerView = getLayoutInflater().inflate(
				R.layout.time_wheel_picker, null);
		mPickerYear = (WheelYearPicker) mTimeWheelPickerView
				.findViewById(R.id.test_year);
		mPickerMonth = (WheelMonthPicker) mTimeWheelPickerView
				.findViewById(R.id.test_month);
		mPickerDay = (WheelDayPicker) mTimeWheelPickerView
				.findViewById(R.id.test_day);
		mTypeTextView.setOnClickListener(this);
		mLocationTextView.setOnClickListener(this);
		mTimeTextView.setOnClickListener(this);
		mBackImageButton.setOnClickListener(this);
		mTime5RadioButton.setOnClickListener(this);
	}

	private void addLabel(WheelCrossPicker picker, final String label) {
		picker.setWheelDecor(true, new AbstractWheelDecor() {
			@Override
			public void drawDecor(Canvas canvas, Rect rectLast, Rect rectNext,
					Paint paint) {
				paint.setColor(mLabelColor);
				paint.setTextAlign(Paint.Align.CENTER);
				paint.setTextSize(padding * 1.5F);
				canvas.drawText(label, rectNext.centerX(), rectNext.centerY()
						- (paint.ascent() + paint.descent()) / 2.0F, paint);
			}

		});
	}

	private void initListener(final WheelCrossPicker picker, final int type) {
		picker.setOnWheelChangeListener(new AbstractWheelPicker.OnWheelChangeListener() {
			@Override
			public void onWheelScrolling(float deltaX, float deltaY) {
				if (null != mOnWheelChangeListener)
					mOnWheelChangeListener.onWheelScrolling(deltaX, deltaY);
			}

			@Override
			public void onWheelSelected(int index, String data) {
				if (type == 0)
					mYear = data;
				if (type == 1)
					mMonth = data;
				if (type == 2)
					mDay = data;
				if (isValidDate()) {
					if (type == 0 || type == 1)
						mPickerDay.setCurrentYearAndMonth(
								Integer.valueOf(mYear), Integer.valueOf(mMonth));
					if (null != mOnWheelChangeListener)
						mOnWheelChangeListener.onWheelSelected(-1, mYear + "-"
								+ mMonth + "-" + mDay);
				}
			}

			@Override
			public void onWheelScrollStateChanged(int state) {
				if (type == 0)
					mStateYear = state;
				if (type == 1)
					mStateMonth = state;
				if (type == 2)
					mStateDay = state;
				if (null != mOnWheelChangeListener)
					checkState(mOnWheelChangeListener);
			}
		});
	}

	private boolean isValidDate() {
		return !TextUtils.isEmpty(mYear) && !TextUtils.isEmpty(mMonth)
				&& !TextUtils.isEmpty(mDay);
	}

	private void checkState(AbstractWheelPicker.OnWheelChangeListener listener) {
		if (mStateYear == AbstractWheelPicker.SCROLL_STATE_IDLE
				&& mStateMonth == AbstractWheelPicker.SCROLL_STATE_IDLE
				&& mStateDay == AbstractWheelPicker.SCROLL_STATE_IDLE) {
			listener.onWheelScrollStateChanged(AbstractWheelPicker.SCROLL_STATE_IDLE);
		}
		if (mStateYear == AbstractWheelPicker.SCROLL_STATE_SCROLLING
				|| mStateMonth == AbstractWheelPicker.SCROLL_STATE_SCROLLING
				|| mStateDay == AbstractWheelPicker.SCROLL_STATE_SCROLLING) {
			listener.onWheelScrollStateChanged(AbstractWheelPicker.SCROLL_STATE_SCROLLING);
		}
		if (mStateYear + mStateMonth + mStateDay == 1) {
			listener.onWheelScrollStateChanged(AbstractWheelPicker.SCROLL_STATE_DRAGGING);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.find_activity_back_ib:
			finish();
			break;

		case R.id.find_activity_type:
			setChecked(TYPE_CHECKED);
			break;

		case R.id.find_activity_location:
			setChecked(LOCATION_CHECKED);
			break;

		case R.id.find_activity_time:
			setChecked(TIME_CHECKED);
			break;
		case R.id.find_activity_time_5:
			mTimeWheelPicker.showAtLocation(findViewById(R.id.find_activity),
					Gravity.NO_GRAVITY, 0, mScreenHeight);
			setBackgroundDark();
			break;
			
		case R.id.find_activity_type_1:
			loadDataFromServer(Const.OUTDOOR_ACTIVITIES);
			break;
			
		case R.id.find_activity_type_2:
			loadDataFromServer(Const.GATHERING);
			break;
			
		case R.id.find_activity_type_3:
			loadDataFromServer(Const.ENTERTAINMENT);
			break;
			
		case R.id.find_activity_type_4:
			loadDataFromServer(Const.MEETING);
			break;
			
		case R.id.find_activity_type_5:
			loadDataFromServer(Const.ACTIVITY_SIGNUP);
			break;
			
		case R.id.find_activity_type_6:
			loadDataFromServer(Const.OTHERS);
			break;
		}
	}

	private void setBackgroundDark() {
		WindowManager.LayoutParams lp = getWindow().getAttributes();
		lp.alpha = 0.7f;
		getWindow().setAttributes(lp);
	}

	/**
	 * 从服务器端加载数据
	 */
	private void loadDataFromServer(String title) {
		String url = null;
		switch (title) {
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
				mAdapter = new TypeAndFindActivityListViewAdapter(FindActivity.this, arg0, Utils.getCity());
				mListView.setAdapter(mAdapter);
				mListView.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// TODO Auto-generated method stub
						Bundle bundle = new Bundle();
						Event event = arg0.get(position);
						bundle.putSerializable("DATA", event);
						Log.i("tag", event.getmEventName());
//						Utils.toAnotherActivity(FindActivity.this,
//								SignupActivity.class, bundle);
					}
				});
			}

			@Override
			public void onError(Call arg0, Exception arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(FindActivity.this, "网络连接失败，请检查你的网络连接",
						Toast.LENGTH_LONG).show();
			}
		});

	}

	@Override
	public void onDismiss() {
		// TODO Auto-generated method stub
		WindowManager.LayoutParams lp = getWindow().getAttributes();
		lp.alpha = 1f;
		getWindow().setAttributes(lp);
		Toast.makeText(getApplicationContext(),
				mYear + "-" + mMonth + "-" + mDay, Toast.LENGTH_SHORT).show();
	}

}
