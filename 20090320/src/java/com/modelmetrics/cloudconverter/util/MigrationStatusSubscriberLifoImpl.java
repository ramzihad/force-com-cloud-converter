package com.modelmetrics.cloudconverter.util;

import java.util.ArrayList;
import java.util.List;

public class MigrationStatusSubscriberLifoImpl implements
		MigrationStatusSubscriber {
	
	private List<String> status = new ArrayList<String>();
	
	public void publish(String migrationEvent) {
		status.add(0, migrationEvent);
	}
	
	public List<String> getStatus() {
		return status;
	}

}
