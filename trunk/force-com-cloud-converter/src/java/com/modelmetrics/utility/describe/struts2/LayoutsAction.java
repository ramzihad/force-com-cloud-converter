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

		try {
			if (this.getDescribeContext().getTarget() != null) {

				LayoutsBuilder builder = new LayoutsBuilder();
				builder.execute(this.getSalesforceSessionContext()
						.getSalesforceSession(), this.getDescribeContext()
						.getTarget());

				this.setLayoutIds(builder.getLayoutIds());
				this.setRecordTypes(builder.getRecordTypes());
				this.setResults(builder.getResults());
				this.setRows(builder.getRows());

				this.getDescribeContext().setTarget(this.getTarget());
			}
		} catch (Exception e) {
			this.getDescribeContext().setLastMessage("Layouts not supported for object '" + this.getDescribeContext().getTarget() + "'.");
			return Action.ERROR;
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
