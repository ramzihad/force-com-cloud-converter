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
package com.modelmetrics.utility.describe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.modelmetrics.common.sforce.SalesforceSession;
import com.sforce.soap.partner.DescribeLayout;
import com.sforce.soap.partner.DescribeLayoutComponent;
import com.sforce.soap.partner.DescribeLayoutItem;
import com.sforce.soap.partner.DescribeLayoutResult;
import com.sforce.soap.partner.DescribeLayoutRow;
import com.sforce.soap.partner.DescribeLayoutSection;
import com.sforce.soap.partner.DescribeSObjectResult;
import com.sforce.soap.partner.Field;
import com.sforce.soap.partner.RecordTypeMapping;

public class LayoutsBuilder {

	private DescribeSObjectResult results;
	
	private Collection<LayoutsFieldVO> rows;
	
	private Collection<String> recordTypes;
	
	private Collection<String> layoutIds;
	
	public void execute(SalesforceSession salesforceSession, String type) throws Exception {
		
		this.setResults(salesforceSession.getSalesforceService().describeSObject(type));
				
		// query
		DescribeLayoutResult describeLayoutResult = salesforceSession.getSalesforceService()
				.describeLayout(type, null);

		// setup containers
		RecordTypeMapping[] recordTypeMapping = describeLayoutResult
				.getRecordTypeMappings();

		Map<String, String> recordTypesToLayouts = new HashMap<String, String>();

		Map<String, Set<String>> layoutIdsToFieldSets = new HashMap<String, Set<String>>();

		for (int i = 0; i < recordTypeMapping.length; i++) {
			RecordTypeMapping current = recordTypeMapping[i];
			recordTypesToLayouts.put(current.getName(), current
					.getLayoutId());
			if (!layoutIdsToFieldSets.containsKey(current.getLayoutId())) {
				layoutIdsToFieldSets.put(current.getLayoutId(),
						new TreeSet<String>());
			}
		}

		// get the fields in each layout
		for (int i = 0; i < describeLayoutResult.getLayouts().length; i++) {
			DescribeLayout describeLayout = describeLayoutResult
					.getLayouts(i);

			Set<String> fields = layoutIdsToFieldSets.get(describeLayout
					.getId());

			for (int j = 0; j < describeLayout.getDetailLayoutSections().length; j++) {
				DescribeLayoutSection describeLayoutSection = describeLayout
						.getDetailLayoutSections(j);
				for (int k = 0; k < describeLayoutSection.getLayoutRows().length; k++) {
					DescribeLayoutRow describeLayoutRow = describeLayoutSection
							.getLayoutRows(k);
					for (int m = 0; m < describeLayoutRow.getLayoutItems().length; m++) {
						DescribeLayoutItem item = describeLayoutRow
								.getLayoutItems(m);
						if (item.getLayoutComponents() != null) {
							for (int n = 0; n < item.getLayoutComponents().length; n++) {
								DescribeLayoutComponent current = item
										.getLayoutComponents(n);

								
								if (item != null) {
									fields.add(current.getValue());
								}
							}
						}
					}

				}

			}

		}

		Collection<LayoutsFieldVO> fields = new ArrayList<LayoutsFieldVO>();

		Set<String> recordTypes = new TreeSet<String>();
		recordTypes.addAll(recordTypesToLayouts.keySet());
		
		layoutIds = new ArrayList<String>();
		
		for (Iterator iter = recordTypes.iterator(); iter.hasNext();) {
			String element = (String) iter.next();
			layoutIds.add(recordTypesToLayouts.get(element));
		}
		
		this.setRecordTypes(recordTypes);
		
		for (int i = 0; i < this.getResults().getFields().length; i++) {

			Field current = this.getResults().getFields()[i];
			LayoutsFieldVO vo = new LayoutsFieldVO();

			vo.setLabel(current.getLabel());
			vo.setName(current.getName());

			boolean present = false;



			for (Iterator iter = recordTypes.iterator(); iter.hasNext();) {
				String element = (String) iter.next();
				String layoutId = recordTypesToLayouts.get(element);

				Set<String> fieldsInLayout = layoutIdsToFieldSets
						.get(layoutId);

				if (fieldsInLayout.contains(current.getName())) {
					present = true;
					vo.getPresent().add(Boolean.TRUE);
				} else {
					vo.getPresent().add(Boolean.FALSE);
				}
			}

			if (!present) {
				vo.setNotFound(true);
			}
			
			fields.add(vo);

		}
		
		Set<LayoutsFieldVO> orderedRows = new TreeSet<LayoutsFieldVO>(new LayoutsFieldVOComparator());
		
		orderedRows.addAll(fields);
		
		this.setRows(orderedRows);
	}

	public Collection<String> getLayoutIds() {
		return layoutIds;
	}

	public void setLayoutIds(Collection<String> layoutIds) {
		this.layoutIds = layoutIds;
	}

	public Collection<String> getRecordTypes() {
		return recordTypes;
	}

	public void setRecordTypes(Collection<String> recordTypes) {
		this.recordTypes = recordTypes;
	}

	public Collection<LayoutsFieldVO> getRows() {
		return rows;
	}

	public void setRows(Collection<LayoutsFieldVO> rows) {
		this.rows = rows;
	}

	public DescribeSObjectResult getResults() {
		return results;
	}

	public void setResults(DescribeSObjectResult results) {
		this.results = results;
	}
}
