package com.modelmetrics.cloudconverter.mmimport.actions;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.json.JSONArray;
import org.json.JSONObject;

import com.modelmetrics.cloudconverter.mmimport.services.AdvanceOptionsBean;
import com.modelmetrics.cloudconverter.mmimport.services.Constants;
import com.modelmetrics.cloudconverter.mmimport.services.FileService;
import com.modelmetrics.cloudconverter.mmimport.services.ParseException;
import com.modelmetrics.cloudconverter.mmimport.services.SalesforceService;
import com.modelmetrics.cloudconverter.mmimport.services.StringUtils;
import com.modelmetrics.cloudconverter.mmimport.services.ValueId;
import com.modelmetrics.cloudconverter.mmimport.services.WrapperBean;
import com.modelmetrics.cloudconverter.util.ExternalIdBean;
import com.modelmetrics.cloudconverter.util.LookupBean;

public class UploadAction extends AbstractUploadContextAware implements
		ServletRequestAware {

	private static final Logger log = Logger.getLogger(UploadAction.class);

	private static final long serialVersionUID = 1760991341958287065L;

	private FileService fileService;

	private SalesforceService salesforceService;

	private File upload;

	private String uploadContentType;

	private String password;

	private String username;

	private Boolean override;

	private String uploadFileName;

	private List<ValueId> fieldTypes;

	private List<ValueId> uniques;

	private List<ExternalIdBean> externalIds = new ArrayList<ExternalIdBean>();

	private List<LookupBean> lookups = new ArrayList<LookupBean>();

	private List<ValueId> salesforceObjects = new ArrayList<ValueId>();

	private List<ValueId> objectFields = new ArrayList<ValueId>();

	boolean foundExternalId;

	boolean foundLookup;

	boolean externalIdUnique;

	private List<AdvanceOptionsBean> advanceOptionsBeans;

	private InputStream inputStream;

	private HttpServletRequest request;

	/**
	 * initializes form input page
	 * 
	 * @return
	 * @throws Exception
	 */
	public String init() throws Exception {

		return INPUT;
	}

	/**
	 * Uploads the XLS and transformes it to a WrapperBean object to be sent to
	 * view
	 * 
	 * @return
	 */
	public String advanceOptionsOne() {

		try {
			validateData();

			/*
			 * let's check the username and password now
			 */
			if (getActionMessages().isEmpty()) {
				try {
					this.getSalesforceSessionContext()
							.setSalesforceCredentials(this.getUsername(),
									this.getPassword());
				} catch (Exception e) {
					// this.getUploadContext().setLastException(e);
					addActionMessage("Could not initialize your Salesforce session.  You might need your security token.");
				}
			}

			/*
			 * failed?
			 */
			if (!getActionMessages().isEmpty()) {
				return INPUT;
			}

			salesforceService.setSalesforceSession(this
					.getSalesforceSessionContext().getSalesforceSession());

			WrapperBean bean = fileService.parseXLS(upload);
			this.getUploadContext().setWrapperBean(bean);
			advanceOptionsBeans = transformFromWrapperBean(bean);

			log.info("File uploaded successfully");

			fieldTypes = StringUtils.getAllFieldTypes();
			return SUCCESS;
		} catch (ParseException e) {
			message = "There has been a problem uploading the file";
			log.error(message, e);
			addActionMessage(e.getMessage());
			// this.getUploadContext().setLastException(e);
			return ERROR;

		}
	}

	/**
	 * 
	 * @return
	 */
	public String backToPageOne() {
		advanceOptionsBeans = transformFromWrapperBean(this.getUploadContext()
				.getWrapperBean());
		fieldTypes = StringUtils.getAllFieldTypes();
		return SUCCESS;
	}

	public String backToPageTwo() {
		try {
		
			WrapperBean bean = this.getUploadContext().getWrapperBean();
			advanceOptionsBeans = transformFromWrapperBean(bean);

			transformToWrapperBean(advanceOptionsBeans, bean);
			checkForSpecialData(advanceOptionsBeans, lookups, externalIds);
			foundExternalId = !externalIds.isEmpty();
			foundLookup = !lookups.isEmpty();
			salesforceObjects = salesforceService.getAllSalesforcObjects();
			uniques = StringUtils.getUniques();
			return SUCCESS;
		} catch (Exception e) {
			message = "There has been a problem loading advance options 2 page";
			log.error(message, e);
			addActionMessage(e.getMessage());
			return ERROR;
		}
	}

	/**
	 * Loads page two of advance options
	 * 
	 * @return
	 */
	public String advanceOptionsTwo() {

		try {

			this.getUploadContext().setAdvanceOptionsBeans(advanceOptionsBeans);

			WrapperBean bean = this.getUploadContext().getWrapperBean();
			transformToWrapperBean(advanceOptionsBeans, bean);
			checkForSpecialData(advanceOptionsBeans, lookups, externalIds);

			foundExternalId = !externalIds.isEmpty();
			foundLookup = !lookups.isEmpty();

			salesforceObjects = salesforceService.getAllSalesforcObjects();

			uniques = StringUtils.getUniques();

			boolean found = foundLookup | foundExternalId;

			if (found) {
				return SUCCESS;
			} else {
				transformToWrapperBean(advanceOptionsBeans, bean);
				boolean containsObject = salesforceService.checkObject(this
						.getUploadContext());
				if (containsObject) {
					request.setAttribute("backPage", "backToPageOne");
					return "override";
				} else {
					log.info("Generating Salesforce object now...");
					bean.setOverride(Boolean.FALSE);
					salesforceService.execute(this.getUploadContext());
					return "view";
				}
			}

		} catch (Exception e) {
			message = "There has been a problem loading advance options 2 page";
			log.error(message, e);
			addActionMessage(e.getMessage());
			return ERROR;

		}

	}

	public String checkOverride() {
		try {

			String[] fields = request.getParameterValues("fields");
			int i = 0;
			for (LookupBean lookupBean : lookups) {
				lookupBean.setSourceField(fields[i]);
				i++;
			}

			WrapperBean bean = this.getUploadContext().getWrapperBean();
			transformToWrapperBean(this.getUploadContext()
					.getAdvanceOptionsBeans(), bean);
			boolean containsObject = salesforceService.checkObject(this
					.getUploadContext());
			if (containsObject) {
				request.setAttribute("backPage", "backToPageTwo");
				return "override";
			} else {
				log.info("Generating Salesforce object now...");
				bean.setOverride(Boolean.FALSE);
				salesforceService.execute(this.getUploadContext());
			}
			this.getUploadContext().setWrapperBean(bean);
			return SUCCESS;
		} catch (Exception e) {
			message = "There has been a problem generating salesforce objects";
			log.error(message, e);
			addActionMessage(message);
			// this.getUploadContext().setLastException(e);
			return ERROR;
		}
	}

	public String override() {
		try {
			WrapperBean bean = this.getUploadContext().getWrapperBean();

			log.info("Generating Salesforce object now...");
			bean = this.getUploadContext().getWrapperBean();
			bean.setOverride(Boolean.TRUE);
			salesforceService.setSalesforceSession(this
					.getSalesforceSessionContext().getSalesforceSession());
			salesforceService.execute(this.getUploadContext());

			log.info("Object sent successfully");
			this.getUploadContext().setWrapperBean(bean);
			return SUCCESS;
		} catch (Exception e) {
			message = "There has been a problem generating salesforce objects";
			log.error(message, e);
			addActionMessage(message);
			// this.getUploadContext().setLastException(e);
			return ERROR;
		}
	}

	public InputStream getInputStream() throws Exception {
		return inputStream;
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

	private void checkForSpecialData(
			List<AdvanceOptionsBean> advanceOptionsBeans,
			List<LookupBean> lookups, List<ExternalIdBean> externalIds) {

		for (AdvanceOptionsBean advanceOptionsBean : advanceOptionsBeans) {
			if (Constants.EXTERNAL_ID.equals(advanceOptionsBean.getType())) {
				ExternalIdBean extId = new ExternalIdBean();
				extId.setLabel(advanceOptionsBean.getLabel());
				extId.setUnique(false);
				externalIds.add(extId);
			}
			if (Constants.LOOKUP.equals(advanceOptionsBean.getType())) {
				LookupBean look = new LookupBean();
				look.setLabel(advanceOptionsBean.getLabel());
				look.setSourceField("");
				look.setSourceObject("");
				lookups.add(look);
			}
		}

	}

	private void validateData() {
		if ("".equals(username)) {
			addActionMessage("Username is required");
		}
		if ("".equals(password)) {
			addActionMessage("Password is required");
		}
		if (upload == null) {
			addActionMessage("Please select a file");
		}

	}

	private List<AdvanceOptionsBean> transformFromWrapperBean(WrapperBean bean) {
		List<AdvanceOptionsBean> list = new ArrayList<AdvanceOptionsBean>();

		for (int i = 0; i < bean.getNames().size(); i++) {
			AdvanceOptionsBean advanceBean = new AdvanceOptionsBean();
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

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	public FileService getFileService() {
		return fileService;
	}

	public void setSalesforceService(SalesforceService salesforceService) {
		this.salesforceService = salesforceService;
	}

	public SalesforceService getSalesforceService() {
		return this.salesforceService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getOverride() {
		return override;
	}

	public void setOverride(Boolean override) {
		this.override = override;
	}

	public List<ValueId> getFieldTypes() {
		return fieldTypes;
	}

	public void setFieldTypes(List<ValueId> fieldTypes) {
		this.fieldTypes = fieldTypes;
	}

	public List<AdvanceOptionsBean> getAdvanceOptionsBeans() {
		return advanceOptionsBeans;
	}

	public void setAdvanceOptionsBeans(
			List<AdvanceOptionsBean> advanceOptionsBeans) {
		this.advanceOptionsBeans = advanceOptionsBeans;
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

	public List<ExternalIdBean> getExternalIds() {
		return externalIds;
	}

	public void setExternalIds(List<ExternalIdBean> externalIds) {
		this.externalIds = externalIds;
	}

	public List<LookupBean> getLookups() {
		return lookups;
	}

	public void setLookups(List<LookupBean> lookups) {
		this.lookups = lookups;
	}

	public List<ValueId> getSalesforceObjects() {
		return salesforceObjects;
	}

	public void setSalesforceObjects(List<ValueId> salesforceObjects) {
		this.salesforceObjects = salesforceObjects;
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

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
