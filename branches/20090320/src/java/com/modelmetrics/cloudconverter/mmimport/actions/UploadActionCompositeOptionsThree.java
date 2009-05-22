package com.modelmetrics.cloudconverter.mmimport.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
import com.opensymphony.xwork2.Preparable;

public class UploadActionCompositeOptionsThree extends
		AbstractUploadContextAware implements ServletRequestAware, Preparable  {

	private static final long serialVersionUID = -2803796981361837197L;

	private static final Logger log = Logger
			.getLogger(UploadActionCompositeOptionsOne.class);

	private SalesforceService salesforceService;

	private HttpServletRequest request;

	private InputStream inputStream;

	private Map<Long, String> optionsList;

	private List<LookupAndIdWrapper> lookupIdWrapperList;

	public void prepare() throws Exception {
		lookupIdWrapperList = this.getUploadContext().getLookupIdWrapperList();
		
	}
	
	public String execute() throws Exception {

		try {
			String[] fields = request.getParameterValues("fields");
			int i = 0;
		
			List<LookupAndIdWrapper> auxList = this.getUploadContext()
					.getAuxList();

			for (LookupAndIdWrapper bean : auxList) {
				if (bean != null && bean.getLookups() != null) {
					for (LookupBean lookupBean : bean.getLookups()) {
						lookupBean.setSourceField(fields[i]);
						
						i++;
					}
				}	
			}

			this.getUploadContext().setLookupIdWrapperList(auxList);

			// go to confirm page
			optionsList = StringUtils.getOptions();
			return "confirm";

		} catch (Exception e) {
			message = "There has been a problem";
			log.error(message, e);
			addActionMessage(e.getMessage());
			return ERROR;
		}
	}

	/**
	 * get fields for object
	 * 
	 * @return
	 */
	public String loadObjectFields() {
		try {
			String objectId = request.getParameter("id");
			List<ValueId> values = salesforceService
					.getFieldsForObject(objectId);

			JSONArray jsonArray = new JSONArray();
			for (ValueId value : values) {
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("id", value.getId());
				jsonObj.put("value", value.getValue());
				jsonArray.put(jsonObj);
			}

			inputStream = new ByteArrayInputStream(jsonArray.toString()
					.getBytes());
		} catch (Exception e) {
			inputStream = new ByteArrayInputStream("".getBytes());
		}
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

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
