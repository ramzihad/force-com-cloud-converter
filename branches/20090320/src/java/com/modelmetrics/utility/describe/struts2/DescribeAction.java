package com.modelmetrics.utility.describe.struts2;

import java.util.Collection;
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

		

		DescribeSObjectResult r = null;
		
		/*
		 * 2007-09-06 checks to see if we have this stored.  Disabling for now since
		 * on large orgs it takes a LOT of memory.  Disabled below.
		 */
		if (this.getTarget() != null && this.getDescribeContext().getDescriptions().get(this.getTarget()) != null) {
			
			r = this.getDescribeContext().getDescriptions().get(this.getTarget());
			
		} else if (this.getTarget() != null) {
			
			r = this.getSalesforceSessionContext().getSalesforceSession()
					.getSalesforceService().describeSObject(this.getTarget());
			
			
		}

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
//			this.getDescribeContext().getDescriptions().put(this.getTarget(), r);
			this.getDescribeContext().setLastResult(r);

			
		}
		
		this.getDescribeContext().setTarget(this.getTarget());
		
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
