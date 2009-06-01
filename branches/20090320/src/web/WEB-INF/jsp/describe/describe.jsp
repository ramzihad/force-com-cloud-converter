<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Describe</title>
			<link rel="stylesheet" type="text/css" media="all" href="./css/describe.css" />


</head>

<body>

<h1>Describe: "<s:property value="describeContext.target" />"</h1>






<p>
<a href="<s:url action="select" />">Select New Object</a> |
<a href="<s:url value="describeWorkbook.xls"></s:url>">Excel</a> |
<s:if test="results.layoutable">
	<a href="<s:url action="layoutsv2"></s:url>">Switch to Layouts</a> |
</s:if> 
<a href="<s:url value="dataTemplateWorkbook.xls" />">Data Template As Excel</a>
</p>

<h2>Object Level Information</h2>

<table>
	<tr>
		<td>Name</td>
		<td></td>
	</tr>
	<tr>
		<td>Label</td>
		<td></td>
	</tr>
	<tr>
		<td>Plural Label</td>
		<td></td>
	</tr>
	<tr>
		<td>Key Prefix</td>
		<td></td>
	</tr>
	<tr>
		<td>URL Add</td>
		<td></td>
	</tr>
	<tr>
		<td>URL Detail</td>
		<td></td>
	</tr>
	<tr>
		<td>URL Edit</td>
		<td></td>
	</tr>
</table>	

<h2>Fields</h2>

<table>
	<tr>
		<th>Label</th>
		<th>Name</th>
		<th>Type</th>
		<th>Len</th>
		<th>Precision</th>
		<th>Scale</th>
		<th>Digits</th>
		<th>Values</th>
		<th>Formula</th>
		<th>Calc Form</th>
		<th>Def Form</th>
		<th>Relationship Name</th>
		<th>Reference To</th>
		<th>Controller</th>
		<th>Unique</th>
		<th>Filterable</th>
		<th>ID Lookup</th>
		<th>Sortable</th>
		<th>Updateable</th>
		<th>HTML Formatted</th>
		<th>Help Text</th>
	</tr>
	<s:iterator value="objectFields">
		<tr>
			<td><s:property value="label" /></td>
			<td><s:property value="name" /></td>
			<td>
				<s:property value="type" />   
				<s:if test="externalId == true">(ext id)</s:if>
			</td>
			<td><s:property value="length" /></td>
			<td><s:property value="precision" /></td>
			<td><s:property value="scale" /></td>
			<td><s:property value="digits" /></td>
			<td>
			<s:iterator value="picklistValues" status="rowstatus"><s:property value="value" /><s:if test="!#rowstatus.last"><br /></s:if></s:iterator>
			</td>
			<td><s:property value="formula" /></td>
			<td><s:property value="calculatedFormula" /></td>
			<td><s:property value="defaultFormula" /></td>
			<td><s:property value="relationshipName" /></td>
			<td><s:iterator value="referenceTo"><li><a href="<s:url action="describe"><s:param name="target" value="[0].top"/></s:url>"><s:property /></a></li></s:iterator></td>
			<td><s:property value="controllerName" /></td>
			<td>
				<s:if test="unique == true">Yes</s:if>
			</td>
			<td><s:property value="filterable" /></td>
			<td><s:property value="idLookup" /></td>
			<td><s:property value="sortable" /></td>
			<td><s:property value="updateable" /></td>
			<td><s:property value="htmlFormatted" /></td>
			<td><s:property value="inlineHelpText" /></td>
		</tr>
	</s:iterator>
</table>

<h2>Record Types</h2>

<table>
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Available</th>
		<th>Default?</th>
	</tr>
	<s:iterator value="recordTypeInfos">
		<tr>
			<td><s:property value="recordTypeId" /></td>
			<td><s:property value="name" /></td>
			<td><s:property value="available" /></td>
			<td><s:property value="defaultRecordTypeMapping" /></td>
		</tr>
	</s:iterator>
</table>

</body>
</html>