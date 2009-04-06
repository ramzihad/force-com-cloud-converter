package com.modelmetrics.cloudconverter.engine;

import java.util.List;

import com.modelmetrics.cloudconverter.forceutil.CustomObjectBuilder;
import com.modelmetrics.cloudconverter.forceutil.DataInsertExecutor;
import com.modelmetrics.cloudconverter.forceutil.DataUpsertExecutor;
import com.modelmetrics.cloudconverter.forceutil.DeleteExecutor;
import com.modelmetrics.cloudconverter.mmimport.services.WrapperBean;
import com.modelmetrics.cloudconverter.util.MetadataProxy;
import com.modelmetrics.cloudconverter.util.MetadataProxyCollectionBuilder;
import com.sforce.soap._2006._04.metadata.CustomObject;

public class MigrationEngineWrapperBeanImpl extends AbstractMigrationEngine
		implements MigrationEngineIF {

	
	public void execute() throws Exception {
		this.createCustomObject();
	}


	private void createCustomObject() throws Exception {

		this.publishStatus("Beginning migration");
		
		WrapperBean bean = this.getMigrationContext().getWrapperBean();
		
		/*
		 * 2009-03-21 RSC Convert that over to a MetadataProxy
		 */
		List<MetadataProxy> metadataProxies = new MetadataProxyCollectionBuilder()
				.build(bean);

		this.getMigrationContext().setMetadataProxies(metadataProxies);

		// check if it needs overriding
		if (bean.getOverride().booleanValue()) {
			
			this.publishStatus("Deleting existing object");
			// delete object here
			CustomObject co = new CustomObject();
			co.setFullName(bean.getSheetName()+"__c");
			new DeleteExecutor(this.getMigrationContext()
					.getSalesforceSession().getMetadataService())
					.executeSimpleDelete(co);
			log.info("Deleting object "+bean.getSheetName()+" from salesforce...");
			this.publishStatus("Delete complete");
		}

		/*
		 * 2009-03-21 RSC //TODO rs should probably be a little more generic as
		 * well but not changing for right now.
		 */

		/*
		 * build the basic custom object
		 */
		CustomObject co = new CustomObjectBuilder().build(bean);

		this.executeCommon(co);

		/*
		 * Move the data
		 */
		try {
			if (this.getMigrationContext().getExternalIdForUpsert() == null) {
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
