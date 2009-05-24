package com.modelmetrics.cloudconverter.engine;

import java.util.List;

import com.modelmetrics.cloudconverter.forceutil.CustomObjectBuilder;
import com.modelmetrics.cloudconverter.forceutil.DataInsertExecutor;
import com.modelmetrics.cloudconverter.forceutil.DataUpsertExecutor;
import com.modelmetrics.cloudconverter.mmimport.services.CloudConverterObject;
import com.modelmetrics.cloudconverter.util.MetadataProxy;
import com.sforce.soap._2006._04.metadata.CustomObject;

public class MigrationEngineCloudConverterObjectImpl extends
		AbstractMigrationEngine {

	public void execute() throws Exception {

		this.publishStatus("Beginning migration");
		
		CloudConverterObject cloudConverterObject = this.getMigrationContext().getCloudConverterObject();
		
		List<MetadataProxy> metadataProxies = cloudConverterObject.getMetadataProxies();

		this.getMigrationContext().setMetadataProxies(metadataProxies);

		// check if it needs overriding	
		this.cleanUpOrg(cloudConverterObject.getObjectName(), cloudConverterObject.getObjectLabel(), cloudConverterObject.isExistsInSalesforce());

		/*
		 * build the basic custom object
		 */
		CustomObject co = new CustomObjectBuilder().build(cloudConverterObject.getObjectName(), cloudConverterObject.getObjectLabel());

		this.executeCommon(co);

		/*
		 * Move the data
		 */
		
		this.getMigrationContext().setWrapperBean(cloudConverterObject.getOriginalData());
		try {
			if (cloudConverterObject.getUpsertField() == null) {
				new DataInsertExecutor().execute(this.getMigrationContext());
			} else {
				new DataUpsertExecutor().execute(this.getMigrationContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.publishStatus("Found a problem: " + e.getLocalizedMessage());
			throw new RuntimeException(e);
		}

		// new DefaultPageLayoutFinder(this.getMigrationContext()).getLayout();

		log.info("complete");

	}

}
