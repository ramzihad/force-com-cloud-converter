<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Select Target Object</title>
			<link rel="stylesheet" type="text/css" media="all" href="./css/describe.css" />

</head>

<body>

<h1>Select Target Object</h1>

<s:if test="describeContext.lastMessage != null">
<br/><h2><s:property value="describeContext.lastMessageWithReset" /></h2>
</s:if>

<p>Filter by: 
	<a href="<s:url action="migrate"><s:param name="filter" value="" /></s:url>">Interesting</a>
	<s:iterator value="filterPrompts" status="stat"> | <a href="<s:url action="migrate"><s:param name="filter" value="[0].top" /></s:url>"><s:property /></a> </s:iterator>
</p>

<p>
	<s:iterator value="describeContext.types" status="stat"><a href="<s:url action="migrate"><s:param name="target" value="[0].top" /></s:url>"><s:property /></a><s:if test="!#stat.last"> | </s:if> </s:iterator>
</p>



</body>
</html>