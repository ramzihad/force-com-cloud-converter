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
import com.modelmetrics.cloudconverter.mmimport.services.LookupAndIdWrapper;
import com.modelmetrics.cloudconverter.mmimport.services.OptionsOneBean;
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

	private List<ValueId> salesforceObjects = new ArrayList<ValueId>();

	private List<ValueId> objectFields = new ArrayList<ValueId>();

	boolean foundExternalId;

	boolean foundLookup;

	boolean externalIdUnique;

	private List<LookupAndIdWrapper> lookupIdWrapperList;

	private List<OptionsOneBean> advanceOptionsWrapperBeans;

	private List<String> sheets;

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

			// parse all sheets here
			List<WrapperBean> wrapperBeans = fileService.parseXLS(upload);
			this.getUploadContext().setWrapperBeans(wrapperBeans);

			// prepare information on a different structure for view
			advanceOptionsWrapperBeans = new ArrayList<OptionsOneBean>();
			for (WrapperBean wrapperBean : wrapperBeans) {
				List<AdvanceOptionsBean> advanceOptionsBeans = transformFromWrapperBean(wrapperBean);
				OptionsOneBean aux = new OptionsOneBean();
				aux.setAdvanceOptionsBeans(advanceOptionsBeans);
				advanceOptionsWrapperBeans.add(aux);
			}

			// set new structure in session
			this.getUploadContext().setAdvanceOptionsWrapperBeans(
					advanceOptionsWrapperBeans);

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

		advanceOptionsWrapperBeans = this.getUploadContext()
				.getAdvanceOptionsWrapperBeans();

		fieldTypes = StringUtils.getAllFieldTypes();
		return SUCCESS;
	}

	public String backToPageTwo() {
		try {

			List<OptionsOneBean> sessionAdvanceOptionsWrapperBeans = this
					.getUploadContext().getAdvanceOptionsWrapperBeans();

			lookupIdWrapperList = checkForSpecialData(sessionAdvanceOptionsWrapperBeans);

			foundExternalId = checkExternalIds(lookupIdWrapperList);
			foundLookup = checkLookups(lookupIdWrapperList);
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

			List<WrapperBean> wrapperBeans = this.getUploadContext()
					.getWrapperBeans();
			int j = 0;
			for (OptionsOneBean optionOne : sessionAdvanceOptionsWrapperBeans) {
				WrapperBean bean = wrapperBeans.get(j);
				transformToWrapperBean(optionOne.getAdvanceOptionsBeans(), bean);
				j++;
			}
			this.getUploadContext().setWrapperBeans(wrapperBeans);

			lookupIdWrapperList = checkForSpecialData(sessionAdvanceOptionsWrapperBeans);
			this.getUploadContext().setAuxList(lookupIdWrapperList);
			foundExternalId = checkExternalIds(lookupIdWrapperList);
			foundLookup = checkLookups(lookupIdWrapperList);

			salesforceObjects = salesforceService.getAllSalesforcObjects();

			uniques = StringUtils.getUniques();

			boolean found = foundLookup | foundExternalId;

			if (found) {
				return SUCCESS;
			} else {
				// transformToWrapperBean(advanceOptionsBeans, bean);
				sheets = salesforceService.checkObject(this.getUploadContext());
				if (!sheets.isEmpty()) {
					request.setAttribute("backPage", "backToPageOne");
					request.setAttribute("sheets", sheets);
					return "override";
				} else {
					log.info("Generating Salesforce object now...");
					// bean.setOverride(Boolean.FALSE);
					salesforceService.executeMultiple(this.getUploadContext());
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

	public String checkOverride() {
		try {

			String[] fields = request.getParameterValues("fields");
			int i = 0;
			int h = 0;
			List<LookupAndIdWrapper> auxList = this.getUploadContext()
					.getAuxList();

			for (LookupAndIdWrapper bean : lookupIdWrapperList) {
				if (bean != null && bean.getLookups() != null) {
					for (LookupBean lookupBean : bean.getLookups()) {
						lookupBean.setSourceField(fields[i]);
						lookupBean.setName(auxList.get(h).getLookups().get(i)
								.getName());
						i++;
					}
				}

				if (bean != null && bean.getExternalIds() != null) {
					int j = 0;
					
					for (ExternalIdBean extBean : bean.getExternalIds()) {
						extBean.setName(auxList.get(h).getExternalIds().get(j)
								.getName());
						j++;
					}
					
				}
				h++;
			}

			this.getUploadContext().setLookupIdWrapperList(lookupIdWrapperList);

			// get session structure information
			List<OptionsOneBean> sessionAdvanceOptionsWrapperBeans = this
					.getUploadContext().getAdvanceOptionsWrapperBeans();

			List<WrapperBean> wrapperBeans = this.getUploadContext()
					.getWrapperBeans();
			int j = 0;
			for (OptionsOneBean optionOne : sessionAdvanceOptionsWrapperBeans) {
				WrapperBean bean = wrapperBeans.get(j);
				transformToWrapperBean(optionOne.getAdvanceOptionsBeans(), bean);
				j++;
			}
			sheets = salesforceService.checkObject(this.getUploadContext());
			if (!sheets.isEmpty()) {
				request.setAttribute("backPage", "backToPageTwo");
				request.setAttribute("sheets", sheets);
				return "override";
			} else {
				log.info("Generating Salesforce object now...");
				salesforceService.executeMultiple(this.getUploadContext());
			}

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
			List<WrapperBean> beans = this.getUploadContext().getWrapperBeans();

			for (WrapperBean wrapperBean : beans) {
				wrapperBean.setOverride(Boolean.TRUE);
			}
			log.info("Generating Salesforce object now...");
			this.getUploadContext().setWrapperBeans(beans);
			salesforceService.setSalesforceSession(this
					.getSalesforceSessionContext().getSalesforceSession());
			salesforceService.executeMultiple(this.getUploadContext());

			log.info("Object sent successfully");
			this.getUploadContext().setWrapperBeans(beans);
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

	private void mergeInformation(List<AdvanceOptionsBean> advanceBeans,
			List<AdvanceOptionsBean> updatedAdvanceBeans) {
		int i = 0;
		for (AdvanceOptionsBean advanceOptionsBean : updatedAdvanceBeans) {
			advanceBeans.get(i).setType(advanceOptionsBean.getType());
			advanceBeans.get(i).setLabel(advanceOptionsBean.getLabel());
			i++;
		}
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

	public List<ValueId> getFieldTypes() {
		return fieldTypes;
	}

	public void setFieldTypes(List<ValueId> fieldTypes) {
		this.fieldTypes = fieldTypes;
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

	public Boolean getOverride() {
		return override;
	}

	public void setOverride(Boolean override) {
		this.override = override;
	}

}
