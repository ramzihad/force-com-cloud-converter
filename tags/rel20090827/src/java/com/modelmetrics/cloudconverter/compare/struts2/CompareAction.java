package com.modelmetrics.cloudconverter.compare.struts2;

import org.springframework.util.StringUtils;

import com.modelmetrics.cloudconverter.compare.CompareManager;
import com.modelmetrics.cloudconverter.compare.ComparisonGroup;

public class CompareAction extends AbstractCompareContextAware {

	public String execute() throws Exception {

		if (!StringUtils.hasText(this.getCompareContext().getGroupKey())) {
			this
					.addActionMessage("You must create or join a compare group before comparing orgs.");
			return ERROR;
		}

		if (!CompareManager.singleton.isValid(this.getCompareContext()
				.getGroupKey())) {
			this.addActionMessage("Group key is not valid.");
			return ERROR;
		}

		ComparisonGroup activeComparisonGroup = null;

		try {
			activeComparisonGroup = CompareManager.singleton
					.getComparisonGroup(this.getCompareContext().getGroupKey());
		} catch (Exception e) {
			this.addActionMessage("Failed to retrieve comparison group.");
			return ERROR;
		}

		//execute compare
		return SUCCESS;

	}
}
