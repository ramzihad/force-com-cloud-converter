package com.modelmetrics.cloudconverter.importxls.struts2;

import java.util.List;
import java.util.Map;

import com.modelmetrics.cloudconverter.importxls.services.CloudConverterObject;
import com.modelmetrics.cloudconverter.util.OperationStatusSubscriber;

public class UploadContext  {

	private Exception lastException;

	private List<CloudConverterObject> cloudConverterObjects;
		
	private OperationStatusSubscriber statusSubscriber;
	
	private int currentCloudConverterObjectIndex = -1;

	private Map<String, List<String>> objectToIdMap;
	
	private Map<String, List<String>> objectToFieldMap;
	
	private boolean okToDelete;
	
	private String message;
	
	public Map<String, List<String>> getObjectToIdMap() {
		return objectToIdMap;
	}

	public void setObjectToIdMap(Map<String, List<String>> objectToIdMap) {
		this.objectToIdMap = objectToIdMap;
	}

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
		return this.getLastException().getMessage() ;
	}

	public OperationStatusSubscriber getStatusSubscriber() {
		return statusSubscriber;
	}

	public void setStatusSubscriber(OperationStatusSubscriber statusSubscriber) {
		this.statusSubscriber = statusSubscriber;
	}

	public List<CloudConverterObject> getCloudConverterObjects() {
		return cloudConverterObjects;
	}

	public void setCloudConverterObjects(
			List<CloudConverterObject> cloudConverterObjects) {
		this.cloudConverterObjects = cloudConverterObjects;
	}

	public boolean isOkToDelete() {
		return okToDelete;
	}

	public void setOkToDelete(boolean okToDelete) {
		this.okToDelete = okToDelete;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, List<String>> getObjectToFieldMap() {
		return objectToFieldMap;
	}

	public void setObjectToFieldMap(Map<String, List<String>> objectToFieldMap) {
		this.objectToFieldMap = objectToFieldMap;
	}




}
