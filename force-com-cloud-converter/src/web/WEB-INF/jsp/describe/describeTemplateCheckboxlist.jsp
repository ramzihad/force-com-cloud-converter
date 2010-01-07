<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Excel Describe Template</title>
    			<link rel="stylesheet" type="text/css" media="all" href="./css/describe.css" />
    
</head>
<body>
<h1>Excel Describe Template</h1>
<s:form name="checkboxForm" action="describeOutputAsTemplate.xls" >
	<p>
		<s:checkboxlist list="describeContext.types" name="selectedObjects" > <br/> </s:checkboxlist>
	</p>
	<p>
		<s:submit name="submitMetadata" value="Export as Metadata" />
		<s:submit name="submitTemplate" value="Export as Data Templates" />
	</p>
</s:form>
</body>
</html>