package com.modelmetrics.cloudconverter.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.cloudconverter.engine.AbstractMigrationEngine;

public class OperationStatusPublisherSupport {

	protected static final Log log = LogFactory
			.getLog(OperationStatusPublisherSupport.class);

	public List<OperationStatusSubscriber> subscribers = new ArrayList<OperationStatusSubscriber>();

	public void subscribeToStatus(
			OperationStatusSubscriber migrationStatusSubscriber) {
		subscribers.add(migrationStatusSubscriber);
	}

	public void publishStatus(String status) {
		for (Iterator<OperationStatusSubscriber> iterator = subscribers
				.iterator(); iterator.hasNext();) {
			OperationStatusSubscriber type = iterator.next();
			if (type != null)
				type.publish(status);

		}
	}
}
