package com.modelmetrics.cloudconverter.mmimport.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.modelmetrics.common.sforce.SalesforceSession;
import com.sforce.soap.partner.DescribeGlobalResult;
import com.sforce.soap.partner.DescribeSObjectResult;
import com.sforce.soap.partner.Field;

public abstract class AbstractSalesforceService implements SalesforceService {

	static final Logger log = Logger
			.getLogger(AbstractSalesforceService.class);

	private SalesforceSession salesforceSession;

	private static final String[] EXCLUDE_FILTERS = { "__Tag", "__Share",
			"__History", "Apex" };

	private static final String[] INCLUDE_FILTERS = { "__c", "Account",
			"Asset", "Case", "Contact", "Contract", "Lead", "Opportunity",
			"Product2", "User" };

//	public List<String> checkObject(UploadContext uploadContext)
//			throws Exception {
//
//		List<ExcelWorksheetWrapperBean> wrapperBeans = uploadContext
//				.getWrapperBeans();
//		List<String> result = new ArrayList<String>();
//		for (ExcelWorksheetWrapperBean wrapperBean : wrapperBeans) {
//			if (containsObject(salesforceSession, wrapperBean.getSheetName())) {
//				result.add(wrapperBean.getSheetName());
//			}
//		}
//
//		return result;
//
//	}

	/*
	 * 2009-05-23 -- changed to use the positive include filters -- much smaller
	 * list of items.
	 */
	private boolean applyFilter(String object) {
		for (int i = 0; i < INCLUDE_FILTERS.length; i++) {
			String filter = INCLUDE_FILTERS[i];
			// added begins with to Filter out
			if (object.endsWith(filter) || object.equalsIgnoreCase(filter)) {
				return true;
			}
		}
		return false;
	}

	public List<ValueId> getFieldsForObject(String object) throws Exception {
		DescribeSObjectResult result = salesforceSession.getSalesforceService()
				.describeSObject(object);
		List<ValueId> list = new ArrayList<ValueId>();
		for (Field field : result.getFields()) {
			// 2009-05-23 RSC added filter condition back in.
			if ((field.getExternalId() != null && field.getExternalId()
					.booleanValue())
					|| field.getName().equals("Id")) {
				list.add(new ValueId(field.getName(), field.getName()));
			}
		}
		return list;

	}

	public boolean containsObject(String objectName) throws Exception {
		DescribeGlobalResult result = salesforceSession.getSalesforceService()
				.describeGlobal();

		boolean foundType = false;
		
		for (int i = 0; i < result.getTypes().length; i++) {
			String name = result.getTypes(i);
			if (name.equalsIgnoreCase(objectName)) {
				foundType = true;
			}
		}

		return foundType;
	}

	public List<ValueId> getAllSalesforcObjects() throws Exception {
		DescribeGlobalResult result = salesforceSession.getSalesforceService()
				.describeGlobal();
		
		
		
		List<ValueId> list = new ArrayList<ValueId>();
		list.add(new ValueId("Select", ""));
		for (String object : result.getTypes()) {
			if (applyFilter(object)) {
				list.add(new ValueId(object, object));
			}
		}
		return list;

	}

	
	public SalesforceSession getSalesforceSession() {
		return salesforceSession;
	}

	public void setSalesforceSession(SalesforceSession salesforceSession) {
		this.salesforceSession = salesforceSession;
	}

}
