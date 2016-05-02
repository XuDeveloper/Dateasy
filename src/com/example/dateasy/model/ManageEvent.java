package com.example.dateasy.model;

public class ManageEvent {
	/**
	 * 活动类型
	 */
	private String mType;
	/**
	 * 活动时间
	 */
	private String mReleaseTime;
	
	/**
	 * 活动名称
	 */
	private String mEventName;
	
	/**
	 * 活动状态
	 */
	private String mEventState;
	 /**
	  * 活动是否需要收费
	  */
	private boolean mIfCost;
	/**
	 * 活动报名人数
	 */
	private int mCount;
	
	public ManageEvent(){
		
	}
	public String getmType() {
		return mType;
	}
	public void setmType(String mType) {
		this.mType = mType;
	}
	public String getmReleaseTime() {
		return mReleaseTime;
	}
	public void setmReleaseTime(String mReleaseTime) {
		this.mReleaseTime = mReleaseTime;
	}
	public String getmEventName() {
		return mEventName;
	}
	public void setmEventName(String mEventName) {
		this.mEventName = mEventName;
	}
	public String getmEventState() {
		return mEventState;
	}
	public void setmEventState(String mEventState) {
		this.mEventState = mEventState;
	}
	public boolean ismIfCost() {
		return mIfCost;
	}
	public void setmIfCost(boolean mIfCost) {
		this.mIfCost = mIfCost;
	}
	public int getmCount() {
		return mCount;
	}
	public void setmCount(int mCount) {
		this.mCount = mCount;
	}
}
