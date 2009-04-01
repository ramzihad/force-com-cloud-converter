<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Sign On</title>


</head>

<body>

<h1>Describe</h1>


<s:if test="results != null">
<h2><s:property value="target" /></h2>





<p><a href="<s:url action="select" />">Select New Object</a> |
<a href="<s:url value="describeWorkbook.xls"><s:param name="target" value="target" /></s:url>">Excel</a> |
<a href="<s:url action="describeForm"><s:param name="target" value="target" /></s:url>">W2A Form (without required)</a> | 
<a href="<s:url action="layoutsv2"><s:param name="target" value="target" /></s:url>">Switch to Layouts</a> | 
<a href="<s:url value="describeWorkbookAll.xls" />">Excel All (Careful: this may take a couple of minutes.)</a> | 
<a href="<s:url value="dataTemplateWorkbook.xls" />">Data Template As Excel</a>
</p>

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
		<th>Calc Form</th>
		<th>Def Form</th>
		<th>Reference</th>
		<th>Controller</th>
		<th>Unique</th>
	</tr>
	<s:iterator value="results">
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
			<td><s:property value="calculatedFormula" /></td>
			<td><s:property value="defaultFormula" /></td>
			<td><s:iterator value="referenceTo"><li><a href="<s:url action="describe"><s:param name="target" value="[0].top"/></s:url>"><s:property /></a></li></s:iterator></td>
			<td><s:property value="controllerName" /></td>
			<td>
				<s:if test="unique == true">Yes</s:if>
			</td>
		</tr>
	</s:iterator>
</table>

</s:if>
<s:else>
	
	<p>Select the object you want to describe by clicking on it above.  Once you have selected it, you will be able to create an excel workbook of it or of all the records.</p>
</s:else>


</body>
</html>