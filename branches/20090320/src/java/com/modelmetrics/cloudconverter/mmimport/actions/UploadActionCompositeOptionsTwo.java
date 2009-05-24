package com.modelmetrics.cloudconverter.mmimport.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.modelmetrics.cloudconverter.mmimport.services.LookupAndIdWrapper;
import com.modelmetrics.cloudconverter.mmimport.services.SheetOptionsBean;
import com.modelmetrics.cloudconverter.mmimport.services.SalesforceService;
import com.modelmetrics.cloudconverter.mmimport.services.StringUtils;
import com.modelmetrics.cloudconverter.mmimport.services.ValueId;
import com.modelmetrics.cloudconverter.util.ExternalIdBean;
import com.opensymphony.xwork2.Preparable;

public class UploadActionCompositeOptionsTwo extends AbstractUploadContextAware
		implements ServletRequestAware {

	private static final long serialVersionUID = -7006948648233904859L;

	private static final Logger log = Logger
			.getLogger(UploadActionCompositeExecute.class);

	private HttpServletRequest request;

	private SalesforceService salesforceService;

	private List<SheetOptionsBean> advanceOptionsWrapperBeans;

	private List<ValueId> salesforceObjects = new ArrayList<ValueId>();

	private List<LookupAndIdWrapper> lookupIdWrapperList;

	private List<ValueId> uniques;

	private Map<Long, String> optionsList;

	/*
	 * RSC 2000-05-23 should be out of date at this point.
	 */
	public String execute() throws Exception {

		try {
			List<LookupAndIdWrapper> auxList = this.getUploadContext()
					.getAuxList();

			updateList(auxList, lookupIdWrapperList);
			lookupIdWrapperList = auxList;
			this.getUploadContext().setLookupIdWrapperList(auxList);
			boolean foundLookup = checkLookups(auxList);
			if (foundLookup) {
				// go to advance options 3
				salesforceObjects = salesforceService.getAllSalesforcObjects();
				return "advanceOptionsThree";
			} else {
				// go to confirm page
				optionsList = StringUtils.getOptions();
				return "confirm";
			}

		} catch (Exception e) {
			message = "There has been a problem";
			log.error(message, e);
			addActionMessage(e.getMessage());
			return ERROR;
		}
	}

	private void updateList(List<LookupAndIdWrapper> auxList,
			List<LookupAndIdWrapper> lookupIdWrapperList2) {
//		int h = 0;
//		for (LookupAndIdWrapper bean : auxList) {
//			if (bean != null && bean.getExternalIds() != null) {
//				int j = 0;
//
//				for (ExternalIdBean extBean : bean.getExternalIds()) {
//					extBean.setUnique(lookupIdWrapperList.get(h)
//							.getExternalIds().get(j).isUnique());
//					j++;
//				}
//			}
//
//			h++;
//		}
//		this.getUploadContext().setLookupIdWrapperList(auxList);
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public List<LookupAndIdWrapper> getLookupIdWrapperList() {
		return lookupIdWrapperList;
	}

	public void setLookupIdWrapperList(
			List<LookupAndIdWrapper> lookupIdWrapperList) {
		this.lookupIdWrapperList = lookupIdWrapperList;
	}

	public List<ValueId> getUniques() {
		return uniques;
	}

	public void setUniques(List<ValueId> uniques) {
		this.uniques = uniques;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Map<Long, String> getOptionsList() {
		return optionsList;
	}

	public void setOptionsList(Map<Long, String> optionsList) {
		this.optionsList = optionsList;
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

	public List<ValueId> getSalesforceObjects() {
		return salesforceObjects;
	}

	public void setSalesforceObjects(List<ValueId> salesforceObjects) {
		this.salesforceObjects = salesforceObjects;
	}

}
