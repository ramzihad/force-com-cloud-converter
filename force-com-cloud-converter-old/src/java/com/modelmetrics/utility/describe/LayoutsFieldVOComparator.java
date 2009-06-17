package com.modelmetrics.utility.describe;

import java.util.Comparator;

public class LayoutsFieldVOComparator implements Comparator {

	public int compare(Object arg0, Object arg1) {
		LayoutsFieldVO one = (LayoutsFieldVO) arg0;
		LayoutsFieldVO two = (LayoutsFieldVO) arg1;
		return one.getLabel().compareTo(two.getLabel());
	}

}
