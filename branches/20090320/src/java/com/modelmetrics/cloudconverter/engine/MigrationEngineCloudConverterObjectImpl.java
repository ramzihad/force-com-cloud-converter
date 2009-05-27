package com.modelmetrics.cloudconverter.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.modelmetrics.cloudconverter.forceutil.CustomObjectBuilder;
import com.modelmetrics.cloudconverter.forceutil.DataInsertExecutor;
import com.modelmetrics.cloudconverter.forceutil.DataUpsertExecutor;
import com.modelmetrics.cloudconverter.forceutil.LookupSettings;
import com.modelmetrics.cloudconverter.mmimport.services.CloudConverterObject;
import com.modelmetrics.cloudconverter.util.MetadataProxy;
import com.sforce.soap._2006._04.metadata.CustomObject;
import com.sforce.soap._2006._04.metadata.FieldType;

public class MigrationEngineCloudConverterObjectImpl extends
		AbstractMigrationEngine {

	public void execute() throws Exception {

		this.publishStatus("Beginning migration");

		CloudConverterObject cloudConverterObject = this.getMigrationContext()
				.getCloudConverterObject();

		List<MetadataProxy> metadataProxies = cloudConverterObject
				.getMetadataProxies();

		this.getMigrationContext().setMetadataProxies(metadataProxies);

		// build a list of external IDs
		this.getMigrationContext().setExternalIds(new ArrayList<String>());
		for (MetadataProxy metadataProxy : metadataProxies) {
			if (metadataProxy.isUniqueExternalId()) {
				this.getMigrationContext().getExternalIds().add(
						metadataProxy.getName());
				//hacky tacky
				if (cloudConverterObject.getUpsertField() == null) {
					cloudConverterObject.setUpsertField(metadataProxy.getName()+"__c");
				}
			}
		}

		// build a list of lookup relationships
		this.getMigrationContext().setLookupFields(
				new HashMap<String, LookupSettings>());
		for (MetadataProxy metadataProxy : metadataProxies) {
			if (metadataProxy.getType() == FieldType.Lookup) {
				LookupSettings settings = new LookupSettings(metadataProxy
						.getName(), metadataProxy.getLookupObject(),
						metadataProxy.getName() + "__r:"
								+ metadataProxy.getLookupObject() + ":"
								+ metadataProxy.getLookupField());
				this.getMigrationContext().getLookupFields().put(metadataProxy.getName(), settings);
			}
		}

		/*
		 * build the basic custom object
		 */
		CustomObject co = new CustomObjectBuilder().build(cloudConverterObject);

		this.executeCommon(co);

		/*
		 * Move the data
		 */

		this.getMigrationContext().setWrapperBean(
				cloudConverterObject.getOriginalData());
		this.getMigrationContext().setExternalIdForUpsert(cloudConverterObject.getUpsertField());
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
