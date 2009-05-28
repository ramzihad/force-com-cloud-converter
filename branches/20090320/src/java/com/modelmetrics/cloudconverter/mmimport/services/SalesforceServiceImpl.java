package com.modelmetrics.cloudconverter.mmimport.services;

import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.cloudconverter.engine.MigrationContextFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineIF;
import com.modelmetrics.cloudconverter.mmimport.actions.UploadContext;
import com.modelmetrics.cloudconverter.util.MigrationStatusSubscriber;

public class SalesforceServiceImpl extends AbstractSalesforceService {

	private UploadContext uploadContext;
	
	public void execute(UploadContext uploadContext) throws Exception {

		this.uploadContext = uploadContext;
		
		for (CloudConverterObject current : uploadContext
				.getCloudConverterObjects()) {

			this.execute(current, uploadContext.getStatusSubscriber());

		}

	}
	
	public void execute(CloudConverterObject current, MigrationStatusSubscriber migrationStatusSubscriber) throws Exception {
		
		// reset status
		migrationStatusSubscriber.reset();
		
		// notify subscribers
		migrationStatusSubscriber.publish(
				"Starting object: " + current.getObjectLabel() + " ("
						+ current.getObjectName() + ")");

		// get started
		MigrationContext migrationContext = new MigrationContextFactory()
				.buildMigrationContext(this.getSalesforceSession());

		migrationContext.setCloudConverterObject(current);
		
		migrationContext.setPicklistFields(current.getPicklistFields());

		MigrationEngineIF migrationEngineIF = new MigrationEngineFactory()
				.build(migrationContext);
		migrationEngineIF.setMigrationContext(migrationContext);
		migrationEngineIF.subscribeToStatus(migrationStatusSubscriber);
		migrationEngineIF.execute();
		
		migrationStatusSubscriber.publish(
				"Object complete: " + current.getObjectLabel() + " ("
						+ current.getObjectName() + ")");
		
	}

}
