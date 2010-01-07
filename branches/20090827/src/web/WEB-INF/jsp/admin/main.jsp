<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Admin</title>
			<link rel="stylesheet" type="text/css" media="all" href="./css/describe.css" />

</head>

<body>

<h1>Admin</h1>

<ul>
	<s:iterator value="adminBean.users" status="stat">
		<li><s:property value="info.organizationName" />: <s:property value="info.userFullName" />: <s:property value="info.userEmail" /> - <s:property value="what" /> (<s:property value="formattedDate" />)</li>
	</s:iterator>
</ul>

</body>
</html>