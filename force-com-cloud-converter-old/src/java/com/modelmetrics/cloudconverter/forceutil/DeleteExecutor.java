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

import com.sforce.soap._2006._04.metadata.AsyncResult;
import com.sforce.soap._2006._04.metadata.Metadata;
import com.sforce.soap._2006._04.metadata.MetadataBindingStub;

public class DeleteExecutor {

	private static final Log log = LogFactory.getLog(DeleteExecutor.class);

	private static final int ONE_SECOND = 2000;

	MetadataBindingStub metadatabinding;

	Metadata[] metadata;

	public DeleteExecutor(MetadataBindingStub metadataBindingStub) {
		this.metadatabinding = metadataBindingStub;
	}

	public DeleteExecutor(MetadataBindingStub metadataBindingStub,
			Metadata[] metadatas) {
		this(metadataBindingStub);
		this.metadata = metadatas;
	}

	public void executeSimpleDelete(Metadata target) throws Exception {

		this.metadata = new Metadata[] { target };

		this.handleExecute(metadata);

	}

//	public void execute() throws Exception {
//
//		log.debug("Executing delete for ... " + metadata[0].getMetadata().getFullName()); 
//				
//		if (this.metadata == null) {
//			throw new RuntimeException("no metadata to work with");
//		}
//
//		int metadataIndex = -1;
//		int metadataChunkIndex = -1;
//
//		UpdateMetadata[] metadataChunk = null;
//
//		if (metadata.length > 10) {
//			while (metadataIndex < metadata.length) {
//				metadataChunk = new UpdateMetadata[10];
//				metadataChunkIndex = -1;
//
//				while (true) {
//					metadataIndex++;
//					metadataChunkIndex++;
//
//					if (metadataIndex < metadata.length)
//						metadataChunk[metadataChunkIndex] = metadata[metadataIndex];
//
//					if (metadataChunkIndex == 9
//							|| metadataIndex == metadata.length - 1) {
//						break;
//					}
//				}
//
//				if (metadataChunk.length > 0 && metadataChunk[0] != null) {
//					System.out.println("metadataChunk.length"
//							+ metadataChunk.length);
//					this.handleExecute(metadataChunk);
//				}
//			}
//		} else {
//			this.handleExecute(this.metadata);
//		}
//	}

	private void handleExecute(Metadata[] metadataChunk) {

		// log.debug("the type of Metadata is " +
		// metadataChunk[0].getClass().getName());
		// System.out.println("the type of Metadata is " +
		// metadataChunk[0].getFullName());

		try {
			AsyncResult[] ars = metadatabinding.delete(metadataChunk);
			if (ars == null) {
				log.debug("The object was not deleted successfully");
				return;
			}

			String createdObjectId = ars[0].getId();
			String[] ids = new String[] { createdObjectId };
			boolean done = false;
			long waitTimeMilliSecs = ONE_SECOND;
			AsyncResult[] arsStatus = null;

			/**
			 * After the create() call completes, we must poll the results of
			 * the checkStatus() call until it indicates that the create
			 * operation is completed.
			 */
			while (!done) {
				arsStatus = metadatabinding.checkStatus(ids);
				if (arsStatus == null) {
					System.out.println("The object status cannot be retrieved");
					return;
				}
				done = arsStatus[0].isDone();
				if (arsStatus[0].getStatusCode() != null) {
					log.debug("Error status code: "
							+ arsStatus[0].getStatusCode());
					log.debug("Error message: " + arsStatus[0].getMessage());
				}
				Thread.sleep(waitTimeMilliSecs);
				// double the wait time for the next iteration
				waitTimeMilliSecs *= 2;
				log.debug("The object state is " + arsStatus[0].getState());
				log.debug("The message is " + arsStatus[0].getMessage());
			}

			log.debug("The ID for the deleted object is "
					+ arsStatus[0].getId());

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("failed! ");

		}

	}
}
