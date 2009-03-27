package com.modelmetrics.cloudconverter.mmimport.services;

import com.modelmetrics.cloudconverter.mmimport.beans.WrapperBean;

public interface SalesforceService {

	void execute(WrapperBean bean, String username, String password)
			throws Exception;

	boolean checkObject(WrapperBean bean, String username, String password)
			throws Exception;

}
