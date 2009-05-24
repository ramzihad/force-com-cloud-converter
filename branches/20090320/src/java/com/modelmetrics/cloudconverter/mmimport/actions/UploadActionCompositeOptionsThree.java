package com.modelmetrics.cloudconverter.mmimport.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.json.JSONArray;
import org.json.JSONObject;

import com.modelmetrics.cloudconverter.mmimport.services.LookupAndIdWrapper;
import com.modelmetrics.cloudconverter.mmimport.services.SalesforceService;
import com.modelmetrics.cloudconverter.mmimport.services.StringUtils;
import com.modelmetrics.cloudconverter.mmimport.services.ValueId;
import com.modelmetrics.cloudconverter.util.LookupBean;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

public class UploadActionCompositeOptionsThree extends
		AbstractUploadContextAware  {

	private static final long serialVersionUID = -2803796981361837197L;

	private static final String SUBMIT_BACK = "Back";
	
	private static final String SUBMIT_NEXT = "Next";
	
	private static final Logger log = Logger
			.getLogger(UploadActionCompositeOptionsOne.class);

	private SalesforceService salesforceService;



	private InputStream inputStream;

	private Map<Long, String> optionsList;

	private List<LookupAndIdWrapper> lookupIdWrapperList;
	
	private String submit;
	
	private String[] fields;
	
	private String id;
	
	private List<ValueId> salesforceObjects = new ArrayList<ValueId>();



	public String execute() throws Exception {

		return null;
//		if (this.getSubmit() == null) {
//			lookupIdWrapperList = this.getUploadContext().getAuxList();
//			salesforceObjects = salesforceService
//			.getAllSalesforcObjects();
//			return Action.INPUT;
//		}
//		
//		if ((this.getFields() == null || this.getFields().length == 0) && this.getSubmit().equalsIgnoreCase(SUBMIT_BACK)) {
//			return "back";
//		}
//		
//		if (this.getSubmit().equalsIgnoreCase(SUBMIT_NEXT) && (this.getFields() == null || this.getFields().length == 0) ) {
//			this.addActionMessage("You must select a Lookup Object and Field.");
//			return Action.INPUT;
//		}
//		try {
//			
//			int i = 0;
//
//			List<LookupAndIdWrapper> auxList = this.getUploadContext()
//					.getAuxList();
//			int h = 0;
//			for (LookupAndIdWrapper bean : auxList) {
//				if (bean != null && bean.getLookups() != null) {
//					int j = 0;
//					for (LookupBean lookupBean : bean.getLookups()) {
//						lookupBean.setSourceField(fields[j]);
//						lookupBean.setLabel(lookupIdWrapperList.get(h)
//								.getLookups().get(j).getLabel());
//						lookupBean.setName(lookupIdWrapperList.get(h)
//								.getLookups().get(j).getName());
//						lookupBean.setSourceObject(lookupIdWrapperList.get(h)
//								.getLookups().get(j).getSourceObject());
//						i++;
//						j++;
//					}
//				}
//				h++;
//			}
//
//			this.getUploadContext().setLookupIdWrapperList(auxList);
//
//			// go to confirm page
//			optionsList = StringUtils.getOptions();
//			
//			if (this.getSubmit().equals(SUBMIT_BACK)) {
//				return "back";
//			} else {
//				return "confirm";
//			}
//
//		} catch (Exception e) {
//			message = "There has been a problem";
//			log.error(message, e);
//			addActionMessage(e.getMessage());
//			return ERROR;
//		}
	}

	/**
	 * get fields for object
	 * 
	 * @return
	 */
	public String loadObjectFields() {
//		try {
//			String objectId = this.getId();
//			List<ValueId> values = salesforceService
//					.getFieldsForObject(objectId);
//
//			JSONArray jsonArray = new JSONArray();
//			for (ValueId value : values) {
//				JSONObject jsonObj = new JSONObject();
//				jsonObj.put("id", value.getId());
//				jsonObj.put("value", value.getValue());
//				jsonArray.put(jsonObj);
//			}
//
//			inputStream = new ByteArrayInputStream(jsonArray.toString()
//					.getBytes());
//		} catch (Exception e) {
//			inputStream = new ByteArrayInputStream("".getBytes());
//		}
		return SUCCESS;
	}

	public SalesforceService getSalesforceService() {
		return salesforceService;
	}

	public void setSalesforceService(SalesforceService salesforceService) {
		this.salesforceService = salesforceService;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public Map<Long, String> getOptionsList() {
		return optionsList;
	}

	public void setOptionsList(Map<Long, String> optionsList) {
		this.optionsList = optionsList;
	}

	public List<LookupAndIdWrapper> getLookupIdWrapperList() {
		return lookupIdWrapperList;
	}

	public void setLookupIdWrapperList(
			List<LookupAndIdWrapper> lookupIdWrapperList) {
		this.lookupIdWrapperList = lookupIdWrapperList;
	}


	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String[] getFields() {
		return fields;
	}

	public void setFields(String[] fields) {
		this.fields = fields;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ValueId> getSalesforceObjects() {
		return salesforceObjects;
	}

	public void setSalesforceObjects(List<ValueId> salesforceObjects) {
		this.salesforceObjects = salesforceObjects;
	}
}
