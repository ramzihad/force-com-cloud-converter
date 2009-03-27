package com.mmimport.services;

import com.mmimport.beans.WrapperBean;

public interface SalesforceService {

	void execute(WrapperBean bean, String username, String password) throws Exception;
	
}
