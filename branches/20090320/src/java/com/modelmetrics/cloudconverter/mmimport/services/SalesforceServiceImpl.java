package com.modelmetrics.cloudconverter.mmimport.services;

import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.cloudconverter.engine.MigrationContextFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineIF;
import com.modelmetrics.cloudconverter.mmimport.beans.WrapperBean;
import com.modelmetrics.common.sforce.SalesforceCredentials;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.sforce.soap.partner.DescribeGlobalResult;

public class SalesforceServiceImpl implements SalesforceService {

	protected SalesforceCredentials salesforceCredentials;

	public void execute(WrapperBean bean, String username, String password)
			throws Exception {

		
		salesforceCredentials.setUsername(username);
		salesforceCredentials.setPassword(password);
		

		MigrationContext migrationContext = new MigrationContextFactory()
				.buildMigrationContext(salesforceCredentials);

		migrationContext.setWrapperBean(bean);

		MigrationEngineIF migrationEngineIF = new MigrationEngineFactory()
				.build();

		migrationEngineIF.setMigrationContext(migrationContext);
		
		// execute it.
		migrationEngineIF.execute(bean);
	}
	
	public boolean checkObject(WrapperBean bean, String username,
			String password) throws Exception{
		
		salesforceCredentials.setUsername(username);
		salesforceCredentials.setPassword(password);
		
		SalesforceSession salesforceSession = SalesforceSessionFactory.factory
		.build(salesforceCredentials);
		return containsObject(salesforceSession, bean.getSheetName());

	}

	private boolean containsObject(SalesforceSession salesforceSession,
			String objectName) throws Exception {
		DescribeGlobalResult result = salesforceSession.getSalesforceService()
				.describeGlobal();

		boolean foundType = false;
		objectName+="__c";
		for (int i = 0; i < result.getTypes().length; i++) {
			String name = result.getTypes(i);
			if (name.equalsIgnoreCase(objectName)) {
				foundType = true;
			}
		}

		return foundType;
	}

	public void setSalesforceCredentials(
			SalesforceCredentials salesforceCredentials) {
		this.salesforceCredentials = salesforceCredentials;
	}
}
