package com.modelmetrics.cloudconverter.mmimport.services;

import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.cloudconverter.engine.MigrationContextFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineIF;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.sforce.soap.partner.DescribeGlobalResult;

public class SalesforceServiceImpl implements SalesforceService {

	private SalesforceSession salesforceSession;
	


	public void execute(WrapperBean bean)
			throws Exception {

		
//		salesforceCredentials.setUsername(username);
//		salesforceCredentials.setPassword(password);
		

		MigrationContext migrationContext = new MigrationContextFactory()
				.buildMigrationContext(this.getSalesforceSession());

		migrationContext.setWrapperBean(bean);

		MigrationEngineIF migrationEngineIF = new MigrationEngineFactory()
				.build(migrationContext);

		migrationEngineIF.setMigrationContext(migrationContext);
		
		// execute it.
		migrationEngineIF.execute();
	}
	
	public boolean checkObject(WrapperBean bean) throws Exception{

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


	public SalesforceSession getSalesforceSession() {
		return salesforceSession;
	}

	public void setSalesforceSession(SalesforceSession salesforceSession) {
		this.salesforceSession = salesforceSession;
	}

}
