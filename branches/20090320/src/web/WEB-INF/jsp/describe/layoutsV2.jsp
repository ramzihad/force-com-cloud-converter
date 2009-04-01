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

<h1>Layouts V2</h1>

<p><s:iterator value="describeContext.types"><a href="<s:url action="layoutsv2"><s:param name="target" value="[0].top" /></s:url>"><s:property /></a> | </s:iterator></p>

<s:if test="summary != null">
<h2><s:property value="target" /></h2>

<p>Need excel?  Switch to the <a href="<s:url action="layouts"><s:param name="target" value="target" /></s:url>">original version of layouts</a>. | 

<a href="<s:url action="describe"><s:param name="target" value="target" /></s:url>">Switch to Describe</a> |
<a href="<s:url action="layoutsv2form"><s:param name="target" value="target" /></s:url>">W2A Form</a> | </p>

<table>
	<tr>
		<th>Label</th>
		<th>API Name</th>
		<th>Not Found</th>
		<s:iterator value="summary.headers">
			<th colspan="3"><s:property /></th>
		</s:iterator>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<s:iterator value="summary.headers">
			<td>Editable?</td>
			<td>Required?</td>
			<td>Values</td>
		</s:iterator>
	</tr>
						
	<s:iterator value="summary.rows">
		<tr>
			<td><s:property value="field.label" /></td>
			<td><s:property value="field.name" /></td>
			<td ><s:if test="missing">Missing</s:if>&nbsp;</td>
			<s:iterator value="layouts">
				<s:if test="present">
					<td class="found"><s:property value="editable" /> </td>
					<td class="found"><s:property value="required" /></td>
					<td class="found">
						<s:if test="values != null">
							<s:iterator value="values" status="rowstatus">
								<s:property /><s:if test="!#rowstatus.last"><br/></s:if>
							</s:iterator>
						</s:if>
					</td>
				</s:if>
				<s:else>
					<td colspan="3">&nbsp;</td>
				</s:else>
			</s:iterator>			
				
		</tr>
	</s:iterator>
</table>

</s:if>

</body>
</html>