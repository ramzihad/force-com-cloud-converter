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
