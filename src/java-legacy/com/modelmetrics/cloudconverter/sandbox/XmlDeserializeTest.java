/*
The MIT License

Copyright (c) 2008, 2009 Model Metrics, Inc.

http://ModelMetrics.com
http://ModelMetrics.com/authors/rcarlberg

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
package com.modelmetrics.cloudconverter.sandbox;

import java.io.File;
import java.io.FileInputStream;

import com.modelmetrics.cloudconverter.forceutil.ProfileTabVisibilityBuilder;
import com.modelmetrics.cloudconverter.forceutil.UpdateExecutor;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.modelmetrics.common.util.TestCaseWithDevOrg;
import com.sforce.soap._2006._04.metadata.Layout;
import com.sforce.soap._2006._04.metadata.LayoutColumn;
import com.sforce.soap._2006._04.metadata.LayoutItem;
import com.sforce.soap._2006._04.metadata.LayoutSection;
import com.sforce.soap._2006._04.metadata.Profile;
import com.sforce.soap.partner.RelatedList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlDeserializeTest extends TestCaseWithDevOrg {

	public void testBasic() throws Exception {
		
		XStream xstream = new XStream(new DomDriver());
		
				
		xstream.alias("Layout", Layout.class);
		
		xstream.alias("editHeading", Boolean.class);
		
		xstream.alias("layoutSections", LayoutSection.class);
		
		xstream.alias("layoutColumns", LayoutColumn.class);
		
		xstream.alias("layoutItems", LayoutItem.class);
		
		xstream.alias("relatedLists", RelatedList.class);
		
		Layout layout = (Layout) xstream.fromXML(new FileInputStream(new File("./src/metadataXmls/Test1/layouts/Sheet1__c-Sheet1 Layout.layout")));
		
		assertNotNull(layout);
		
		
		
	}
	
	public void testTabVisibility() throws Exception {
		
		SalesforceSession salesforceSession = new SalesforceSessionFactory().build(this.salesforceCredentials);
		
		Profile profile = new ProfileTabVisibilityBuilder().build("Admin",
				"sheet1__c");
				
		new UpdateExecutor(salesforceSession
				.getMetadataService()).executeSimpleUpdate(profile);


		
	}
}
