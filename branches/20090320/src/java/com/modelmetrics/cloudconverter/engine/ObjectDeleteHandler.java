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
package com.modelmetrics.cloudconverter.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.cc.importxls.svcs.CloudConverterObject;
import com.modelmetrics.cloudconverter.forceutil.DeleteExecutor;
import com.modelmetrics.cloudconverter.util.MigrationStatusSubscriber;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.sforce.soap._2006._04.metadata.CustomObject;
import com.sforce.soap.partner.Field;

/**
 * We often need to clean objects out of an org. If these objects are related to
 * each other, we need to delete them in a particular order to avoid failure.
 * This determines that order and executes the delete.
 * 
 * @author reidcarlberg
 * @since 2009-05-25
 * 
 */
public class ObjectDeleteHandler {

	private static final Log log = LogFactory.getLog(ObjectDeleteHandler.class);

	private MigrationStatusSubscriber statusSubscriber;
	private SalesforceSession salesforceSession;

	public void execute(SalesforceSession salesforceSession,
			List<CloudConverterObject> cloudConverterObjects,
			MigrationStatusSubscriber migrationStatusSubscriber)
			throws Exception {

		// quick sanity check
		assert (cloudConverterObjects != null && cloudConverterObjects.size() > 0);
		assert (salesforceSession != null || salesforceSession
				.getSalesforceService() != null);

		// configure
		this.statusSubscriber = migrationStatusSubscriber;
		this.salesforceSession = salesforceSession;

		// temporary list
		List<CloudConverterObject> targetList = null;

		// do we need to re-order?
		if (cloudConverterObjects.size() > 1) {
			targetList = determineOrder(cloudConverterObjects);
		} else {
			targetList = new ArrayList<CloudConverterObject>();
			targetList.add(cloudConverterObjects.get(0));
		}

		// execute delete
		for (CloudConverterObject current : targetList) {
			this.handleDelete(current.getObjectName(),
					current.getObjectLabel(), current.isExistsInSalesforce());
		}
	}

	public List<CloudConverterObject> determineOrder(
			List<CloudConverterObject> originalList) throws Exception {

		// status
		this.statusSubscriber.publish("Determining Object Delete Order");

		// build a map of fields to describe sobject results
		Map<String, ObjectDeleteBean> sobjects = new HashMap<String, ObjectDeleteBean>();

		for (CloudConverterObject current : originalList) {
			if (current.isExistsInSalesforce()) {
				ObjectDeleteBean objectDeleteBean = new ObjectDeleteBean();
				objectDeleteBean.setOriginal(current);
				objectDeleteBean
						.setDescribeSObjectResult(this.salesforceSession
								.getSalesforceService().describeSObject(
										current.getObjectName()));
				sobjects.put(current.getObjectName(), objectDeleteBean);
			}
		}

		// determine order -- in the case where there is a many to one
		// relationship,
		// we must delete the many side of the relationship before we delete the
		// one.
		for (String objectName : sobjects.keySet()) {
			log.info("inspecting: " + objectName);

			ObjectDeleteBean current = sobjects.get(objectName);

			Set<String> otherObjects = new TreeSet<String>();
			otherObjects.addAll(sobjects.keySet());
			otherObjects.remove(objectName);

			for (Field field : current.getDescribeSObjectResult().getFields()) {
				if (field.getType().getValue().equalsIgnoreCase("reference")) {
					if (field.getReferenceTo().length == 1) {
						if (otherObjects.contains(field.getReferenceTo(0))) {
							current.getOtherObjectRef().add(
									field.getReferenceTo(0));
							log.info("reference to.." + field.getReferenceTo(0));
							
							current.setRefToOtherObjectCount(current.getRefToOtherObjectCount() + 1);
						}
					}
				}
			}
		}
		
		//sort them by reference count, highest first then return
		Set<ObjectDeleteBean> sortedSet = new TreeSet<ObjectDeleteBean>(new ObjectDeleteBeanComparator());
		sortedSet.addAll(sobjects.values());
		
		

		List<CloudConverterObject> ret = new ArrayList<CloudConverterObject>();
		
		for (ObjectDeleteBean current : sortedSet) {
			ret.add(current.getOriginal());
			log.info(current.getOriginal().getObjectName());
		}

		return ret;
	}

	public void handleDelete(String objectName, String objectLabel,
			boolean delete) throws Exception {

		// check if it needs overriding
		if (delete) {

			this.statusSubscriber.publish("Deleting existing object - "
					+ objectLabel);
			// delete object here
			CustomObject co = new CustomObject();
			co.setFullName(objectName);
			new DeleteExecutor(this.salesforceSession.getMetadataService())
					.executeSimpleDelete(co);
			log.info("Deleting object " + objectLabel + " from salesforce...");
			this.statusSubscriber.publish("Delete complete - " + objectLabel);
		}
	}

}
