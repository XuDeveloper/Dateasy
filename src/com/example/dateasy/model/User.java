package com.example.dateasy.model;

import java.util.ArrayList;

/**
 * 用户类
 * 
 * @author Xu
 * 
 */
public class User {

	/**
	 * 用户昵称
	 */
	private final String mNickName;

	/**
	 * 用户密码
	 */
	private final String mPassword;

	/**
	 * 用户性别
	 */
	private final String mSex;

	/**
	 * 用户真实姓名
	 */
	private final String mTrueName;

	/**
	 * 用户手机
	 */
	private final String mTelephone;

	/**
	 * 用户邮箱
	 */
	private final String mEmail;

	/**
	 * 用户发起的活动
	 */
	private final ArrayList<Event> mReleaseEvents;

	/**
	 * 用户报名的活动
	 */
	private final ArrayList<Event> mSignupEvents;

	public static class Builder {
		private String mNickName = null;
		private String mPassword = null;
		private String mSex = null;
		private String mTrueName = null;
		private String mTelephone = null;
		private String mEmail = null;
		private ArrayList<Event> mReleaseEvents = new ArrayList<Event>();
		private ArrayList<Event> mSignupEvents = new ArrayList<Event>();
		
		public Builder nickName(String nickName) {
			mNickName = nickName;
			return this;
		}
		
		public Builder password(String password) {
			mPassword = password;
			return this;
		}
		
		public Builder sex(String sex) {
			mSex = sex;
			return this;
		}
		
		public Builder trueName(String trueName) {
			mTrueName = trueName;
			return this;
		}
		
		public Builder telephone(String telephone) {
			mTelephone = telephone;
			return this;
		}
		
		public Builder email(String email) {
			mEmail = email;
			return this;
		}
		
		public Builder releaseEvents(ArrayList<Event> events) {
			mReleaseEvents = events;
			return this;
		}
		
		public Builder signupEvents(ArrayList<Event> events) {
			mSignupEvents = events;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
	}
	
	private User(Builder builder) {
		mNickName = builder.mNickName;
		mPassword = builder.mPassword;
		mSex = builder.mSex;
		mTrueName = builder.mTrueName;
		mTelephone = builder.mTelephone;
		mEmail = builder.mEmail;
		mReleaseEvents = builder.mReleaseEvents;
		mSignupEvents = builder.mSignupEvents;
	}
}
