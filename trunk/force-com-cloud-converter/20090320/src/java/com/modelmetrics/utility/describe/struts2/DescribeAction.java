package com.modelmetrics.utility.describe.struts2;

import java.util.Set;
import java.util.TreeSet;

import com.modelmetrics.utility.describe.FieldComparator;
import com.opensymphony.xwork2.Action;
import com.sforce.soap.partner.DescribeSObjectResult;
import com.sforce.soap.partner.Field;

public class DescribeAction extends AbstractDescribeContextAware {

	private String target;

	private Set<Field> results;

	public String execute() throws Exception {

		if (this.getTarget() != null) {
			this.getDescribeContext().setTarget(this.getTarget());
		}

		DescribeSObjectResult r = null;

		r = this.getSalesforceSessionContext().getSalesforceSession()
				.getSalesforceService().describeSObject(
						this.getDescribeContext().getTarget());

		if (r != null) {

			Field[] fields = r.getFields();

			Set<Field> results = new TreeSet<Field>(new FieldComparator());

			for (int i = 0; i < fields.length; i++) {
				results.add(fields[i]);

			}

			this.setResults(results);

			/*
			 * 2007-09-05 disabled to test larger orgs.
			 */
			// this.getDescribeContext().getDescriptions().put(this.getTarget(),
			// r);
			this.getDescribeContext().setLastResult(r);

		}

		return Action.SUCCESS;

	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String targetSObject) {
		this.target = targetSObject;
	}

	public Set<Field> getResults() {
		return results;
	}

	public void setResults(Set<Field> results) {
		this.results = results;
	}

}
