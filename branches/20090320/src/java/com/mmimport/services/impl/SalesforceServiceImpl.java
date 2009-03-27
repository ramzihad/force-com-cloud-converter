package com.mmimport.services.impl;

import com.mmimport.beans.WrapperBean;
import com.mmimport.services.SalesforceService;
import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.cloudconverter.engine.MigrationContextFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineIF;
import com.modelmetrics.common.sforce.SalesforceCredentials;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.sforce.soap.partner.DescribeGlobalResult;

public class SalesforceServiceImpl implements SalesforceService {

	protected SalesforceCredentials salesforceCredentials;

	public void execute(WrapperBean bean, String username, String password)
			throws Exception {

		SalesforceSession salesforceSession = SalesforceSessionFactory.factory
		.build(salesforceCredentials);

		
		salesforceCredentials.setUsername(username);
		salesforceCredentials.setPassword(password);

		MigrationContext migrationContext = new MigrationContextFactory()
				.buildMigrationContext(salesforceCredentials);

		migrationContext.setWrapperBean(bean);

		MigrationEngineIF migrationEngineIF = new MigrationEngineFactory()
				.build();

		migrationEngineIF.setMigrationContext(migrationContext);

		//check if it needs overriding
		if (bean.getOverride().booleanValue() && containsObject(salesforceSession, bean.getSheetName())){
			//delete object here
		}
		
		// execute it.
		migrationEngineIF.execute(bean);
	}

	public boolean containsObject(SalesforceSession salesforceSession,
			String objectName) throws Exception {
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

	public void setSalesforceCredentials(
			SalesforceCredentials salesforceCredentials) {
		this.salesforceCredentials = salesforceCredentials;
	}
}
