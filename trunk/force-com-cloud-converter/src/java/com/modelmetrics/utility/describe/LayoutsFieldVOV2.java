package com.modelmetrics.utility.describe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sforce.soap.partner.Field;

public class LayoutsFieldVOV2 {

	private Field field;
	
	private Collection<FieldItemVO> layouts = new ArrayList<FieldItemVO>();

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public Collection<FieldItemVO> getLayouts() {
		return layouts;
	}

	public void setLayouts(Collection<FieldItemVO> layouts) {
		this.layouts = layouts;
	}

	public boolean isMissing() {
		boolean ret = true;
		
		for (Iterator iter = this.layouts.iterator(); iter.hasNext();) {
			FieldItemVO element = (FieldItemVO) iter.next();
			if (element.isPresent()) {
				ret = false;
				break;
			}
		}
		
		return ret;
	}

	
}
