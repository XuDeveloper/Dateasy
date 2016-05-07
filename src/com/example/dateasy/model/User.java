package com.example.dateasy.model;

import java.io.Serializable;
import java.util.ArrayList;

import android.graphics.Bitmap;

/**
 * 用户类
 * 
 * @author Xu
 * 
 */
public class User implements Serializable {

	/**
	 * 用户昵称
	 */
	private String nick_name;

	/**
	 * 用户密码
	 */
	private String password;

	/**
	 * 用户性别
	 */
	private String sex;

	/**
	 * 用户真实姓名
	 */
	private String true_name;

	/**
	 * 用户手机
	 */
	private String telephone;

	/**
	 * 用户邮箱
	 */
	private String email;

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

	public User() {

	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTrue_name() {
		return true_name;
	}

	public void setTrue_name(String true_name) {
		this.true_name = true_name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Bitmap getmHead() {
		return mHead;
	}

	public void setmHead(Bitmap mHead) {
		this.mHead = mHead;
	}

}
