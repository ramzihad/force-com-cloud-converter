package com.modelmetrics.cloudconverter.compare.struts2;

import org.springframework.util.StringUtils;

import com.modelmetrics.cloudconverter.compare.CompareManager;

public class CreateCompareGroupAction extends AbstractCompareContextAware {

	private String submit;

	private String groupKey;

	public String execute() throws Exception {

		if (!StringUtils.hasText(this.getSubmit())) {
			return INPUT;
		}

		try {
			groupKey = CompareManager.singleton.createGroup(this
					.getSalesforceSessionContext().getSalesforceSession());
		} catch (Exception e) {
			return ERROR;
		}

		return SUCCESS;

	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getGroupKey() {
		return groupKey;
	}

	public void setGroupKey(String groupKey) {
		this.groupKey = groupKey;
	}
}
