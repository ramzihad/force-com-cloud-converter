package com.modelmetrics.cloudconverter.sandbox;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.cloudconverter.util.AbstractMigrationContextAware;
import com.sforce.soap._2006._04.metadata.AsyncResult;
import com.sforce.soap._2006._04.metadata.Metadata;
import com.sforce.soap._2006._04.metadata.RetrieveRequest;
import com.sforce.soap._2006._04.metadata.RetrieveResult;

public class RetrieveExecutor extends AbstractMigrationContextAware {

	private static final Log log = LogFactory.getLog(RetrieveExecutor.class);
	
	private static final long ONE_SECOND = 1000;

	public RetrieveResult execute(RetrieveRequest request) {

		log.debug("entering retrieve request " + request.getApiVersion());
		
		RetrieveResult result = null;
		
		try {
			AsyncResult ars = this.getMigrationContext().getSalesforceSession().getMetadataService().retrieve(request);
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
				ars = this.getMigrationContext().getSalesforceSession().getMetadataService().checkStatus(new String[] {ars.getId()})[0];
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
			
			result = this.getMigrationContext().getSalesforceSession().getMetadataService().checkRetrieveStatus(ars.getId());

		} catch (Exception e) {
			throw new RuntimeException("failed! ", e);
		}

		return result;
	}
}
