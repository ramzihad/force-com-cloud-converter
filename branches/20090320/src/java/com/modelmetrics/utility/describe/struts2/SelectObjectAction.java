package com.modelmetrics.utility.describe.struts2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.Action;

public class SelectObjectAction extends AbstractDescribeContextAware {
	
	private static final Log log = LogFactory.getLog(SelectObjectAction.class);
	
	private String target;


	public String execute() throws Exception {

		log.info("in execute.");
		log.info("utility context is null?");
		log.info(this.getUtilityContext() == null);
		log.info("salesforce session?");
		log.info(this.getSalesforceSessionContext().getSalesforceSession()== null);
		log.info("utility context id " + this.getUtilityContext());
		



		

		if (this.getTarget() == null) {
			
				this.getDescribeContext().setTypes(
						this.getSalesforceSessionContext().getSalesforceSession()
								.getSalesforceService().describeGlobal().getTypes());
				
			
			return INPUT;
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





}
