package com.modelmetrics.cloudconverter.mmimport.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.modelmetrics.cloudconverter.mmimport.services.SingleFieldOptionsBean;
import com.modelmetrics.cloudconverter.mmimport.services.Constants;
import com.modelmetrics.cloudconverter.mmimport.services.LookupAndIdWrapper;
import com.modelmetrics.cloudconverter.mmimport.services.SheetOptionsBean;
import com.modelmetrics.cloudconverter.mmimport.services.SalesforceService;
import com.modelmetrics.cloudconverter.mmimport.services.StringUtils;
import com.modelmetrics.cloudconverter.mmimport.services.ValueId;
import com.modelmetrics.cloudconverter.mmimport.services.ExcelWorksheetWrapperBean;
import com.modelmetrics.cloudconverter.util.ExternalIdBean;
import com.modelmetrics.cloudconverter.util.LookupBean;
import com.opensymphony.xwork2.Action;

public class UploadActionCompositeOptionsOne extends AbstractUploadContextAware
		 {

	private static final long serialVersionUID = -3145368694251083353L;
	
	private static final String SUBMIT_BACK = "Back";
	
	private static final String SUBMIT_NEXT = "Next";

	private static final Logger log = Logger
			.getLogger(UploadActionCompositeOptionsOne.class);

	private SalesforceService salesforceService;

	private List<SheetOptionsBean> advanceOptionsWrapperBeans;

	private List<LookupAndIdWrapper> lookupIdWrapperList;

	private List<ValueId> fieldTypes;

	private List<ValueId> uniques;

	

	private List<ValueId> objectFields = new ArrayList<ValueId>();

	boolean foundExternalId;

	boolean foundLookup;

	boolean externalIdUnique;

	private List<String> sheets;
	
	private Map<Long, String> optionsList;

	private String submit;
	
	public Map<Long, String> getOptionsList() {
		return optionsList;
	}

	public void setOptionsList(Map<Long, String> optionsList) {
		this.optionsList = optionsList;
	}



	public String execute() throws Exception {

		return null;
//		//If Submit Is Null, we go to input
//		if (this.getSubmit() == null) {
//			this.advanceOptionsWrapperBeans = this.getUploadContext().getAdvanceOptionsWrapperBeans();
//			fieldTypes = StringUtils.getAllFieldTypes();
//			return Action.INPUT;
//		}
//		//"BACK" means we're not doing advanced options, so we don't care about any changes they made.
//		if (this.getSubmit().equalsIgnoreCase(SUBMIT_BACK)) {
//			return "back";
//		}
//		
//		try {
//			// get session structure information
//			List<SheetOptionsBean> sessionAdvanceOptionsWrapperBeans = this
//					.getUploadContext().getAdvanceOptionsWrapperBeans();
//
//			// merge edited information with session info
//			int i = 0;
//			for (SheetOptionsBean optionOne : sessionAdvanceOptionsWrapperBeans) {
//				mergeInformation(optionOne.getAdvanceOptionsBeans(),
//						advanceOptionsWrapperBeans.get(i)
//								.getAdvanceOptionsBeans());
//				i++;
//			}
//			// set edited information in session
//			this.getUploadContext().setAdvanceOptionsWrapperBeans(
//					sessionAdvanceOptionsWrapperBeans);
//
//			this.getUploadContext().setWrapperBeans(updateWrapperBeans(sessionAdvanceOptionsWrapperBeans,this.getUploadContext()
//					.getWrapperBeans()));
//
//			lookupIdWrapperList = checkForSpecialData(sessionAdvanceOptionsWrapperBeans);
//			this.getUploadContext().setAuxList(lookupIdWrapperList);
//			
//			foundLookup = checkLookups(lookupIdWrapperList);
//
//				if (foundLookup) {
//					// there are no external IDs, but lookups, go to advance
//					// page 3
////					salesforceObjects = salesforceService
////							.getAllSalesforcObjects();
//					return "advanceOptionsThree";
//				} else {
//					//go to confirm page
//					optionsList = StringUtils.getOptions();
//					return "confirm";
//				}
//		} catch (Exception e) {
//			message = "There has been a problem";
//			log.error(message, e);
//			addActionMessage(e.getMessage());
//			return ERROR;
//
//		}
	}
	
	private List<ExcelWorksheetWrapperBean> updateWrapperBeans(
			List<SheetOptionsBean> sessionAdvanceOptionsWrapperBeans,
			List<ExcelWorksheetWrapperBean> wrapperBeans) {
		int j = 0;
		for (SheetOptionsBean optionOne : sessionAdvanceOptionsWrapperBeans) {
			ExcelWorksheetWrapperBean bean = wrapperBeans.get(j);
			transformToWrapperBean(optionOne.getAdvanceOptionsBeans(), bean);
			j++;
		}
		
		return wrapperBeans;
	}

	private void transformToWrapperBean(List<SingleFieldOptionsBean> advanceBeans,
			ExcelWorksheetWrapperBean wrapperBean) {

		List<String> types = new ArrayList<String>();
		List<String> labels = new ArrayList<String>();

		for (SingleFieldOptionsBean advanceOptionsBean : advanceBeans) {
			types.add(advanceOptionsBean.getType());
			labels.add(advanceOptionsBean.getLabel());
		}

		wrapperBean.setLabels(labels);
		wrapperBean.setTypes(types);
	}

	
//RSC 2009-05-23 No longer needed.
//	private boolean checkExternalIds(
//			List<LookupAndIdWrapper> lookupIdWrapperList2) {
//		for (LookupAndIdWrapper lookupAndIdWrapper : lookupIdWrapperList2) {
//			if (!lookupAndIdWrapper.getExternalIds().isEmpty()) {
//				return true;
//			}
//		}
//		return false;
//	}

	/*
	 * RSC 2009-05-23 This assumes that advanceBeans and updateAdvanceBeans are always in the same
	 * order.
	 * 
	 * IS THAT SAFE?
	 */
	private void mergeInformation(List<SingleFieldOptionsBean> originalSingleFieldOptionsBeans,
			List<SingleFieldOptionsBean> newSingleFieldOptionsBeans) {
		int i = 0;
		
		Set<String> externalIds = new TreeSet<String>();
		
		for (SingleFieldOptionsBean singleFieldOptions : newSingleFieldOptionsBeans) {
			originalSingleFieldOptionsBeans.get(i).setType(singleFieldOptions.getType());
			originalSingleFieldOptionsBeans.get(i).setLabel(singleFieldOptions.getLabel());
			//RSC 2009-05-23 Added.
			originalSingleFieldOptionsBeans.get(i).setExternalId(singleFieldOptions.isExternalId());
			//we should handle these here.
			if (originalSingleFieldOptionsBeans.get(i).isExternalId()) {
				externalIds.add(originalSingleFieldOptionsBeans.get(i).getName());
			}
			
			i++;
		}
	}

	private List<LookupAndIdWrapper> checkForSpecialData(
			List<SheetOptionsBean> list) {

		List<LookupAndIdWrapper> lookIpWrapper = new ArrayList<LookupAndIdWrapper>();

		for (SheetOptionsBean optionOneBean : list) {
			LookupAndIdWrapper wrap = new LookupAndIdWrapper();
			
			List<LookupBean> lookups = new ArrayList<LookupBean>();
			for (SingleFieldOptionsBean advanceOptionsBean : optionOneBean
					.getAdvanceOptionsBeans()) {

				if (Constants.LOOKUP.equals(advanceOptionsBean.getType())) {
					LookupBean look = new LookupBean();
					look.setLabel(advanceOptionsBean.getLabel());
					look.setName(advanceOptionsBean.getName());
					look.setSourceField("");
					look.setSourceObject("");
					lookups.add(look);
				}
			}
			wrap.setLookups(lookups);
			lookIpWrapper.add(wrap);
		}
		return lookIpWrapper;
	}



	public SalesforceService getSalesforceService() {
		return salesforceService;
	}

	public void setSalesforceService(SalesforceService salesforceService) {
		this.salesforceService = salesforceService;
	}

	public List<SheetOptionsBean> getAdvanceOptionsWrapperBeans() {
		return advanceOptionsWrapperBeans;
	}

	public void setAdvanceOptionsWrapperBeans(
			List<SheetOptionsBean> advanceOptionsWrapperBeans) {
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

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}


}
