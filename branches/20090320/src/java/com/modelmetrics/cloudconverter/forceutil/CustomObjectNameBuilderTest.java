package com.modelmetrics.cloudconverter.forceutil;

import junit.framework.TestCase;

public class CustomObjectNameBuilderTest extends TestCase {

	public void testBasic() throws Exception {

		String ret = new CustomObjectNameBuilder()
				.buildCustomObjectName("reid carlberg");

		assertEquals("reidcarlberg__c", ret);

		ret = new CustomObjectNameBuilder()
				.buildCustomObjectName("&*^%$# new name __c");

		assertEquals("newname_c__c", ret);
	}
}
