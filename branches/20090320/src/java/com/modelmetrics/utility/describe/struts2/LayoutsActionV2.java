package com.modelmetrics.utility.describe.struts2;

import com.modelmetrics.utility.describe.LayoutsBuilderV2;
import com.modelmetrics.utility.describe.LayoutsSummary;
import com.opensymphony.xwork2.Action;

public class LayoutsActionV2 extends AbstractDescribeContextAware {

	private String target;

	private LayoutsSummary summary;

	public String execute() throws Exception {

		if (this.getDescribeContext().getTarget() != null) {

			LayoutsBuilderV2 builder = new LayoutsBuilderV2();
			LayoutsSummary summary = builder.execute(this.getSalesforceSessionContext().getSalesforceSession(), this.getDescribeContext()
					.getTarget());

			this.setSummary(summary);

			this.getDescribeContext().setTarget(this.getTarget());
		}

		return Action.SUCCESS;

	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String targetSObject) {
		this.target = targetSObject;
	}


	public LayoutsSummary getSummary() {
		return summary;
	}

	public void setSummary(LayoutsSummary summary) {
		this.summary = summary;
	}

}
