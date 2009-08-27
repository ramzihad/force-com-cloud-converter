<%@ taglib prefix="s" uri="/struts-tags"%>



<html>

	<head>

		<title>Advanced Options: Labels & Data Types</title>

<style>

table {

	border-collapse: collapse;

	width: 100%;

}

th, td {

	font-family: arial, hevetica, san-serif;

	font-size: 9pt;

	border: thin solid #000;

	vertical-align: top;

	padding: 3px;

}

</style>

<script language="javascript">



var objectToIdMap = {

	<s:iterator value="lookupObjects" status="objectStatus" var="currentObject">

		"<s:property />":[<s:iterator value="uploadContext.objectToIdMap.get(#currentObject)" status="fieldStatus">"<s:property />"<s:if test="!#fieldStatus.last">,</s:if></s:iterator>]<s:if test="!#objectStatus.last">,</s:if></s:iterator>};



var objectToFieldMap = {

	<s:iterator value="existingObjects" status="objectStatus" var="currentObject">

		"<s:property />":[<s:iterator value="uploadContext.objectToFieldMap.get(#currentObject)" status="fieldStatus">"<s:property />"<s:if test="!#fieldStatus.last">,</s:if></s:iterator>]<s:if test="!#objectStatus.last">,</s:if></s:iterator>};





function selectLookupObject(selectLookupObject) {

	var obj = selectLookupObject.options[selectLookupObject.selectedIndex].value;

	var newFields = objectToIdMap[obj];

	var fieldList = document.getElementById("lookupFieldList" + selectLookupObject.id.split("_")[1]);

	fieldList.options.length = 0;

	fieldList.options.length = newFields.length;



	for (i=0;i<newFields.length;i++) {

		fieldList.options[i] = new Option(newFields[i], newFields[i],false,false);

	}

}	



function selectExistingObject(selectExistingObject) {

	var obj = selectExistingObject.options[selectExistingObject.selectedIndex].value;

	var newFields = objectToFieldMap[obj];

	

	for (j=0; j < 500; j++) {

		var fieldList = document.getElementById("existingFieldList[" + j + "]");

		if (fieldList == null) {


			break;

		} 

		fieldList.options.length = 0;

		fieldList.options.length = newFields.length+1;

		fieldList.options[0] = new Option("", "",false,false);
		
		for (i=1;i<newFields.length+1;i++) {

			fieldList.options[i] = new Option(newFields[i-1], newFields[i-1],false,false);

		}

	}

}	



function areYouSure() {

	return confirm("Are you sure?");

}



</script>

	</head>

	<body>

		<h2>Advanced Options: <s:property value="uploadContext.currentCloudConverterObject.objectLabel" /></h2>

		

		<p><s:actionmessage /></p>



		<s:form action="importAdvancedOptions" method="POST" onsubmit="return areYouSure();">

		

		<h2>Object Detail</h2>

		

		<p>Import to Existing Object: 

			<s:select list="existingObjects" 

				id="existingObject"

				name="existingObject"

				value="" emptyOption="true"

				onChange="selectExistingObject(this);" />

			(Leave blank to create a new object.)

		</p>

		

		<p>Use Autonumber ("A-{00000}") for object name? 

				<s:checkbox

					id="nameUseAutonumber"

					name="nameUseAutonumber"

					fieldValue="true"

					value="nameUseAutonumber" /> </p>

					

		<p>Use data from field named <s:select list="metadata" listKey="name" listValue="name"

									name="nameUseField"

									value="nameUseField" emptyOption="true" /> for object name.</p>

									

		<p>Object Label: <s:textfield

									key="objectLabel" /></p>

		

		<p>Object Plural: <s:textfield

									key="objectPlural"/></p>

	

	

		<h2>Field Detail</h2>

		

			<table>

				<tr>

					<th>API Name</th>

					<th>Label</th>

					<th>Type</th>

					<th>Length</th>

					<th>Precision</th>

					<th>Scale</th>

					<th>External Id?</th>

					<th>Sample</th>

					<th>Looks Up To</th>

					<th>Using Field</th>

					<th>Existing Field</th>

				</tr>

				<s:iterator value="metadata" status="status" var="metadata">

					<tr>

						<td><s:property value="name" />

						<s:hidden

									id="metadata[%{#status.index}].name"

									name="metadata[%{#status.index}].name"

									value="%{metadata[#status.index].name}" />

						<s:hidden

									id="metadata[%{#status.index}].index"

									name="metadata[%{#status.index}].index"

									value="%{metadata[#status.index].index}" />									

						</td>

						<td><s:textfield

									id="metadata[%{#status.index}].label"

									name="metadata[%{#status.index}].label"

									value="%{metadata[#status.index].label}" /></td>

						<td><s:select list="fieldTypes" 

									name="metadata[%{#status.index}].typeString"

									value="%{metadata[#status.index].typeString}" />

						</td>

						<td><s:textfield

									id="metadata[%{#status.index}].length"

									name="metadata[%{#status.index}].length"

									value="%{metadata[#status.index].length}" size="5"/></td>

						<td><s:textfield

									id="metadata[%{#status.index}].precision"

									name="metadata[%{#status.index}].precision"

									value="%{metadata[#status.index].precision}" size="5" /></td>

						<td><s:textfield

									id="metadata[%{#status.index}].scale"

									name="metadata[%{#status.index}].scale"

									value="%{metadata[#status.index].scale}" size="5"/></td>

						<td><s:checkbox

								id="metadata[%{#status.index}].uniqueExternalId"

								name="metadata[%{#status.index}].uniqueExternalId"

								fieldValue="true"

								value="%{metadata[#status.index].uniqueExternalId}" />

						</td>

						<td><s:property value="example" />

						<s:hidden

									id="metadata[%{#status.index}].example"

									name="metadata[%{#status.index}].example"

									value="%{metadata[#status.index].example}" />

									</td>

						<td><s:select list="lookupObjects" 

									id="lookupObjectList_[%{#status.index}]"

									name="metadata[%{#status.index}].lookupObject"

									value="" emptyOption="true"

									onChange="selectLookupObject(this);" /></td>

						<td><s:select list="{}" name="metadata[%{#status.index}].lookupField" id="lookupFieldList[%{#status.index}]" /></td>

						<td><s:select list="{}" name="metadata[%{#status.index}].existingField" id="existingFieldList[%{#status.index}]" /></td>

				</tr>				

				</s:iterator>

			</table>

			<p><s:submit name="submit" value="Import This Object" /> &nbsp; <s:submit name="submit" value="Skip This Object" /></p>

		</s:form>



	</body>



</html>



