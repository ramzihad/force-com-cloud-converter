<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>Loading objects...</title>
		<meta http-equiv="refresh" content="5;url=<s:url includeParams="none" />"/>
	</head>

	<body>

	<h1>Describing Objects > Please Wait</h1>
	
	<p><strong>Current Status, Newest First</strong></p>
	
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

