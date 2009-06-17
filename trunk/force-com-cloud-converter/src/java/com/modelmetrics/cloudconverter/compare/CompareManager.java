package com.modelmetrics.cloudconverter.compare;

import java.util.HashMap;
import java.util.Map;

import com.modelmetrics.common.sforce.SalesforceSession;

public class CompareManager {

	public static final CompareManager singleton = new CompareManager();

	private final Map<String, ComparisonGroup> comparisonGroups = new HashMap<String, ComparisonGroup>();

	public ComparisonGroup getComparisonGroup (String groupKey) {
		if (!isValid(groupKey)) {
			throw new RuntimeException("No group key");
		}
		
		return this.comparisonGroups.get(groupKey);
	}
	
	public boolean isValid(String groupKey) {
		return comparisonGroups.containsKey(groupKey);
	}

	public String createGroup(SalesforceSession salesforceSession) {

		String newKey = "";

		if (comparisonGroups.keySet().contains(newKey)) {
			throw new RuntimeException("Failed to generate a unique key");
		}

		ComparisonGroup comparisonGroup = new ComparisonGroup(newKey);

		ComparisonSession comparisonSession = new ComparisonSession(newKey,
				salesforceSession);

		try {
			new ComparisonSessionObjectInfoDecorator()
					.execute(comparisonSession);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		comparisonGroup.addComparisonSession(comparisonSession);

		return newKey;
	}

	public void joinGroup(String groupKey, SalesforceSession salesforceSession) {

		if (this.isValid(groupKey)) {
			throw new RuntimeException("Invalid group key.");
		}

		ComparisonSession comparisonSession = new ComparisonSession(groupKey,
				salesforceSession);

		try {
			new ComparisonSessionObjectInfoDecorator()
					.execute(comparisonSession);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		ComparisonGroup comparisonGroup = this.comparisonGroups.get(groupKey);

		comparisonGroup.addComparisonSession(comparisonSession);

	}
}
