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

package com.modelmetrics.cloudconverter.forceutil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sforce.soap._2006._04.metadata.AsyncRequestState;
import com.sforce.soap._2006._04.metadata.AsyncResult;
import com.sforce.soap._2006._04.metadata.Metadata;
import com.sforce.soap._2006._04.metadata.MetadataBindingStub;

public class CreateExecutor {

	private static final Log log = LogFactory.getLog(CreateExecutor.class);

	private static final int ONE_SECOND = 2000;

	MetadataBindingStub metadatabinding;

	Metadata[] metadata;

	public CreateExecutor(MetadataBindingStub metadataBindingStub,
			Metadata[] metadatas) {
		this.metadatabinding = metadataBindingStub;
		this.metadata = metadatas;
	}

	public void execute() throws Exception {
		log.debug("Executing create for ... " + metadata[0].getFullName());
		int metadataIndex = -1;
		int metadataChunkIndex = -1;

		Metadata[] metadataChunk = null;

		if (metadata.length > 10) {
			while (metadataIndex < metadata.length) {
				metadataChunk = new Metadata[10];
				metadataChunkIndex = -1;

				while (true) {
					metadataIndex++;
					metadataChunkIndex++;

					if (metadataIndex < metadata.length)
						metadataChunk[metadataChunkIndex] = metadata[metadataIndex];

					if (metadataChunkIndex == 9
							|| metadataIndex == metadata.length - 1) {
						break;
					}
				}

				if (metadataChunk.length > 0 && metadataChunk[0] != null) {
					System.out.println("metadataChunk.length"
							+ metadataChunk.length);
					this.handleExecute(metadataChunk);
				}
			}
		} else {
			this.handleExecute(this.metadata);
		}
	}

	private void handleExecute(Metadata[] metadataChunk) {

		// log.debug("the type of Metadata is " +
		// metadataChunk[0].getClass().getName());
		// System.out.println("the type of Metadata is " +
		// metadataChunk[0].getFullName());

		AsyncResult[] ars = null;
		try {
			ars = metadatabinding.create(metadataChunk);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Couldn't execute metadata binding create. (" + e.getLocalizedMessage() + ")", e);
		}
		if (ars == null) {
			log.debug("The object was not created successfully");
			return;
		}

		String createdObjectId = ars[0].getId();
		String[] ids = new String[] { createdObjectId };
		boolean done = false;
		long waitTimeMilliSecs = ONE_SECOND;
		AsyncResult[] arsStatus = null;

		/**
		 * After the create() call completes, we must poll the results of the
		 * checkStatus() call until it indicates that the create operation is
		 * completed.
		 */
		while (!done) {
			try {
				arsStatus = metadatabinding.checkStatus(ids);
			} catch (Exception e) {
				throw new RuntimeException(
						"Couldn't execute metadata binding check status.", e);
			}
			if (arsStatus == null) {
				System.out.println("The object status cannot be retrieved");
				return;
			}
			done = arsStatus[0].isDone();
			if (arsStatus[0].getStatusCode() != null) {
				// RunUISWTInterface.setLabelAndBar(arsStatus[0].getStatusCode().toString(),
				// 0);
				log.debug("Error status code: " + arsStatus[0].getStatusCode());
				log.debug("Error message: " + arsStatus[0].getMessage());
				throw new RuntimeException("Failed to execute create! " + arsStatus[0].getMessage());
			}
			try {
				Thread.sleep(waitTimeMilliSecs);
			} catch (Exception e) {
				throw new RuntimeException("Thread sleep failed", e);
			}
			// double the wait time for the next iteration
			waitTimeMilliSecs *= 2;
			log.debug("The object state is " + arsStatus[0].getState());

			StringBuffer errors = new StringBuffer();
			log.debug("arsStatus Length is " + arsStatus.length);
			for (int i = 0; i < arsStatus.length; i++) {
				log.debug("arsStatus element: " + i + ", done? "
						+ arsStatus[i].isDone());
				if (arsStatus[i].getState() == AsyncRequestState.Error) {
					errors
							.append("AsyncRequestState is 'Error' - Create not completed. Message is ["
									+ arsStatus[0].getMessage()
									+ "] (backets added)");
				}
			}

			if (errors.length() > 0) {
				throw new RuntimeException(errors.toString());
			}
		}

		log.debug("The ID for the created object is " + arsStatus[0].getId());

	}
}
