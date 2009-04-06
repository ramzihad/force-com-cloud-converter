package com.modelmetrics.utility.describe.struts2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.modelmetrics.utility.describe.FieldItemVO;
import com.modelmetrics.utility.describe.LayoutsFieldVOV2;
import com.opensymphony.xwork2.Action;

public class LayoutsV2Form extends LayoutsActionV2 {

	private Collection<String> requiredFields = new ArrayList<String>();;

	private Collection<String> multipicklists = new ArrayList<String>();;

	public String execute() throws Exception {

		super.execute();

		for (Iterator iter = this.getSummary().getRows().iterator(); iter
				.hasNext();) {
			LayoutsFieldVOV2 element = (LayoutsFieldVOV2) iter.next();
			if (element.getField().getType().getValue().equalsIgnoreCase(
					"multipicklist")) {
				this.getMultipicklists().add(element.getField().getName());
			}
			
			
			
			for (Iterator iterator = element.getLayouts().iterator(); iterator.hasNext();) {
				FieldItemVO layoutElement = (FieldItemVO) iterator.next();
				if (layoutElement.isRequired()) {
					this.getRequiredFields().add(element.getField().getName());
					break;
				}
			}
		}
		
		

		return Action.SUCCESS;
	}

	public Collection<String> getMultipicklists() {
		return multipicklists;
	}

	public void setMultipicklists(Collection<String> multipicklists) {
		this.multipicklists = multipicklists;
	}

	public Collection<String> getRequiredFields() {
		return requiredFields;
	}

	public void setRequiredFields(Collection<String> requiredFields) {
		this.requiredFields = requiredFields;
	}
}
