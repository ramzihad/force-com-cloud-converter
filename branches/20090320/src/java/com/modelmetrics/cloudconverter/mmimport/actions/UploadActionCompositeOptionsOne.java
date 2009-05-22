package com.modelmetrics.cloudconverter.mmimport.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.modelmetrics.cloudconverter.mmimport.services.AdvanceOptionsBean;
import com.modelmetrics.cloudconverter.mmimport.services.Constants;
import com.modelmetrics.cloudconverter.mmimport.services.LookupAndIdWrapper;
import com.modelmetrics.cloudconverter.mmimport.services.OptionsOneBean;
import com.modelmetrics.cloudconverter.mmimport.services.SalesforceService;
import com.modelmetrics.cloudconverter.mmimport.services.StringUtils;
import com.modelmetrics.cloudconverter.mmimport.services.ValueId;
import com.modelmetrics.cloudconverter.mmimport.services.WrapperBean;
import com.modelmetrics.cloudconverter.util.ExternalIdBean;
import com.modelmetrics.cloudconverter.util.LookupBean;

public class UploadActionCompositeOptionsOne extends AbstractUploadContextAware
		implements ServletRequestAware {

	private static final long serialVersionUID = -3145368694251083353L;

	private static final Logger log = Logger
			.getLogger(UploadActionCompositeOptionsOne.class);
	private HttpServletRequest request;

	private SalesforceService salesforceService;

	private List<OptionsOneBean> advanceOptionsWrapperBeans;

	private List<LookupAndIdWrapper> lookupIdWrapperList;

	private List<ValueId> fieldTypes;

	private List<ValueId> uniques;

	private List<ValueId> salesforceObjects = new ArrayList<ValueId>();

	private List<ValueId> objectFields = new ArrayList<ValueId>();

	boolean foundExternalId;

	boolean foundLookup;

	boolean externalIdUnique;

	private List<String> sheets;

	public String backToOptionsOne() {

		advanceOptionsWrapperBeans = this.getUploadContext()
				.getAdvanceOptionsWrapperBeans();

		fieldTypes = StringUtils.getAllFieldTypes();
		return SUCCESS;
	}

	public String execute() throws Exception {

		try {
			// get session structure information
			List<OptionsOneBean> sessionAdvanceOptionsWrapperBeans = this
					.getUploadContext().getAdvanceOptionsWrapperBeans();

			// merge edited information with session info
			int i = 0;
			for (OptionsOneBean optionOne : sessionAdvanceOptionsWrapperBeans) {
				mergeInformation(optionOne.getAdvanceOptionsBeans(),
						advanceOptionsWrapperBeans.get(i)
								.getAdvanceOptionsBeans());
				i++;
			}
			// set edited information in session
			this.getUploadContext().setAdvanceOptionsWrapperBeans(
					sessionAdvanceOptionsWrapperBeans);


			this.getUploadContext().setWrapperBeans(updateWrapperBeans(sessionAdvanceOptionsWrapperBeans,this.getUploadContext()
					.getWrapperBeans()));

			lookupIdWrapperList = checkForSpecialData(sessionAdvanceOptionsWrapperBeans);
			this.getUploadContext().setAuxList(lookupIdWrapperList);
			foundExternalId = checkExternalIds(lookupIdWrapperList);
			foundLookup = checkLookups(lookupIdWrapperList);
			if (foundExternalId) {
				// there are external ids, go to advance page 2
				uniques = StringUtils.getUniques();
				return "importOptionsTwo";
			} else {
				if (foundLookup) {
					// there are no external IDs, but lookups, go to advance
					// page 3
					salesforceObjects = salesforceService
							.getAllSalesforcObjects();
					return "importOptionsThree";
				} else {
					// object exists in salesforce, go to check override page
					sheets = salesforceService.checkObject(this
							.getUploadContext());
					if (!sheets.isEmpty()) {
						request.setAttribute("backPage", "backToOptionsOne");
						request.setAttribute("sheets", sheets);
						return "override";
					} else {
						// import directly
						log.info("Generating Salesforce object now...");
						salesforceService.executeMultiple(this
								.getUploadContext());
						return "view";
					}
				}
			}
		} catch (Exception e) {
			message = "There has been a problem";
			log.error(message, e);
			addActionMessage(e.getMessage());
			return ERROR;

		}
	}
	
	private List<WrapperBean> updateWrapperBeans(
			List<OptionsOneBean> sessionAdvanceOptionsWrapperBeans,
			List<WrapperBean> wrapperBeans) {
		int j = 0;
		for (OptionsOneBean optionOne : sessionAdvanceOptionsWrapperBeans) {
			WrapperBean bean = wrapperBeans.get(j);
			transformToWrapperBean(optionOne.getAdvanceOptionsBeans(), bean);
			j++;
		}
		
		return wrapperBeans;
	}

	private void transformToWrapperBean(List<AdvanceOptionsBean> advanceBeans,
			WrapperBean wrapperBean) {

		List<String> types = new ArrayList<String>();
		List<String> labels = new ArrayList<String>();

		for (AdvanceOptionsBean advanceOptionsBean : advanceBeans) {
			types.add(advanceOptionsBean.getType());
			labels.add(advanceOptionsBean.getLabel());
		}

		wrapperBean.setLabels(labels);
		wrapperBean.setTypes(types);
	}

	private boolean checkLookups(List<LookupAndIdWrapper> lookupIdWrapperList2) {
		for (LookupAndIdWrapper lookupAndIdWrapper : lookupIdWrapperList2) {
			if (!lookupAndIdWrapper.getLookups().isEmpty()) {
				return true;
			}
		}
		return false;
	}

	private boolean checkExternalIds(
			List<LookupAndIdWrapper> lookupIdWrapperList2) {
		for (LookupAndIdWrapper lookupAndIdWrapper : lookupIdWrapperList2) {
			if (!lookupAndIdWrapper.getExternalIds().isEmpty()) {
				return true;
			}
		}
		return false;
	}

	private void mergeInformation(List<AdvanceOptionsBean> advanceBeans,
			List<AdvanceOptionsBean> updatedAdvanceBeans) {
		int i = 0;
		for (AdvanceOptionsBean advanceOptionsBean : updatedAdvanceBeans) {
			advanceBeans.get(i).setType(advanceOptionsBean.getType());
			advanceBeans.get(i).setLabel(advanceOptionsBean.getLabel());
			i++;
		}
	}

	private List<LookupAndIdWrapper> checkForSpecialData(
			List<OptionsOneBean> list) {

		List<LookupAndIdWrapper> lookIpWrapper = new ArrayList<LookupAndIdWrapper>();

		for (OptionsOneBean optionOneBean : list) {
			LookupAndIdWrapper wrap = new LookupAndIdWrapper();
			List<ExternalIdBean> externalIds = new ArrayList<ExternalIdBean>();
			List<LookupBean> lookups = new ArrayList<LookupBean>();
			for (AdvanceOptionsBean advanceOptionsBean : optionOneBean
					.getAdvanceOptionsBeans()) {
				if (Constants.EXTERNAL_ID.equals(advanceOptionsBean.getType())) {
					ExternalIdBean extId = new ExternalIdBean(
							advanceOptionsBean.getLabel(), false);
					extId.setName(advanceOptionsBean.getName());
					externalIds.add(extId);
				}
				if (Constants.LOOKUP.equals(advanceOptionsBean.getType())) {
					LookupBean look = new LookupBean();
					look.setLabel(advanceOptionsBean.getLabel());
					look.setName(advanceOptionsBean.getName());
					look.setSourceField("");
					look.setSourceObject("");
					lookups.add(look);
				}
			}
			wrap.setExternalIds(externalIds);
			wrap.setLookups(lookups);
			lookIpWrapper.add(wrap);
		}
		return lookIpWrapper;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public SalesforceService getSalesforceService() {
		return salesforceService;
	}

	public void setSalesforceService(SalesforceService salesforceService) {
		this.salesforceService = salesforceService;
	}

	public List<OptionsOneBean> getAdvanceOptionsWrapperBeans() {
		return advanceOptionsWrapperBeans;
	}

	public void setAdvanceOptionsWrapperBeans(
			List<OptionsOneBean> advanceOptionsWrapperBeans) {
		this.advanceOptionsWrapperBeans = advanceOptionsWrapperBeans;
	}

	public List<LookupAndIdWrapper> getLookupIdWrapperList() {
		return lookupIdWrapperList;
	}

	public void setLookupIdWrapperList(
			List<LookupAndIdWrapper> lookupIdWrapperList) {
		this.lookupIdWrapperList = lookupIdWrapperList;
	}

	public List<ValueId> getFieldTypes() {
		return fieldTypes;
	}

	public void setFieldTypes(List<ValueId> fieldTypes) {
		this.fieldTypes = fieldTypes;
	}

	public List<ValueId> getUniques() {
		return uniques;
	}

	public void setUniques(List<ValueId> uniques) {
		this.uniques = uniques;
	}

	public List<ValueId> getSalesforceObjects() {
		return salesforceObjects;
	}

	public void setSalesforceObjects(List<ValueId> salesforceObjects) {
		this.salesforceObjects = salesforceObjects;
	}

	public List<ValueId> getObjectFields() {
		return objectFields;
	}

	public void setObjectFields(List<ValueId> objectFields) {
		this.objectFields = objectFields;
	}

	public boolean isFoundExternalId() {
		return foundExternalId;
	}

	public void setFoundExternalId(boolean foundExternalId) {
		this.foundExternalId = foundExternalId;
	}

	public boolean isFoundLookup() {
		return foundLookup;
	}

	public void setFoundLookup(boolean foundLookup) {
		this.foundLookup = foundLookup;
	}

	public boolean isExternalIdUnique() {
		return externalIdUnique;
	}

	public void setExternalIdUnique(boolean externalIdUnique) {
		this.externalIdUnique = externalIdUnique;
	}

	public List<String> getSheets() {
		return sheets;
	}

	public void setSheets(List<String> sheets) {
		this.sheets = sheets;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
