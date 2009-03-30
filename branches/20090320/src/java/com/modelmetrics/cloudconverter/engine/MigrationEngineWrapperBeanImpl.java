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

		WrapperBean bean = this.getMigrationContext().getWrapperBean();
		
		/*
		 * 2009-03-21 RSC Convert that over to a MetadataProxy
		 */
		List<MetadataProxy> metadataProxies = new MetadataProxyCollectionBuilder()
				.build(bean);

		this.getMigrationContext().setMetadataProxies(metadataProxies);

		// check if it needs overriding
		if (bean.getOverride().booleanValue()) {
			// delete object here
			CustomObject co = new CustomObject();
			co.setFullName(bean.getSheetName()+"__c");
			new DeleteExecutor(this.getMigrationContext()
					.getSalesforceSession().getMetadataService())
					.executeSimpleDelete(co);
			log.info("Deleting object "+bean.getSheetName()+" from salesforce...");
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
		
//		this.getMigrationContext().setCustomObject(co);
//
//		new CreateExecutor(this.getMigrationContext().getSalesforceSession()
//				.getMetadataService(), new CustomObject[] { co }).execute();
//
//		/*
//		 * create custom fields 2009-03-21 RSC This has the migration context so
//		 * it is now aware of the metadata proxy collection
//		 */
//		CustomField[] fields = new CustomFieldBuilder().build(this
//				.getMigrationContext());
//
//		new CreateExecutor(this.getMigrationContext().getSalesforceSession()
//				.getMetadataService(), fields).execute();
//
//		// reseting the session
//		this.getMigrationContext().pauseSession();
//
//		// moving to the lookups
//		if (this.getMigrationContext().getCustomLookupFields() != null
//				&& this.getMigrationContext().getCustomLookupFields().length > 0) {
//			new CreateExecutor(this.getMigrationContext()
//					.getSalesforceSession().getMetadataService(), this
//					.getMigrationContext().getCustomLookupFields()).execute();
//		}
//
//		/*
//		 * Custom Tab
//		 */
//		CustomTab customTab = new CustomTabBuilder().build(co);
//		log.debug("CustomTab - local definition complete - "
//				+ customTab.getFullName());
//
//		new CreateExecutor(this.getMigrationContext().getSalesforceSession()
//				.getMetadataService(), new CustomTab[] { customTab }).execute();
//
//		this.getMigrationContext().pauseSession();
//
//		/*
//		 * update the layout
//		 */
//		LayoutBuilder layoutBuilder = new LayoutBuilder();
//		layoutBuilder.setMigrationContext(this.getMigrationContext());
//		Layout layout = layoutBuilder.build();
//
//		new UpdateExecutor(this.getMigrationContext().getSalesforceSession()
//				.getMetadataService()).executeSimpleUpdate(layout);
//
//		this.getMigrationContext().pauseSession();

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
			throw new RuntimeException(e);
		}

		// new DefaultPageLayoutFinder(this.getMigrationContext()).getLayout();

		log.info("complete");

	}




}
