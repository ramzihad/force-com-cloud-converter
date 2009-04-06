<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Migrate Utility</title>

</head>

<body>

<h1>Migrate Preview</h1>

<p>If all this looks right, go to the bottom and hit "execute".  If it doesn't look right, hit the back button and try again.</p>

<p>Strategy: <s:property value="migrateContext.conflict.name" /> | <a href="migrateSetup.action">Edit</a></p>
<table>
	<tr>
		<th><s:property value="migrateContext.preview" /></th>
		<th>Source (<s:property value="migrateContext.source" />)</th>
		<th>Target (<s:property value="migrateContext.target" />)</th>
		<th>Result</th>
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