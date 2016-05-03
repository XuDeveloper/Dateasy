package com.example.dateasy.model;

import java.util.ArrayList;

import android.graphics.Bitmap;

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
	private String mNickName;

	/**
	 * 用户密码
	 */
	private String mPassword;

	/**
	 * 用户性别
	 */
	private String mSex;

	/**
	 * 用户真实姓名
	 */
	private String mTrueName;

	/**
	 * 用户手机
	 */
	private String mTelephone;

	/**
	 * 用户邮箱
	 */
	private String mEmail;

	/**
	 * 用户发起的活动
	 */
	private ArrayList<Event> mReleaseEvents;

	/**
	 * 用户报名的活动
	 */
	private ArrayList<Event> mSignupEvents;
	
	/**
	 * 用户头像
	 */
	private Bitmap mHead;
	
	public Bitmap getmHead(){
		return mHead;
	}
	public void setmHead(Bitmap mHead){
		this.mHead = mHead;
	}
	public String getmNickName() {
		return mNickName;
	}

	public void setmNickName(String mNickName) {
		this.mNickName = mNickName;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public String getmSex() {
		return mSex;
	}

	public void setmSex(String mSex) {
		this.mSex = mSex;
	}

	public String getmTrueName() {
		return mTrueName;
	}

	public void setmTrueName(String mTrueName) {
		this.mTrueName = mTrueName;
	}

	public String getmTelephone() {
		return mTelephone;
	}

	public void setmTelephone(String mTelephone) {
		this.mTelephone = mTelephone;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public ArrayList<Event> getmReleaseEvents() {
		return mReleaseEvents;
	}

	public void setmReleaseEvents(ArrayList<Event> mReleaseEvents) {
		this.mReleaseEvents = mReleaseEvents;
	}

	public ArrayList<Event> getmSignupEvents() {
		return mSignupEvents;
	}

	public void setmSignupEvents(ArrayList<Event> mSignupEvents) {
		this.mSignupEvents = mSignupEvents;
	}

	public User() {
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User{" + "nickname:" + mNickName + ",password:"+ mPassword + ",sex:" + mSex + ",truename:" + mTrueName 
				+ ",telephone:" + mTelephone + ",email:" + mEmail + "}";
	}
}
