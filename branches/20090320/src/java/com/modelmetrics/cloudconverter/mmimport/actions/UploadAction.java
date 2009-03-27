package com.modelmetrics.cloudconverter.mmimport.actions;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.modelmetrics.cloudconverter.mmimport.beans.WrapperBean;
import com.modelmetrics.cloudconverter.mmimport.exceptions.ParseException;
import com.modelmetrics.cloudconverter.mmimport.services.FileService;
import com.modelmetrics.cloudconverter.mmimport.services.SalesforceService;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport implements ServletRequestAware {

	private static final Logger log = Logger.getLogger(UploadAction.class);

	private static final long serialVersionUID = 1760991341958287065L;

	private HttpServletRequest request;

	private FileService fileService;

	private SalesforceService salesforceService;

	private File upload;

	private String uploadContentType;

	private String password;

	private String username;

	private Boolean override;

	private String uploadFileName;

	private WrapperBean bean;

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

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
	public String upload() {

		try {
			boolean error = false;
			if ("".equals(username)) {
				addActionMessage("Username is required");
				error = true;
			}
			if ("".equals(password)) {
				addActionMessage("Password is required");
				error = true;
			}
			if (upload == null) {
				addActionMessage("Please select a file");
				error = true;
			}
			if (error) {
				return INPUT;
			}

			bean = fileService.parseXLS(upload);
			bean.setOverride(override);

			log.info("File uploaded successfully");

			boolean containsObject = salesforceService.checkObject(bean,
					username, password);
			if (containsObject) {
				// TODO: make this action of scope:session and avoid this
				request.getSession().setAttribute("username", username);
				request.getSession().setAttribute("password", password);
				request.getSession().setAttribute("bean", bean);
				return "override";
			} else {
				log.info("Generating Salesforce object now...");
				bean.setOverride(Boolean.FALSE);
				salesforceService.execute(bean, username, password);
			}
			log.info("Object sent successfully");

			return SUCCESS;
		} catch (ParseException e) {
			message = "There has been a problem uploading the file";
			log.error(message, e);
			request.setAttribute("exception", e);
			return ERROR;

		} catch (Exception e) {
			message = "There has been a problem generating salesforce objects";
			log.error(message, e);
			request.setAttribute("exception", e);
			return ERROR;
		}
	}

	public String override() {
		try {
			log.info("Generating Salesforce object now...");
			bean = (WrapperBean) request.getSession().getAttribute(
					"bean");
			bean.setOverride(Boolean.TRUE);
			salesforceService.execute(bean, (String) request.getSession()
					.getAttribute("username"), (String) request.getSession()
					.getAttribute("password"));
			request.getSession().removeAttribute("username");
			request.getSession().removeAttribute("password");
			request.getSession().removeAttribute("bean");
			
			log.info("Object sent successfully");
			return SUCCESS;
		} catch (Exception e) {
			message = "There has been a problem generating salesforce objects";
			log.error(message, e);
			request.setAttribute("exception", e);
			return ERROR;
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

	public WrapperBean getBean() {
		return bean;
	}

	public void setBean(WrapperBean bean) {
		this.bean = bean;
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

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return request;
	}

}
