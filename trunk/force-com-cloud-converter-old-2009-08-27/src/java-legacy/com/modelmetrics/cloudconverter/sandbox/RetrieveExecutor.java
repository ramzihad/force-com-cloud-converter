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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.common.sforce.SalesforceSession;
import com.sforce.soap._2006._04.metadata.AsyncResult;
import com.sforce.soap._2006._04.metadata.RetrieveRequest;
import com.sforce.soap._2006._04.metadata.RetrieveResult;

public class RetrieveExecutor  {

	private static final Log log = LogFactory.getLog(RetrieveExecutor.class);
	
	private static final long ONE_SECOND = 1000;

	public RetrieveResult execute(SalesforceSession salesforceSession, RetrieveRequest request) {

		log.debug("entering retrieve request " + request.getApiVersion());
		
		RetrieveResult result = null;
		
		try {
			AsyncResult ars = salesforceSession.getMetadataService().retrieve(request);
			if (ars == null) {
				log.debug("The object was not created successfully");
				throw new RuntimeException("AsyncResult failed without any information");
			}

			String createdObjectId = ars.getId();
			String[] ids = new String[] { createdObjectId };
			boolean done = false;
			long waitTimeMilliSecs = ONE_SECOND;
			

			/**
			 * After the create() call completes, we must poll the results of
			 * the checkStatus() call until it indicates that the create
			 * operation is completed.
			 */
			while (!done) {
				ars = salesforceSession.getMetadataService().checkStatus(new String[] {ars.getId()})[0];
				if (ars == null) {
					System.out.println("The object status cannot be retrieved");
					throw new RuntimeException("Could not retrieve AsyncResult status");
				}
				done = ars.isDone();
				if (ars.getStatusCode() != null) {
					log.debug("Error status code: "
							+ ars.getStatusCode());
					log.debug("Error message: "
							+ ars.getMessage());
					throw new RuntimeException("Failed in retried wait loop");
				}
				Thread.sleep(waitTimeMilliSecs);
				// double the wait time for the next iteration
				waitTimeMilliSecs *= 2;
				log.debug("The object state is "
						+ ars.getState());
			}
			
			result = salesforceSession.getMetadataService().checkRetrieveStatus(ars.getId());

		} catch (Exception e) {
			throw new RuntimeException("failed! ", e);
		}

		return result;
	}
	
	
}
