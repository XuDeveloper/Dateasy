package com.example.pinnedheaderlistviewdemo;

import android.os.Parcel;
import android.os.Parcelable;

public class City implements Parcelable{
	private String id;
	private String name;
	private String pyf;
	private String pys;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPyf() {
		return pyf;
	}

	public void setPyf(String pyf) {
		this.pyf = pyf;
	}

	public String getPys() {
		return pys;
	}

	public void setPys(String pys) {
		this.pys = pys;
	}

	public String getSortKey() {

		return pys.substring(0, 1);
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(id);
		dest.writeString(name);
		dest.writeString(pyf);
		dest.writeString(pys);
	}

}
