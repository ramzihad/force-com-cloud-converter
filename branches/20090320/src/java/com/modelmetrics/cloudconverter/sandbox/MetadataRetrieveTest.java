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
