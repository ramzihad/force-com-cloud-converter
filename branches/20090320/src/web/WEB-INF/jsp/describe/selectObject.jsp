<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Select Target Object</title>
			<link rel="stylesheet" type="text/css" media="all" href="./css/describe.css" />

</head>

<body>

<h1>Select Target Object - Beta</h1>

<s:if test="describeContext.lastMessage != null">
<br/><h2><s:property value="describeContext.lastMessageWithReset" /></h2>
</s:if>

<p>
	<s:iterator value="describeContext.types"><a href="<s:url action="describe"><s:param name="target" value="[0].top" /></s:url>"><s:property /></a> | </s:iterator>
</p>

<p><a href="<s:url value="describeWorkbookAll.xls" />">Excel All (Careful: this may take a couple of minutes during which time your browser will appear non-responsive.)</a></p> 

<p><a href="<s:url action="describeOutputAsTemplate"></s:url>">Get Multiple Objects</a></p>

</body>
</html>