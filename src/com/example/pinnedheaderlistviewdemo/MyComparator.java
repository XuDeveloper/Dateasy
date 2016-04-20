package com.example.pinnedheaderlistviewdemo;

import java.util.Comparator;

public class MyComparator implements Comparator<City> {
	@Override
	public int compare(City c1, City c2) {

		return c1.getSortKey().compareTo(c2.getSortKey());
	}

}
