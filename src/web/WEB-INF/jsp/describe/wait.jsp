<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>Loading objects...</title>
		<meta http-equiv="refresh" content="5;url=<s:url includeParams="all" />"/>
	</head>

	<body>

	<h2>Describing Objects > Please Wait</h2>
	
	<h2>Current Status, Newest First</h2>
	
	<p>This page refreshes automatically every five seconds.  Please be patient.</p>
	
	<p>
	
	<s:iterator value="describeContext.statusSubscriber.status">
		- <s:property /><br/>
	</s:iterator>
	
	</p>

	<h1>What Do You Think?</h1>
	
	<p>Questions? Comments? <a href="http://community.salesforce.com/sforce/?category.id=developers">Join the conversation.</a></p>
	
	
	<p>Visit <a href="http://modelmetrics.com" target="_blank">Model Metrics</a> on the web to learn more about our services.</p>

	</body>
</html>

