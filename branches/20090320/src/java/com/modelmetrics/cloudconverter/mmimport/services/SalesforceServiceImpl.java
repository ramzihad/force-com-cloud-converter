package com.modelmetrics.cloudconverter.mmimport.services;

import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.cloudconverter.engine.MigrationContextFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineIF;
import com.modelmetrics.cloudconverter.mmimport.actions.UploadContext;

public class SalesforceServiceImpl extends AbstractSalesforceService {

	public void execute(UploadContext uploadContext) throws Exception {

		for (CloudConverterObject current : uploadContext
				.getCloudConverterObjects()) {

			// notify subscribers
			uploadContext.getStatusSubscriber().publish(
					"Starting object: " + current.getObjectLabel() + " ("
							+ current.getObjectName() + ")");

			// get started
			MigrationContext migrationContext = new MigrationContextFactory()
					.buildMigrationContext(this.getSalesforceSession());

			migrationContext.setCloudConverterObject(current);

			MigrationEngineIF migrationEngineIF = new MigrationEngineFactory()
					.build(migrationContext);
			migrationEngineIF.setMigrationContext(migrationContext);
			migrationEngineIF.subscribeToStatus(uploadContext.getStatusSubscriber());
			migrationEngineIF.execute();
			
			uploadContext.getStatusSubscriber().publish(
					"Object complete: " + current.getObjectLabel() + " ("
							+ current.getObjectName() + ")");

		}

	}

}
