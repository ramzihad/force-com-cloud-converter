<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Select Target Object</title>

</head>

<body>

<h1>Select Target Object</h1>

<a href="<s:url action="describeOutputAsTemplate"></s:url>">Get Multiple Objects</a>

<p>
	<s:iterator value="describeContext.types"><a href="<s:url action="describe"><s:param name="target" value="[0].top" /></s:url>"><s:property /></a> | </s:iterator>
</p>


</body>
</html>