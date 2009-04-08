package com.modelmetrics.cloudconverter.mmimport.services;

import java.util.ArrayList;
import java.util.List;

import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.cloudconverter.engine.MigrationContextFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineIF;
import com.modelmetrics.cloudconverter.mmimport.actions.UploadContext;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.sforce.soap.partner.DescribeGlobalResult;
import com.sforce.soap.partner.DescribeSObjectResult;
import com.sforce.soap.partner.Field;

public class SalesforceServiceImpl implements SalesforceService {

	private SalesforceSession salesforceSession;

	public void execute(UploadContext uploadContext) throws Exception {

		// salesforceCredentials.setUsername(username);
		// salesforceCredentials.setPassword(password);

		MigrationContext migrationContext = new MigrationContextFactory()
				.buildMigrationContext(this.getSalesforceSession());

		migrationContext.setWrapperBean(uploadContext.getWrapperBean());

		MigrationEngineIF migrationEngineIF = new MigrationEngineFactory()
				.build(migrationContext);

		migrationEngineIF.setMigrationContext(migrationContext);

		migrationEngineIF
				.subscribeToStatus(uploadContext.getStatusSubscriber());

		// execute it.
		migrationEngineIF.execute();
	}

	public boolean checkObject(UploadContext uploadContext) throws Exception {

		return containsObject(salesforceSession, uploadContext.getWrapperBean()
				.getSheetName());

	}

	private boolean containsObject(SalesforceSession salesforceSession,
			String objectName) throws Exception {
		DescribeGlobalResult result = salesforceSession.getSalesforceService()
				.describeGlobal();

		boolean foundType = false;
		objectName += "__c";
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
		for (String object : result.getTypes()) {
			list.add(new ValueId(object, object));
		}
		return list;

	}

	public List<ValueId> getFieldsForObject(String object) throws Exception {
		DescribeSObjectResult result = salesforceSession.getSalesforceService()
				.describeSObject(object);
		List<ValueId> list = new ArrayList<ValueId>();
		for (Field field : result.getFields()) {
			list.add(new ValueId(field.getName(), field.getName()));
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
