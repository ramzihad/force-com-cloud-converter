package com.modelmetrics.cloudconverter.engine;

import java.util.Comparator;

public class ObjectDeleteBeanComparator implements Comparator {

	public int compare(Object o1, Object o2) {
		
		assert(o1 instanceof ObjectDeleteBean && o2 instanceof ObjectDeleteBean);
		
		ObjectDeleteBean bean1 = (ObjectDeleteBean) o1;
		ObjectDeleteBean bean2 = (ObjectDeleteBean) o2;
		
		if (bean1.getRefToOtherObjectCount() > bean2.getRefToOtherObjectCount()) {
			return -1;
		} else if (bean1.getRefToOtherObjectCount() < bean2.getRefToOtherObjectCount()) {
			return 1;
		}
		
		return -1;
	}

}
