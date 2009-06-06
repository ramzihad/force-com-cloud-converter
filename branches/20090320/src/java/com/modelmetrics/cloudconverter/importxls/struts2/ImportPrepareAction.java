package com.modelmetrics.cloudconverter.importxls.struts2;

import com.modelmetrics.cc.importxls.svcs.CloudConverterObject;
import com.modelmetrics.cc.importxls.svcs.CustomObjectNameDecorator;
import com.modelmetrics.cc.importxls.svcs.ExistsInSalesforceDecorator;
import com.modelmetrics.cc.importxls.svcs.SalesforceService;
import com.opensymphony.xwork2.Action;

public class ImportPrepareAction extends AbstractUploadContextAware {

	private SalesforceService salesforceService;
	
	public String execute() throws Exception {
		
		//reset the current index number
		this.getUploadContext().setCurrentCloudConverterObjectIndex(-1);
		
		//decorate with object names
		new CustomObjectNameDecorator().decorate(this.getUploadContext().getCloudConverterObjects());
		
		//decorate with exists
		try {
		new ExistsInSalesforceDecorator().decorate(this.getUploadContext().getCloudConverterObjects(), this.getSalesforceService());
		} catch (Exception e) {
			this.getUploadContext().setLastException(e);
			this.getUploadContext().setMessage("This error is often caused by lack of access to the Salesforce API. Check your edition (EE, UE, Dev) and your porfile (API Enabled).");
			return Action.ERROR;
		}
		
		//does anything already exist? if so, we need to get confirmation that it's OK to continue
		boolean needsOverride = false;
		
		//do basic prepare on every item
		for (CloudConverterObject current: this.getUploadContext().getCloudConverterObjects()) {
			if (current.isExistsInSalesforce()) {
				needsOverride = true;
				break;
			}
		}
		
		//send to override screen
		if (needsOverride) {
			return Action.INPUT;
		}
		
		//otherwise we're good to go
		return Action.SUCCESS;
	}

	public SalesforceService getSalesforceService() {
		return salesforceService;
	}

	public void setSalesforceService(SalesforceService salesforceService) {
		this.salesforceService = salesforceService;
	}
}
