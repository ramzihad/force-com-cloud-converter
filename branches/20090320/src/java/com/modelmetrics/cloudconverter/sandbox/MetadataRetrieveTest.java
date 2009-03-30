package com.modelmetrics.cloudconverter.sandbox;

import java.io.File;
import java.io.FileOutputStream;

import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.modelmetrics.common.util.TestCaseWithDevOrg;
import com.sforce.soap._2006._04.metadata.PackageTypeMembers;
import com.sforce.soap._2006._04.metadata.RetrieveRequest;
import com.sforce.soap._2006._04.metadata.RetrieveResult;
import com.sforce.soap._2006._04.metadata._package;

public class MetadataRetrieveTest extends TestCaseWithDevOrg {

	public void testRetrieve() throws Exception {
		
		SalesforceSession salesforceSession = new SalesforceSessionFactory().build(this.salesforceCredentials);
		
		 PackageTypeMembers packageTypeMembers = new PackageTypeMembers();
		 packageTypeMembers.setMembers(new String[] { "Admin" });
		 packageTypeMembers.setName("Profile");
		
		 _package p = new _package();

		 p.setTypes(new PackageTypeMembers[] { packageTypeMembers });
		 p.setVersion("15.0");
		
		 RetrieveRequest retrieveRequest = new RetrieveRequest();
		 retrieveRequest.setSinglePackage(true);
		 retrieveRequest.setUnpackaged(p);
		 retrieveRequest.setApiVersion(15.0);
		
		 RetrieveExecutor executor = new RetrieveExecutor();
		 
		
		 RetrieveResult result = executor.execute(salesforceSession, retrieveRequest);
		
		 log.info(result.getId());
		
		 log.info("is zip file null? " + (result.getZipFile() == null));
		
		 FileOutputStream fos = new FileOutputStream(new File("Profile-Admin.zip"));
		 fos.write(result.getZipFile());
				fos.flush();
				fos.close();

	}
}
