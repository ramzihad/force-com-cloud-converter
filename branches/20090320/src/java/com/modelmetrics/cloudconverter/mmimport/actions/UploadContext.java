package com.modelmetrics.cloudconverter.mmimport.actions;

import java.util.ArrayList;
import java.util.List;

import com.modelmetrics.cloudconverter.mmimport.services.CloudConverterObject;
import com.modelmetrics.cloudconverter.mmimport.services.SingleFieldOptionsBean;
import com.modelmetrics.cloudconverter.mmimport.services.LookupAndIdWrapper;
import com.modelmetrics.cloudconverter.mmimport.services.SheetOptionsBean;
import com.modelmetrics.cloudconverter.mmimport.services.ExcelWorksheetWrapperBean;
import com.modelmetrics.cloudconverter.util.ExternalIdBean;
import com.modelmetrics.cloudconverter.util.LookupBean;
import com.modelmetrics.cloudconverter.util.MigrationStatusSubscriber;

public class UploadContext  {

	private Exception lastException;

	private List<CloudConverterObject> cloudConverterObjects;
	
	private List<LookupBean> lookups = new ArrayList<LookupBean>();
	

	
	
	private MigrationStatusSubscriber statusSubscriber;


	public Exception getLastException() {
		return lastException;
	}

	public void setLastException(Exception lastException) {
		this.lastException = lastException;
	}

	public String getErrorMessage() {
		return this.getLastException().getMessage() + ", "
				+ this.getLastException().getLocalizedMessage();
	}

	public MigrationStatusSubscriber getStatusSubscriber() {
		return statusSubscriber;
	}

	public void setStatusSubscriber(MigrationStatusSubscriber statusSubscriber) {
		this.statusSubscriber = statusSubscriber;
	}

	public List<LookupBean> getLookups() {
		return lookups;
	}

	public void setLookups(List<LookupBean> lookups) {
		this.lookups = lookups;
	}

	public List<CloudConverterObject> getCloudConverterObjects() {
		return cloudConverterObjects;
	}

	public void setCloudConverterObjects(
			List<CloudConverterObject> cloudConverterObjects) {
		this.cloudConverterObjects = cloudConverterObjects;
	}



}
