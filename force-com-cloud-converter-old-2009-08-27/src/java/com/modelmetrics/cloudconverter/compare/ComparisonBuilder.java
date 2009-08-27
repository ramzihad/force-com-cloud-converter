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
package com.modelmetrics.cloudconverter.compare;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class ComparisonBuilder {

	public void execute(ComparisonGroup comparisonGroup) throws Exception {

		// Get the results
		ComparisonResults comparisonResults = new ComparisonResults();

		// build a single set of all the object names
		Set<String> allUniqueObjectName = new TreeSet<String>();

		// loop through all the sessions, get all the names, add them all to the
		// set
		for (ComparisonSession currentSession : comparisonGroup
				.getComparisonSessions()) {
			new ComparisonSessionObjectInfoDecorator().execute(currentSession);
			allUniqueObjectName.addAll(currentSession.getInterestingTypes());
		}

		// cycle through those to build results -- object level
		for (String uniqueType : allUniqueObjectName) {

			comparisonResults.getObjectResultsTypeMap().put(uniqueType,
					new ArrayList<ObjectLevelResults>());

			for (ComparisonSession currentSession : comparisonGroup
					.getComparisonSessions()) {
				ObjectLevelResults objectLevelResults = new ObjectLevelResults();
				objectLevelResults.setComparisonSession(currentSession);
				// present?
				if (currentSession.getSobjectMap().containsKey(uniqueType)) {
					objectLevelResults.setDescribeSObjectResult(currentSession.getSobjectMap().get(uniqueType));
				}

				comparisonResults.getObjectResultsTypeMap().get(uniqueType)
						.add(objectLevelResults);
			}
		}

		// cycle through those to build results -- object field level
		for (String uniqueType : allUniqueObjectName) {

			for (ComparisonSession currentSession : comparisonGroup
					.getComparisonSessions()) {
				comparisonResults.getObjectFieldResultsTypeMap().put(
						uniqueType, new ArrayList<ObjectFieldLevelResults>());

				
				
				
			}

		}
	}
}
