package com.modelmetrics.common.sforce.util;

import java.util.Set;
import java.util.TreeSet;

import com.sforce.soap.partner.DescribeGlobalResult;

public class InterestingSobjectFilter {
	
	public Set<String> getInterestSobjects(DescribeGlobalResult describeGlobalResult) {
		
		Set<String> ret = new TreeSet<String>();
		
		for (String currentType : describeGlobalResult.getTypes()) {
		
			if (this.isInteresting(currentType)) {
				ret.add(currentType);
			}
		}
		
		return ret;
	}
	/*
	 * filter out the stuff I don't need to worry about.
	 */
	public boolean isInteresting(String string) {

		boolean ret = true;

		if (string.endsWith("History") || string.endsWith("Share"))
			return false;

		if (string.equalsIgnoreCase("ApexComponent")
				|| string.equalsIgnoreCase("ApexClass")
				|| string.equalsIgnoreCase("ApexTrigger")
				|| string.equalsIgnoreCase("ApexPage"))
			return false;

		if (string.equalsIgnoreCase("ProcessInstance")
				|| string.equalsIgnoreCase("ProcessInstanceHistory")
				|| string.equalsIgnoreCase("ProcessInstanceStep")
				|| string.equals("ProcessInstanceHistory"))
			return false;
		
		if (string.equalsIgnoreCase("Document")
				|| string.equalsIgnoreCase("DocumentAttachmentMap")
				|| string.equalsIgnoreCase("Note")
				|| string.equals("NoteAndAttachment"))
			return false;
		
		if (string.equalsIgnoreCase("EmailServicesAddress")
				|| string.equalsIgnoreCase("EmailServicesFunction")
				|| string.equalsIgnoreCase("EmailStatus"))
			return false;
		
		if (string.equalsIgnoreCase("FiscalYearSettings")
				|| string.equalsIgnoreCase("Folder")
				|| string.equalsIgnoreCase("ForecastShare")
				|| string.equalsIgnoreCase("Group")
				|| string.equalsIgnoreCase("GroupMember"))
			return false;
		
		//for testing only -- just to keep the list short.
		if (!string.equalsIgnoreCase("Account") && !string.equalsIgnoreCase("Contact")) {
			return false;
		}

		return ret;
	}

}
