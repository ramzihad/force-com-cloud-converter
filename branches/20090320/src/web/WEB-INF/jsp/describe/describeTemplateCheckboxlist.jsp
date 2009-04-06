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
		<s:checkboxlist list="describeContext.objectTypes" name="selectedObjects" > <br/> </s:checkboxlist>
		<s:submit name="submit" />
	</p>
</s:form>
</body>
</html>