package com.modelmetrics.cloudconverter.mmimport.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.modelmetrics.cloudconverter.mmimport.services.SingleFieldOptionsBean;
import com.modelmetrics.cloudconverter.mmimport.services.SheetOptionsBean;
import com.modelmetrics.cloudconverter.mmimport.services.SalesforceService;
import com.modelmetrics.cloudconverter.mmimport.services.StringUtils;
import com.modelmetrics.cloudconverter.mmimport.services.ValueId;
import com.modelmetrics.cloudconverter.mmimport.services.WrapperBean;

public class UploadActionCompositeBranch extends AbstractUploadContextAware {

	private static final long serialVersionUID = -3145368694251083353L;

	private static final String SUBMIT_STANDARD = "Standard Import";

	private static final String SUBMIT_ADVANCED = "Show Advanced Options";
	
	private static final String CONFIG_INPUT = "input";

	private static final Logger log = Logger
			.getLogger(UploadActionCompositeBranch.class);

	private SalesforceService salesforceService;

	private Long selectedOption;

	private Map<Long, String> optionsList;

	private List<SheetOptionsBean> advanceOptionsWrapperBeans;

	private List<String> sheets;

	private List<ValueId> fieldTypes;

	private String submit;


	public String execute() throws Exception {
		
		//if someone comes "back" submit will be null and we need to get them to input.
		if (this.getSubmit() == null) {
			return CONFIG_INPUT;
		}
		
		try {
			salesforceService.setSalesforceSession(this
					.getSalesforceSessionContext().getSalesforceSession());

			if (this.getSubmit().equalsIgnoreCase(SUBMIT_STANDARD)) {
				sheets = salesforceService.checkObject(this.getUploadContext());
				if (!sheets.isEmpty()) {
					// request.setAttribute("backPage", "backToBranch");
					// request.setAttribute("sheets", sheets);
					return "override";
				} else {
					return "view";
				}
			} else {
				List<WrapperBean> beans = this.getUploadContext()
						.getWrapperBeans();

				// prepare information on a different structure for view
				advanceOptionsWrapperBeans = new ArrayList<SheetOptionsBean>();
				for (WrapperBean wrapperBean : beans) {
					List<SingleFieldOptionsBean> advanceOptionsBeans = transformFromWrapperBean(wrapperBean);
					SheetOptionsBean aux = new SheetOptionsBean();
					aux.setSheetName(wrapperBean.getSheetName());
					aux.setAdvanceOptionsBeans(advanceOptionsBeans);
					advanceOptionsWrapperBeans.add(aux);
				}

				// set new structure in session
				this.getUploadContext().setAdvanceOptionsWrapperBeans(
						advanceOptionsWrapperBeans);

				log.info("Advance options page 1 prepared successfully");

				fieldTypes = StringUtils.getAllFieldTypes();
				return "advanceOptionsOne";
			}

		} catch (Exception e) {
			message = "There has been a problem";
			log.error(message, e);
			addActionMessage(e.getMessage());
			return ERROR;
		}

	}

	private List<SingleFieldOptionsBean> transformFromWrapperBean(WrapperBean bean) {
		List<SingleFieldOptionsBean> list = new ArrayList<SingleFieldOptionsBean>();

		for (int i = 0; i < bean.getNames().size(); i++) {
			SingleFieldOptionsBean advanceBean = new SingleFieldOptionsBean();
			advanceBean.setName(bean.getNames().get(i));
			advanceBean.setLabel(bean.getLabels().get(i));
			advanceBean.setType(bean.getTypes().get(i));
			List<Object> data = new ArrayList<Object>();
			for (List<Object> aux : bean.getObjects()) {
				data.add(aux.get(i));
			}
			advanceBean.setData(data);
			list.add(advanceBean);
		}
		return list;
	}

	public Long getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(Long selectedOption) {
		this.selectedOption = selectedOption;
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

	public List<String> getSheets() {
		return sheets;
	}

	public void setSheets(List<String> sheets) {
		this.sheets = sheets;
	}

	public List<ValueId> getFieldTypes() {
		return fieldTypes;
	}

	public void setFieldTypes(List<ValueId> fieldTypes) {
		this.fieldTypes = fieldTypes;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

}
