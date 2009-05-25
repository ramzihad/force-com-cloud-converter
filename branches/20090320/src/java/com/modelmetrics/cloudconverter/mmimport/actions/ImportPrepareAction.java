package com.modelmetrics.cloudconverter.mmimport.actions;

import com.modelmetrics.cloudconverter.mmimport.services.CloudConverterObject;
import com.modelmetrics.cloudconverter.mmimport.services.CustomObjectNameDecorator;
import com.modelmetrics.cloudconverter.mmimport.services.ExistsInSalesforceDecorator;
import com.modelmetrics.cloudconverter.mmimport.services.SalesforceService;
import com.opensymphony.xwork2.Action;

public class ImportPrepareAction extends AbstractUploadContextAware {

	private SalesforceService salesforceService;
	
	public String execute() throws Exception {
		
		//decorate with object names
		new CustomObjectNameDecorator().decorate(this.getUploadContext().getCloudConverterObjects());
		
		//decorate with exists
		new ExistsInSalesforceDecorator().decorate(this.getUploadContext().getCloudConverterObjects(), this.getSalesforceService());
		
		//does anything already exist? if so, we need to get confirmation that it's OK to continue
		boolean needsOverride = false;
		
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
