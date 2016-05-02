package com.example.dateasy.model;

public class ManageEvent extends Event {

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

	public ManageEvent() {
		super();
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
