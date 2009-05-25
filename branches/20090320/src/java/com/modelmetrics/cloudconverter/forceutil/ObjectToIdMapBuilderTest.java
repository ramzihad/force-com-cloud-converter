package com.modelmetrics.cloudconverter.forceutil;

import java.util.List;
import java.util.Map;

import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.modelmetrics.common.util.TestCaseWithDevOrg;

public class ObjectToIdMapBuilderTest extends TestCaseWithDevOrg {

	public void testBasic() throws Exception {
		
		SalesforceSession salesforceSession = new SalesforceSessionFactory().build(this.salesforceCredentials);
		
		ObjectToIdMapBuilder builder = new ObjectToIdMapBuilder();
		
		Map<String, List<String>> map = builder.getMap(salesforceSession);
		
		assertNotNull(map);
		
		for (String currentKey : map.keySet()) {
			log.info("current key is : " + currentKey);
			assertTrue(map.get(currentKey).size() > 0);
		}
		
	}
}
