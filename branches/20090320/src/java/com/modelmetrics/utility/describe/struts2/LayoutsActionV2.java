package com.modelmetrics.utility.describe.struts2;

import java.util.Collection;

import com.modelmetrics.utility.describe.LayoutsBuilderV2;
import com.modelmetrics.utility.describe.LayoutsFieldVO;
import com.modelmetrics.utility.describe.LayoutsSummary;
import com.opensymphony.xwork2.Action;
import com.sforce.soap.partner.DescribeSObjectResult;

public class LayoutsActionV2 extends AbstractDescribeContextAware {

	private String target;

	private LayoutsSummary summary;

	public String execute() throws Exception {

		if (this.getDescribeContext().getTypes() == null) {
			this.getDescribeContext().setTypes(
					this.getSalesforceSessionContext().getSalesforceSession().getSalesforceService()
							.describeGlobal().getTypes());

		}

		if (this.getTarget() != null) {

			if (this.getTarget() != null) {
				this.getDescribeContext().setTarget(this.getTarget());
			}
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
