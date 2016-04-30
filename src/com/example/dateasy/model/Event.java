package com.example.dateasy.model;

/**
 * 活动类
 * 
 * @author Xu
 * 
 */
public class Event {

	/**
	 * 活动类型
	 */
	private final String mType;

	/**
	 * 活动名称
	 */
	private final String mEventName;

	/**
	 * 活动地点
	 */
	private final String mLocation;

	/**
	 * 活动发布时间
	 */
	private final String mReleaseTime;

	/**
	 * 活动开始时间
	 */
	private final String mStartTime;

	/**
	 * 活动结束时间
	 */
	private final String mEndTime;

	/**
	 * 活动截止报名时间
	 */
	private final String mEndApplyTime;

	/**
	 * 活动描述
	 */
	private final String mDescription;

	/**
	 * 活动人数
	 */
	private final int mCapacity;

	/**
	 * 活动是否允许推荐
	 */
	private final boolean mIsRecommand;

	/**
	 * 活动费用
	 */
	private final int mCost;
	
	/**
	 * 活动发起人
	 */
	private final User mReleaseUser;
	
	/**
	 * 活动参与的人数
	 */
	private final int mCount;

	public static class Builder {

		private String mType = null;
		private String mEventName = null;
		private String mLocation = null;
		private String mReleaseTime = null;
		private String mStartTime = null;
		private String mEndTime = null;
		private String mEndApplyTime = null;
		private String mDescription = null;
		private int mCapacity = 0;
		private boolean mIsRecommand = false;
		private int mCost = 0;
		private User mReleaseUser = null;
		private int mCount = 0;

		public Builder() {
		}

		public Builder type(String type) {
			mType = type;
			return this;
		}

		public Builder eventName(String eventName) {
			mEventName = eventName;
			return this;
		}

		public Builder location(String location) {
			mLocation = location;
			return this;
		}

		public Builder releaseTime(String releaseTime) {
			mReleaseTime = releaseTime;
			return this;
		}

		public Builder startTime(String startTime) {
			mStartTime = startTime;
			return this;
		}

		public Builder endTime(String endTime) {
			mEndTime = endTime;
			return this;
		}

		public Builder endApplyTime(String endApplyTime) {
			mEndApplyTime = endApplyTime;
			return this;
		}

		public Builder description(String description) {
			mDescription = description;
			return this;
		}

		public Builder capacity(int capacity) {
			mCapacity = capacity;
			return this;
		}

		public Builder isRecommend(boolean isRecommend) {
			mIsRecommand = isRecommend;
			return this;
		}

		public Builder cost(int cost) {
			mCost = cost;
			return this;
		}

		public Builder releaseUser(User releaseUser) {
			mReleaseUser = releaseUser;
			return this;
		}
		
		public Builder count(int count) {
			mCount = count;
			return this;
		}
		
		public Event build() {
			return new Event(this);
		}
	}

	private Event(Builder builder) {
		this.mType = builder.mType;
		this.mEventName = builder.mEventName;
		this.mLocation = builder.mLocation;
		this.mReleaseTime = builder.mReleaseTime;
		this.mStartTime = builder.mStartTime;
		this.mEndTime = builder.mEndTime;
		this.mEndApplyTime = builder.mEndApplyTime;
		this.mDescription = builder.mDescription;
		this.mCapacity = builder.mCapacity;
		this.mIsRecommand = builder.mIsRecommand;
		this.mCost = builder.mCost;
		this.mReleaseUser = builder.mReleaseUser;
		this.mCount = builder.mCount;
	}
}
