package com.example.dateasy.util;

/**
 * 注册或登录的逻辑检查类
 * @author Xu
 * 
 */
import java.util.regex.Pattern;

import android.content.Context;
import android.widget.Toast;

public class CheckUtils {
	private Context mContext;

	public CheckUtils(Context mContext) {
		this.mContext = mContext;
	}

	public boolean registerCheck(String mUserAccount, String mUserPassword,
			String mUserConfirmPassword, String mUserVertificationCode) {
		if (userAccountCheck(mUserAccount)) {
			if (userPasswordCheck(mUserPassword)) {
				if (ifUserPasswordSame(mUserPassword, mUserConfirmPassword)) {
					if (userVertificationCodeCheck(mUserVertificationCode)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean loginCheck(String mUserAccount, String mUserPassword) {
		if (userAccountCheck(mUserAccount)) {
			if (userPasswordCheck(mUserPassword)) {
				return true;
			}
		}
		return false;
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
		String mAccountPattern = "^\\w{3,20}$";
		if (mUserAccount.compareTo("") == 0) {
			Toast.makeText(mContext, "用户名不能为空", Toast.LENGTH_SHORT).show();
			return false;
		} else {
			boolean result = Pattern.matches(mAccountPattern, mUserAccount);
			if (result) {
				return true;
			} else {
				Toast.makeText(mContext, "用户名或密码错误", Toast.LENGTH_SHORT).show();
				return false;
			}
		}
	}

	private boolean userPasswordCheck(String mUserPassword) {
		String mPasswordParrern = "^\\w{6,12}$";
		if (mUserPassword.compareTo("") == 0) {
			Toast.makeText(mContext, "密码不能为空", Toast.LENGTH_SHORT).show();
			return false;
		} else {
			boolean result = Pattern.matches(mPasswordParrern, mUserPassword);
			if (result) {
				return true;
			} else {
				Toast.makeText(mContext, "用户名或密码错误", Toast.LENGTH_SHORT).show();
				return false;
			}
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
