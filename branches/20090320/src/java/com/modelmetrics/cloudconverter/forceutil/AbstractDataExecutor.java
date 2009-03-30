package com.modelmetrics.cloudconverter.forceutil;

import com.modelmetrics.common.sforce.dao.SalesforceDAO;
import com.modelmetrics.common.sforce.dao.SproxyBuilder;

public abstract class AbstractDataExecutor implements DataExecutor {

	//the Salesforce DAO chunks into SFDC appropriate sizes.  This batch is used to ensure we don't run out of memory.
	protected static final int MAX_SPROXY_BATCH_SIZE = 200;
	
	//converts data to key value pairs
	protected final SproxyBuilder sproxyBuilder = new SproxyBuilder();
	
	//in charge of interacting with salesforce
	protected final SalesforceDAO dao = new SalesforceDAO();
	
}
