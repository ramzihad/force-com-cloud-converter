package com.modelmetrics.cloudconverter.mmimport.actions;

import java.util.List;

import com.modelmetrics.cloudconverter.mmimport.services.CloudConverterObject;
import com.modelmetrics.cloudconverter.util.MigrationStatusSubscriber;

public class UploadContext  {

	private Exception lastException;

	private List<CloudConverterObject> cloudConverterObjects;
		
	private MigrationStatusSubscriber statusSubscriber;
	
	private int currentCloudConverterObjectIndex = -1;


	public int getCurrentCloudConverterObjectIndex() {
		return currentCloudConverterObjectIndex;
	}

	public void setCurrentCloudConverterObjectIndex(
			int currentCloudConverterObjectIndex) {
		this.currentCloudConverterObjectIndex = currentCloudConverterObjectIndex;
	}
	
	public CloudConverterObject getCurrentCloudConverterObject() {
		if (this.getCurrentCloudConverterObjectIndex() < 0 || this.getCurrentCloudConverterObjectIndex() > this.getCloudConverterObjects().size() -1) {
			throw new RuntimeException("invalid cloud converter object index.");
		}
		return this.getCloudConverterObjects().get(this.getCurrentCloudConverterObjectIndex());
	}
	
	public boolean isNextCloudConverterObjectPresent() {
		return this.getCurrentCloudConverterObjectIndex() < this.getCloudConverterObjects().size() -1;
	}

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

	public List<CloudConverterObject> getCloudConverterObjects() {
		return cloudConverterObjects;
	}

	public void setCloudConverterObjects(
			List<CloudConverterObject> cloudConverterObjects) {
		this.cloudConverterObjects = cloudConverterObjects;
	}



}
