package com.modelmetrics.cloudconverter.mmimport.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.cloudconverter.engine.MigrationContextFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineIF;
import com.modelmetrics.cloudconverter.forceutil.LookupSettings;
import com.modelmetrics.cloudconverter.mmimport.actions.UploadContext;
import com.modelmetrics.cloudconverter.util.ExternalIdBean;
import com.modelmetrics.cloudconverter.util.LookupBean;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.sforce.soap.partner.DescribeGlobalResult;
import com.sforce.soap.partner.DescribeSObjectResult;
import com.sforce.soap.partner.Field;

public class SalesforceServiceImpl implements SalesforceService {

	private static final Logger log = Logger
			.getLogger(SalesforceServiceImpl.class);

	private SalesforceSession salesforceSession;

	private static final String[] FILTERS = { "__Tag", "__Share", "__History" };

	public void execute(UploadContext uploadContext) throws Exception {

		/*
		 * Map<String, LookupSettings> lookupFields = new HashMap<String,
		 * LookupSettings>(); for (LookupBean lookupBean :
		 * uploadContext.getLookups()) { lookupFields.put(lookupBean.getLabel(),
		 * new LookupSettings( lookupBean.getLabel(),
		 * lookupBean.getSourceObject(), lookupBean.getSourceField())); }
		 */

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

	public void executeMultiple(UploadContext uploadContext) throws Exception {

		List<WrapperBean> beans = uploadContext.getWrapperBeans();
		MigrationContext migrationContext = new MigrationContextFactory()
		.buildMigrationContext(this.getSalesforceSession());
		int i =0;
		for (WrapperBean wrapperBean : beans) {

			Map<String, LookupSettings> lookupFields = new HashMap<String, LookupSettings>();
			LookupAndIdWrapper wrapper = uploadContext.getLookupIdWrapperList().get(i);
			if (wrapper!=null){
				if (wrapper.getLookups()!=null){
					for (LookupBean lookupBean : wrapper.getLookups()) {
						lookupFields.put(lookupBean.getLabel(), new LookupSettings(
								lookupBean.getLabel(), lookupBean.getSourceObject(),
								lookupBean.getSourceField()));
					}
				}
			}
			
			
			migrationContext.setLookupFields(lookupFields);
			migrationContext.setWrapperBean(wrapperBean);
			
			migrationContext.setExternalIds(wrapper.getExternalIds());

			MigrationEngineIF migrationEngineIF = new MigrationEngineFactory()
					.build(migrationContext);

			migrationEngineIF.setMigrationContext(migrationContext);

			migrationEngineIF.subscribeToStatus(uploadContext
					.getStatusSubscriber());

			// execute it.
			migrationEngineIF.execute();
			log.info("Object '" + wrapperBean.getSheetName()
					+ "' saved in salesforce successfully");
			i++;
		}
	}

	public List<String> checkObject(UploadContext uploadContext)
			throws Exception {

		List<WrapperBean> wrapperBeans = uploadContext.getWrapperBeans();
		List<String> result = new ArrayList<String>();
		for (WrapperBean wrapperBean : wrapperBeans) {
			if (containsObject(salesforceSession, wrapperBean.getSheetName())) {
				result.add(wrapperBean.getSheetName());
			}
		}

		return result;

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
		list.add(new ValueId("Select", ""));
		for (String object : result.getTypes()) {
			if (!applyFilter(object)) {
				list.add(new ValueId(object, object));
			}
		}
		return list;

	}

	private boolean applyFilter(String object) {
		for (int i = 0; i < FILTERS.length; i++) {
			String filter = FILTERS[i];
			if (object.endsWith(filter)) {
				return true;
			}
		}
		return false;
	}

	public List<ValueId> getFieldsForObject(String object) throws Exception {
		DescribeSObjectResult result = salesforceSession.getSalesforceService()
				.describeSObject(object);
		List<ValueId> list = new ArrayList<ValueId>();
		for (Field field : result.getFields()) {
			// if (field.getExternalId()!=null && field.getExternalId()){
			list.add(new ValueId(field.getName(), field.getName()));
			// }
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
