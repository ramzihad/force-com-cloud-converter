<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Migrate Utility</title>
	<link rel="stylesheet" type="text/css" media="all" href="./css/describe.css" />
</head>

<body>

<h1>Migrate Execute</h1>

<p>Execution complete.</p>

<s:if test="errorObjects != null && errorObjects.size > 0">
<p>Not all records could be processed.  Records with errors are below.</p>
<table>
	<tr>
		<th><s:property value="migrateContext.previewField" /></th>
		<th>Source (<s:property value="migrateContext.sourceField" />)</th>
		<th>Target (<s:property value="migrateContext.targetField" />)</th>
		<th>Result</th>
	</tr>
	<s:iterator value="errorObjects">
		<tr>
			<td><s:property value="preview" /></td>
			<td><s:property value="source" /></td>
			<td><s:property value="target" /></td>
			<td><s:property value="result" /></td>
		</tr>
	</s:iterator>
</table>	
</s:if>
<s:else>
<p>Update successful.  There were no errors.</p>
</s:else>

</body>
</html>