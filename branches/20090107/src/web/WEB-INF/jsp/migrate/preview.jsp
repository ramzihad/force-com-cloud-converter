<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Cloud Converter - Migrate Utility</title>
	<link rel="stylesheet" type="text/css" media="all" href="./css/describe.css" />
</head>

<body>

<h1>Migrate Preview</h1>

<p>If all this looks right, go to the bottom and hit "execute".  If it doesn't look right, <a href="migrateSetup.action">try again</a>.</p>

<p>Conflict Resolution Strategy: <s:property value="migrateContext.conflict.name" /> </p>
<table>
	<tr>
		<th><s:property value="migrateContext.previewField" /></th>
		<th>Source (<s:property value="migrateContext.sourceField" />)</th>
		<th>Target (<s:property value="migrateContext.targetField" />)</th>
		<th>Target Becomes</th>
		<th>Source Becomes</th>
	</tr>
	<s:iterator value="results">
		<tr>
			<td><s:property value="preview" /></td>
			<td><s:property value="source" /></td>
			<td><s:property value="target" /></td>
			<td><s:property value="result" /></td>
			<td><s:property value="newSource" /></td>
		</tr>
	
	</s:iterator>
		
	
</table>	

<p><a href="migrateExecute.action">Execute Migration</a></p>
								
</body>
</html>