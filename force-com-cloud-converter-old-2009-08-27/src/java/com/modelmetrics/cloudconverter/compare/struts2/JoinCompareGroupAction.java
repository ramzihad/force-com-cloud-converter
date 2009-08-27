package com.modelmetrics.cloudconverter.compare.struts2;

import org.springframework.util.StringUtils;

import com.modelmetrics.cloudconverter.compare.CompareManager;

public class JoinCompareGroupAction extends AbstractCompareContextAware {

	private String groupKey;
	
	public String execute() throws Exception {
		
		if (!StringUtils.hasText(this.groupKey) ) {
			return INPUT;
		}
		
		if (!CompareManager.singleton.isValid(this.groupKey)) {
			this.addActionMessage("Invalid group key.");
			return INPUT;
		}
		
		CompareManager.singleton.joinGroup(groupKey, this.getSalesforceSessionContext().getSalesforceSession());
		
		return SUCCESS;
		
		
	}

	public String getGroupKey() {
		return groupKey;
	}

	public void setGroupKey(String groupKey) {
		this.groupKey = groupKey;
	}
}
