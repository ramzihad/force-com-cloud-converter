<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Sign On</title>


</head>

<body>

<h1>Describe Form</h1>

<s:if test="results != null">
<h2><s:property value="target" /></h2>





<p><a href="<s:url action="describe"><s:param name="target" value="target" /></s:url>">Main Describe</a> 
</p>

	<s:form action="'https://www.modelmetricssoftware.com/web2anything/servlet/WEBObjectParserServlet'" >

	<s:iterator value="results">
	
	<s:if test="'${type}' == 'string'">
		<s:textfield name="${name}" label="${label} (string)" />
	</s:if>
	<s:if test="'${type}' == 'double'">
		<s:textfield name="${name}" label="${label}  (double)" />
	</s:if>
	<s:if test="'${type}' == 'currency'">
		<s:textfield name="${name}" label="${label} (currency)" />
	</s:if>
	<s:if test="'${type}' == 'picklist'">
		<s:select name="${name}" label="${label} + ' (picklist)'" list="picklistValues" listKey="value" listValue="value" />
	</s:if>
	<s:if test="'${type}' == 'multipicklist'">
		<s:select name="${name}" label="${label} + ' (picklist multi)'" list="picklistValues" listKey="value" listValue="value" multiple="true" />
	</s:if>
	<s:if test="'${type}' == 'reference'"></s:if>
	<s:if test="'${type}' == 'date'">
		<s:textfield name="${name}" label="${label} + ' (date)'" />
	</s:if>	
	
		
	</s:iterator>
	
	</s:form>


</s:if>
<s:else>
	
	<p>Select the object you want to describe by clicking on it above.  Once you have selected it, you will be able to create an excel workbook of it or of all the records.</p>
</s:else>


</body>
</html>