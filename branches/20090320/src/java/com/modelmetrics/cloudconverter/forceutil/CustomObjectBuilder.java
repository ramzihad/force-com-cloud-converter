/*
The MIT License

Copyright (c) 2008, 2009 Model Metrics, Inc.

http://ModelMetrics.com
http://ModelMetrics.com/authors/rcarlberg

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */

package com.modelmetrics.cloudconverter.forceutil;

import java.sql.ResultSetMetaData;

import com.modelmetrics.cloudconverter.importxls.svcs.CloudConverterObject;
import com.modelmetrics.cloudconverter.importxls.svcs.ExcelWorksheetWrapperBean;
import com.sforce.soap._2006._04.metadata.CustomField;
import com.sforce.soap._2006._04.metadata.CustomObject;
import com.sforce.soap._2006._04.metadata.DeploymentStatus;
import com.sforce.soap._2006._04.metadata.FieldType;
import com.sforce.soap._2006._04.metadata.SharingModel;

public class CustomObjectBuilder {

	/*
	 * 2009-03-21 RSC Refactored so it could be independent of RSMD
	 * 
	 */
	public CustomObject build(ResultSetMetaData rsmd) throws Exception {

		String objectName = null;
		for (int i = 0; i < rsmd.getColumnCount(); i++) {
			objectName = rsmd.getTableName(i + 1);
		}

		return this.build(new CustomObjectNameBuilder().buildCustomObjectName(objectName),objectName);
	}

	public CustomObject build(ExcelWorksheetWrapperBean bean) throws Exception {

		String objectName = bean.getSheetName();
		//check if object exists in salesforce
		
		return this.build(new CustomObjectNameBuilder().buildCustomObjectName(objectName), objectName);
	}

	public CustomObject build(String objectName, String objectLabel) throws Exception {
		
		if (!objectName.endsWith("__c")) {
			throw new RuntimeException("Bad object name. " + objectName);
		}
		
		CustomObject co = new CustomObject();
		
		co.setFullName(objectName);
		co.setDeploymentStatus(DeploymentStatus.Deployed);
		co
				.setDescription("Created by the Cloud Converter from http://ModelMetrics.com");
		co.setEnableActivities(true);
		co.setLabel(objectLabel);
		co.setPluralLabel(co.getLabel() + "s");
		co.setSharingModel(SharingModel.ReadWrite);

		// just putting this in for now -- no technical reason although we
		// always need a name
		CustomField nf = new CustomField();
		nf.setType(FieldType.AutoNumber);
		nf.setStartingNumber(0);
		nf.setDisplayFormat("A-{000000}");
		nf
				.setDescription("The custom object identifier on page layouts, related lists, etc.");
		nf.setLabel(objectLabel + " Name");
		nf.setFullName(objectName + " __c");

		co.setNameField(nf);

		return co;
	}
	
	public CustomObject build(CloudConverterObject cloudConverterObject) throws Exception {
		
		String objectName = cloudConverterObject.getObjectName();
		String objectLabel = cloudConverterObject.getObjectLabel();
		
		if (!objectName.endsWith("__c")) {
			throw new RuntimeException("Bad object name. " + objectName);
		}
		
		CustomObject co = new CustomObject();
		
		co.setFullName(objectName);
		co.setDeploymentStatus(DeploymentStatus.Deployed);
		co
				.setDescription("Created by the Cloud Converter from http://ModelMetrics.com");
		co.setEnableActivities(true);
		co.setLabel(objectLabel);
		co.setPluralLabel(cloudConverterObject.getObjectPlural());
		co.setSharingModel(SharingModel.ReadWrite);

		// just putting this in for now -- no technical reason although we
		// always need a name
		CustomField nf = new CustomField();
		
		//new! to get the 
		if (cloudConverterObject.isNameUseAutonumber()) {
			nf.setType(FieldType.AutoNumber);
			nf.setStartingNumber(0);
			nf.setDisplayFormat("A-{000000}");
		} else {
			nf.setType(FieldType.Text);
			nf.setRequired(Boolean.TRUE);
		}
		
		nf
				.setDescription("The custom object identifier on page layouts, related lists, etc.");
		nf.setLabel(objectLabel + " Name");
		nf.setFullName(objectName + " __c");

		co.setNameField(nf);

		return co;
	}
	

}
