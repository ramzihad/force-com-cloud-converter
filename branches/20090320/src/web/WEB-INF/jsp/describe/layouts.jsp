<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Layouts</title>

<style>
.found {
	background-color: #0F0;
}
</style>
</head>

<body>

<h1>Layouts</h1>

<p><s:iterator value="describeContext.types"><a href="<s:url action="layouts"><s:param name="target" value="[0].top" /></s:url>"><s:property /></a> | </s:iterator></p>

<s:if test="results != null">
<h2><s:property value="target" /></h2>

<p><a href="<s:url action="layoutsv2"><s:param name="target" value="target" /></s:url>">Layouts V2</a>

<a href="<s:url value="layoutsWorkbook.xls"><s:param name="target" value="target" /></s:url>">Excel</a> | 

<a href="<s:url action="describe"><s:param name="target" value="target" /></s:url>">Switch to Describe</a></p>

<table>
	<tr>
		<th>Label</th>
		<th>Name</th>
		<th>Not Found</th>
		<s:iterator value="recordTypes">
			<th><s:property /></th>
		</s:iterator>
		
	</tr>
	<tr>
		<td colspan="3">Layout Ids</td>
		<s:iterator value="layoutIds">
			<td><s:property /></td>
		</s:iterator>
	</tr>		
						
	<s:iterator value="rows">
		<tr>
			<td><s:property value="label" /></td>
			<td><s:property value="name" /></td>
			<td <s:if test="notFound">class="found"</s:if>>&nbsp;</td>
			<s:iterator value="present">
				<s:if test="[0].top">
					<td class="found">***</td>
				</s:if>
				<s:else>
					<td>&nbsp;</td>
				</s:else>
			</s:iterator>			
				
		</tr>
	</s:iterator>
</table>

</s:if>

</body>
</html>