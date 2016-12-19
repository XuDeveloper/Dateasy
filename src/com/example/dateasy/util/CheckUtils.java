package com.example.dateasy.util;

/**
 * 注册或登录的逻辑检查类
 * @author Xu
 * 
 */

import java.util.ArrayList;

import okhttp3.Call;

import com.example.dateasy.consts.Const;
import com.example.dateasy.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class CheckUtils {
	private Context mContext;
	private boolean mLoginIsSuccess;
	private boolean mRegisterIsSuccess;

	public CheckUtils(Context mContext) {
		this.mContext = mContext;
	}

	public boolean registerCheck(String mUserAccount, String mUserPassword,
			String mUserConfirmPassword, String mUserVertificationCode) {
		mRegisterIsSuccess = false;
		if (userAccountCheck(mUserAccount)) {
			if (userPasswordCheck(mUserPassword)) {
				if (ifUserPasswordSame(mUserPassword, mUserConfirmPassword)) {
					if (userVertificationCodeCheck(mUserVertificationCode)) {
						mRegisterIsSuccess = true;
					}
				}
			}
		}
		// 包装数据
		User user = new User();
		user.setNick_name(mUserAccount);
		user.setPassword(mUserPassword);
		user.setDescription("");
		user.setSex("");
		user.setTrue_name("");
		user.setEmail("");
		user.setmReleaseEvents(null);
		user.setmSignupEvents(null);
		user.setmHead(null);
		Utils.setmCurrentUser(user);
		NetworkUtils.postData(Const.REGISTER_CHECK_URL, user, new StringCallback() {

			@Override
			public void onResponse(String arg0) {
				// TODO Auto-generated method stub
				if (arg0.equals("false")) {
//					Toast.makeText(mContext, Const.ERROR_MESSAGE,
//							Toast.LENGTH_LONG).show();
					mRegisterIsSuccess = false;
				} else {
					mRegisterIsSuccess = true;
				}
			}

			@Override
			public void onError(Call arg0, Exception arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, Const.ERROR_MESSAGE, Toast.LENGTH_LONG)
						.show();
				mRegisterIsSuccess = false;
			}
		});
		if (!mRegisterIsSuccess) {
			Utils.setmCurrentUser(null);
		}
		return mRegisterIsSuccess;
	}

	public boolean loginCheck(String mUserAccount, String mUserPassword) {
		mLoginIsSuccess = false;
		if (userAccountCheck(mUserAccount)) {
			if (userPasswordCheck(mUserPassword)) {
				mLoginIsSuccess = true;
			}
		}
		NetworkUtils.postData(Const.LOGIN_CHECK_URL, mUserAccount,
				mUserPassword, new StringCallback() {

					@Override
					public void onResponse(String arg0) {
						// TODO Auto-generated method stub
						if (arg0.equals("false")) {
							Toast.makeText(mContext, "账号或密码错误，请重试！",
									Toast.LENGTH_LONG).show();
							mLoginIsSuccess = false;
						} else {
							mLoginIsSuccess = true;
							ArrayList<User> users = new Gson().fromJson(arg0,
									new TypeToken<ArrayList<User>>() {
									}.getType());
							Utils.setmCurrentUser(users.get(0));
						}
					}

					@Override
					public void onError(Call arg0, Exception arg1) {
						// TODO Auto-generated method stub
						Toast.makeText(mContext, Const.ERROR_MESSAGE,
								Toast.LENGTH_LONG).show();
						mLoginIsSuccess = false;
					}
				});
		return mLoginIsSuccess;
	}

	private boolean ifUserPasswordSame(String mUserPassword,
			String mUserConfirmPassword) {
		boolean result = (mUserPassword.compareTo(mUserConfirmPassword) == 0);
		if (result) {
			return true;
		} else {
			Toast.makeText(mContext, "两次输入密码不一样", Toast.LENGTH_SHORT).show();
			return false;
		}
	}

	private boolean userAccountCheck(String mUserAccount) {
		// String mAccountPattern = "^\\w{3,20}$";
		if (mUserAccount.compareTo("") == 0) {
			Toast.makeText(mContext, "用户名不能为空", Toast.LENGTH_SHORT).show();
			return false;
		} else {
			// boolean result = Pattern.matches(mAccountPattern, mUserAccount);
			// if (result) {
			// return true;
			// } else {
			// Toast.makeText(mContext, "用户名或密码错误", Toast.LENGTH_SHORT).show();
			// return false;
			// }
			// Toast.makeText(mContext, "用户名或密码错误", Toast.LENGTH_SHORT).show();
			// return false;
			return true;
		}
	}

	private boolean userPasswordCheck(String mUserPassword) {
		// String mPasswordParrern = "^\\w{6,12}$";
		if (mUserPassword.compareTo("") == 0) {
			Toast.makeText(mContext, "密码不能为空", Toast.LENGTH_SHORT).show();
			return false;
		} else {
			// boolean result = Pattern.matches(mPasswordParrern,
			// mUserPassword);
			// if (result) {
			// return true;
			// } else {
			// Toast.makeText(mContext, "用户名或密码错误", Toast.LENGTH_SHORT).show();
			// return false;
			// }
			return true;
		}
	}

	private boolean userVertificationCodeCheck(String mUserVertificationCode) {
		if (mUserVertificationCode.compareTo("") == 0) {
			Toast.makeText(mContext, "验证码不能为空", Toast.LENGTH_SHORT).show();
			return false;
		}
		return true;

	}
}
