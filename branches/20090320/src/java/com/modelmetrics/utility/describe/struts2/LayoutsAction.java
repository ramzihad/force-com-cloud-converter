package com.modelmetrics.utility.describe.struts2;

import java.util.Collection;

import com.modelmetrics.utility.describe.LayoutsBuilder;
import com.modelmetrics.utility.describe.LayoutsFieldVO;
import com.opensymphony.xwork2.Action;
import com.sforce.soap.partner.DescribeSObjectResult;

public class LayoutsAction extends AbstractDescribeContextAware {

	private String target;

	private DescribeSObjectResult results;
	
	private Collection<LayoutsFieldVO> rows;
	
	private Collection<String> recordTypes;
	
	private Collection<String> layoutIds;

	public Collection<String> getRecordTypes() {
		return recordTypes;
	}

	public void setRecordTypes(Collection<String> recordTypes) {
		this.recordTypes = recordTypes;
	}

	public Collection<LayoutsFieldVO> getRows() {
		return rows;
	}

	public void setRows(Collection<LayoutsFieldVO> rows) {
		this.rows = rows;
	}

	public String execute() throws Exception {

		if (this.getDescribeContext().getTypes() == null) {
			this.getDescribeContext().setTypes(
					this.getSalesforceSessionContext().getSalesforceSession()
							.getSalesforceService().describeGlobal().getTypes());

		}

		if (this.getTarget() != null) {

			
			if (this.getTarget() != null) {
				this.getDescribeContext().setTarget(this.getTarget());
			}
			LayoutsBuilder builder = new LayoutsBuilder();
			builder.execute(this.getSalesforceSessionContext().getSalesforceSession(), this.getDescribeContext().getTarget());

			this.setLayoutIds(builder.getLayoutIds());
			this.setRecordTypes(builder.getRecordTypes());
			this.setResults(builder.getResults());
			this.setRows(builder.getRows());
			
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

	public DescribeSObjectResult getResults() {
		return results;
	}

	public void setResults(DescribeSObjectResult results) {
		this.results = results;
	}

	public Collection<String> getLayoutIds() {
		return layoutIds;
	}

	public void setLayoutIds(Collection<String> layoutIds) {
		this.layoutIds = layoutIds;
	}

}
