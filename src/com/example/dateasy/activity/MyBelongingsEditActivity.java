package com.example.dateasy.activity;

/**
 * 编辑用户资料
 * @author Xu
 * 
 */
import okhttp3.Call;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.dateasy.R;
import com.example.dateasy.consts.Const;
import com.example.dateasy.model.User;
import com.example.dateasy.util.NetworkUtils;
import com.example.dateasy.util.Utils;
import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.StringCallback;

public class MyBelongingsEditActivity extends Activity implements
		OnClickListener {

	private ImageButton mBackImageButton;
	private EditText mUserNameEditText;
	private EditText mUserDescriptionEditText;
	private EditText mUserSexEditText;
	private EditText mUserTelephoneEditText;
	private EditText mUserEmailEditText;
	private User mUser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mybelongings_edit);
		initViews();
		setData();
	}

	private void setData() {
		// TODO Auto-generated method stub
		mUser = Utils.getmCurrentUser();
		mUserNameEditText.setText(mUser.getNick_name());
		mUserDescriptionEditText.setText(mUser.getDescription());
		mUserSexEditText.setText(mUser.getSex());
		mUserTelephoneEditText.setText(mUser.getTelephone());
		mUserEmailEditText.setText(mUser.getEmail());
	}

	private void initViews() {
		// TODO Auto-generated method stub
		mBackImageButton = (ImageButton) findViewById(R.id.mybelongings_back_ib);
		mUserNameEditText = (EditText) findViewById(R.id.mybelongings_edit_user_name_et);
		mUserDescriptionEditText = (EditText) findViewById(R.id.mybelongings_edit_user_description_et);
		mUserSexEditText = (EditText) findViewById(R.id.mybelongings_edit_user_sex_et);
		mUserTelephoneEditText = (EditText) findViewById(R.id.mybelongings_edit_user_phone_et);
		mUserEmailEditText = (EditText) findViewById(R.id.mybelongings_edit_user_email_et);
		mBackImageButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Bundle bundle = new Bundle();
		switch (v.getId()) {
		case R.id.mybelongings_back_ib:
			mUser.setNick_name(mUserNameEditText.getText().toString());
			mUser.setDescription(mUserDescriptionEditText.getText().toString());
			mUser.setSex(mUserSexEditText.getText().toString());
			mUser.setTelephone(mUserTelephoneEditText.getText().toString());
			mUser.setEmail(mUserEmailEditText.getText().toString());
			NetworkUtils.postData(Const.UPDATE_USER_DATA, mUser, new StringCallback() {
				
				@Override
				public void onResponse(String arg0) {
					// TODO Auto-generated method stub
					if (arg0.equals("true")) {
						Toast.makeText(MyBelongingsEditActivity.this, "修改成功！", Toast.LENGTH_LONG).show();
					} else {
						Toast.makeText(MyBelongingsEditActivity.this, "修改失败，请重试！", Toast.LENGTH_LONG).show();
					}
				}
				
				@Override
				public void onError(Call arg0, Exception arg1) {
					// TODO Auto-generated method stub
					Toast.makeText(MyBelongingsEditActivity.this, "修改失败，请重试！", Toast.LENGTH_LONG).show();
				}
			});
			Utils.setmCurrentUser(mUser);
			bundle.putBoolean("RETURN_TO_MYBELONGINGS", true);
			Utils.toAnotherActivity(MyBelongingsEditActivity.this, MainActivity.class, bundle);
			finish();
			break;

		default:
			break;
		}
	}

}
