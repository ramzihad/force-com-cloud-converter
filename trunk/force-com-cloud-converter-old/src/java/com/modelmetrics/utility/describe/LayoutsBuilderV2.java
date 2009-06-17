package com.modelmetrics.utility.describe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.util.FieldComparator;
import com.sforce.soap.partner.DescribeLayout;
import com.sforce.soap.partner.DescribeLayoutComponent;
import com.sforce.soap.partner.DescribeLayoutItem;
import com.sforce.soap.partner.DescribeLayoutResult;
import com.sforce.soap.partner.DescribeLayoutRow;
import com.sforce.soap.partner.DescribeLayoutSection;
import com.sforce.soap.partner.Field;
import com.sforce.soap.partner.PicklistEntry;
import com.sforce.soap.partner.PicklistForRecordType;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.RecordTypeMapping;

public class LayoutsBuilderV2 {

	private Log log = LogFactory.getLog(LayoutsBuilderV2.class);

	public LayoutsSummary execute(SalesforceSession salesforceSession,
			String type) throws Exception {

		/*
		 * execute queries
		 */
		Field[] fields = salesforceSession.getSalesforceService().describeSObject(type)
				.getFields();

		
		DescribeLayoutResult describeLayoutResult = salesforceSession.getSalesforceService().describeLayout(type, null);

		/*
		 * setup record types to fields to picklists
		 * 
		 * setup record types to layout ids (so we don't have to go through
		 * twice)
		 * 
		 * setup record types to record type names (so we don't have to go
		 * through twice)
		 */

		Map<String, Map<String, Collection<String>>> recordtypesToPicklistsAndValues = new HashMap<String, Map<String, Collection<String>>>();

		Map<String, String> recordtypesToLayoutIds = new HashMap<String, String>();

		Map<String, String> recordtypesToRecordtypeNames = new HashMap<String, String>();

		Map<String, String> recordtypeNamesToRecordtypeIds = new HashMap<String, String>();
		
		Map<String, Collection<String>> fieldNamesToRecordTypeNames = new HashMap<String, Collection<String>>();
		
		if(describeLayoutResult.getRecordTypeMappings() != null)
		{
			for (int j = 0; j < describeLayoutResult.getRecordTypeMappings().length; j++) {
				RecordTypeMapping currentMapping = describeLayoutResult
						.getRecordTypeMappings()[j];
	
				Map<String, Collection<String>> recordtypePicklistValues = new HashMap<String, Collection<String>>();
	
				if(currentMapping.getPicklistsForRecordType() != null)
				{
					for (int k = 0; k < currentMapping.getPicklistsForRecordType().length; k++) {
		
						PicklistForRecordType currentPicklist = currentMapping
								.getPicklistsForRecordType(k);
		
						Collection<String> values = new ArrayList<String>();
		
						for (int i = 0; i < currentPicklist.getPicklistValues().length; i++) {
							PicklistEntry entry = currentPicklist.getPicklistValues(i);
							String value = entry.getValue();
							if (entry.isDefaultValue()) {
								value += " (default)";
							}
							values.add(value);
						}
		
						recordtypePicklistValues.put(currentPicklist.getPicklistName(),
								values);
					}
				}
	
				recordtypesToPicklistsAndValues.put(currentMapping
						.getRecordTypeId(), recordtypePicklistValues);
	
				recordtypesToLayoutIds.put(currentMapping.getRecordTypeId(),
						currentMapping.getLayoutId());
	
				recordtypesToRecordtypeNames.put(currentMapping.getRecordTypeId(),
						currentMapping.getName());
	
				recordtypeNamesToRecordtypeIds.put(currentMapping.getName(),
						currentMapping.getRecordTypeId());
	
			}
		}

		/*
		 * setup layout ids to field information
		 */
		Map<String, Map<String, FieldItemVO>> layoutIdsToFields = new HashMap<String, Map<String, FieldItemVO>>();

		for (int i = 0; i < describeLayoutResult.getLayouts().length; i++) {
			DescribeLayout layout = describeLayoutResult.getLayouts()[i];

//			 log.info(layout.getId());

			Map<String, FieldItemVO> layoutFields = new HashMap<String, FieldItemVO>();

//			walkLayoutSections(layoutFields, layout.getDetailLayoutSections());
			walkLayoutSections(layoutFields, layout.getEditLayoutSections());

//			for (Iterator iter = layoutFields.values().iterator(); iter.hasNext();) {
//				FieldItemVO element = (FieldItemVO) iter.next();
//				log.info(element);
//			}
			layoutIdsToFields.put(layout.getId(), layoutFields);
		}

		/*
		 * setup alphabetical lists
		 */
		Set<Field> alphabeticalFieldList = new TreeSet<Field>(
				new FieldComparator());

		for (int i = 0; i < fields.length; i++) {
			alphabeticalFieldList.add(fields[i]);
		}

		Set<String> alphabeticalRecordtypNameList = new TreeSet<String>();
		alphabeticalRecordtypNameList.addAll(recordtypeNamesToRecordtypeIds
				.keySet());

		/*
		 * build the output
		 */

		Collection<LayoutsFieldVOV2> rows = new ArrayList<LayoutsFieldVOV2>();

		for (Iterator iter = alphabeticalFieldList.iterator(); iter.hasNext();) {
			Field currentField = (Field) iter.next();

			LayoutsFieldVOV2 currentRow = new LayoutsFieldVOV2();
			currentRow.setField(currentField);

			for (Iterator iterator = alphabeticalRecordtypNameList.iterator(); iterator
					.hasNext();) 
			{
								
				String currentRecordtypeName = (String) iterator.next();

				String currentRecordtypeId = recordtypeNamesToRecordtypeIds
						.get(currentRecordtypeName);

				String currentLayoutId = recordtypesToLayoutIds
						.get(currentRecordtypeId);

				Map<String, FieldItemVO> layoutFieldMap = layoutIdsToFields
						.get(currentLayoutId);

				FieldItemVO fieldItemVO = layoutFieldMap.get(currentField
						.getName());

				/*
				 * if we find settings, add them, otherwise add an empty record.
				 */
				if (fieldItemVO != null) {
					
					Collection<String> recordTypeNames = fieldNamesToRecordTypeNames.get(currentField.getName());
					
					if(recordTypeNames == null)
						recordTypeNames = new ArrayList<String>();
					
					recordTypeNames.add(currentRecordtypeName);
					fieldNamesToRecordTypeNames.put(currentField.getName(), recordTypeNames);
					
					Map<String, Collection<String>> picklistValues = recordtypesToPicklistsAndValues.get(currentRecordtypeId);
					
					if (picklistValues != null) {
						
						fieldItemVO.setValues(picklistValues.get(currentField.getName()));
						
					}
					
					currentRow.getLayouts().add(fieldItemVO);
				} else {
					currentRow.getLayouts().add(new FieldItemVO());
				}
			}

			rows.add(currentRow);
		}

		/*
		 * and finally the VO that does it all...
		 */
		LayoutsSummary ret = new LayoutsSummary();

		ret.setRows(rows);

		for (Iterator iterator = alphabeticalRecordtypNameList.iterator(); iterator
				.hasNext();) {
			String currentRecordtypeName = (String) iterator.next();
			ret.getHeaders().add(currentRecordtypeName);
		}
		
		ret.setRecordTypes(getRecordTypes(type, salesforceSession));
		ret.setFieldNamesToRecordTypeNames(fieldNamesToRecordTypeNames);
		
		return ret;

	}

	public String getRecordTypes(String objectName, SalesforceSession salesforceSession)
	{
		String recordTypes = "";
		try
		{
			QueryResult qr = salesforceSession.getSalesforceService().query("Select Name From RecordType WHERE SobjectType = '" + objectName + "'");
			
			for (int i = 0; i < qr.getRecords().length; i++) {
				recordTypes = recordTypes + qr.getRecords()[i].get_any()[0].getValue() + "\n";
				
			}
		}
		
		catch(Exception e)
		{
			return("Error querying record types");
		}
		
		return recordTypes;
	}
	
	public void walkLayoutSections(Map<String, FieldItemVO> fieldMap,
			DescribeLayoutSection[] sections) {

		for (int j = 0; j < sections.length; j++) {

			DescribeLayoutSection section = sections[j];

			for (int k = 0; k < section.getLayoutRows().length; k++) {

				DescribeLayoutRow row = section.getLayoutRows(k);

				for (int l = 0; l < row.getLayoutItems().length; l++) {

					DescribeLayoutItem item = row.getLayoutItems(l);

					if (!item.isPlaceholder()
							&& item.getLayoutComponents() != null) {

						// log.info("label: " + item.getLabel());

						for (int m = 0; m < item.getLayoutComponents().length; m++) {

							DescribeLayoutComponent comp = item
									.getLayoutComponents(m);

							if (!comp.getType().getValue().equalsIgnoreCase(
									"separator")) {

								if (comp.getType().getValue().equalsIgnoreCase(
										"field")) {
									// log.info("comp type: "
									// + comp.getType().getValue());
									// log.info("comp value: " +
									// comp.getValue());

									FieldItemVO vo = fieldMap.get(comp
											.getValue());

									if (vo == null) {
										vo = new FieldItemVO();
										vo.setFieldName(comp.getValue());
										fieldMap.put(comp.getValue(), vo);
									}

									vo.setPresent(true);
									if (item.isEditable()) {
										vo.setEditable(true);
									}
									if (item.isRequired()) {
										vo.setRequired(true);
									}
									
								}

							}
						}
					}

				}
			}
		}
	}

}
