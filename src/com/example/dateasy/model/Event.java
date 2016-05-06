package com.example.dateasy.model;

import java.io.Serializable;
import java.util.ArrayList;

import android.graphics.Bitmap;

/**
 * 活动类
 * 
 * @author Xu
 * 
 */
public class Event implements Serializable {

	/**
	 * 活动类型
	 */
	private String mType;

	/**
	 * 活动名称
	 */
	private String mEventName;

	/**
	 * 活动地点
	 */
	private String mLocation;

	/**
	 * 活动开始时间
	 */
	private String mStartTime;

	/**
	 * 活动结束时间
	 */
	private String mEndTime;

	/**
	 * 活动截止报名时间
	 */
	private String mEndApplyTime;

	/**
	 * 活动描述
	 */
	private String mDescription;

	/**
	 * 活动人数
	 */
	private int mCapacity;

	/**
	 * 具体的报名人信息
	 */
	private ArrayList<User> mRegisterUsers;

	/**
	 * 活动是否允许推荐
	 */
	private boolean mIsRecommand;

	/**
	 * 活动费用
	 */
	private int mCost;

	/**
	 * 活动发起人
	 */
	private User mReleaseUser;

	/**
	 * 活动参与的人数
	 */
	private int mCount;
	/**
	 * 活动封面
	 */
	private Bitmap mEventCover;

	public Bitmap getmEventCover() {
		return mEventCover;
	}

	public void setmEventCover(Bitmap mEventCover) {
		this.mEventCover = mEventCover;
	}

	public String getmType() {
		return mType;
	}

	public void setmType(String mType) {
		this.mType = mType;
	}

	public String getmEventName() {
		return mEventName;
	}

	public void setmEventName(String mEventName) {
		this.mEventName = mEventName;
	}

	public String getmLocation() {
		return mLocation;
	}

	public void setmLocation(String mLocation) {
		this.mLocation = mLocation;
	}

	public String getmStartTime() {
		return mStartTime;
	}

	public void setmStartTime(String mStartTime) {
		this.mStartTime = mStartTime;
	}

	public String getmEndTime() {
		return mEndTime;
	}

	public void setmEndTime(String mEndTime) {
		this.mEndTime = mEndTime;
	}

	public String getmEndApplyTime() {
		return mEndApplyTime;
	}

	public void setmEndApplyTime(String mEndApplyTime) {
		this.mEndApplyTime = mEndApplyTime;
	}

	public String getmDescription() {
		return mDescription;
	}

	public void setmDescription(String mDescription) {
		this.mDescription = mDescription;
	}

	public int getmCapacity() {
		return mCapacity;
	}

	public void setmCapacity(int mCapacity) {
		this.mCapacity = mCapacity;
	}

	public boolean ismIsRecommand() {
		return mIsRecommand;
	}

	public void setmIsRecommand(boolean mIsRecommand) {
		this.mIsRecommand = mIsRecommand;
	}

	public int getmCost() {
		return mCost;
	}

	public void setmCost(int mCost) {
		this.mCost = mCost;
	}

	public User getmReleaseUser() {
		return mReleaseUser;
	}

	public void setmReleaseUser(User mReleaseUser) {
		this.mReleaseUser = mReleaseUser;
	}

	public int getmCount() {
		return mCount;
	}

	public void setmCount(int mCount) {
		this.mCount = mCount;
	}

	public ArrayList<User> getmRegisterUsers() {
		return mRegisterUsers;
	}

	public void setmRegisterUsers(ArrayList<User> mRegisterUsers) {
		this.mRegisterUsers = mRegisterUsers;
	}

	public Event() {
	}

}
