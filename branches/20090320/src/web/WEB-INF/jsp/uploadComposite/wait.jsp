<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>Loading objects...</title>
		<meta http-equiv="refresh" content="5;url=<s:url includeParams="all" />"/>
	</head>

	<body>

	<h2>Importing Your App > Please Wait</h2>
	
	<h2>Current Status, Newest First</h2>
	
	<p>This page refreshes automatically every five seconds.  Please be patient.</p>
	
	<p>
	
	<s:iterator value="uploadContext.statusSubscriber.status">
		- <s:property /><br/>
	</s:iterator>
	
	</p>

	<h1>What Do You Think?</h1>
	
	<p>Have a suggestion on how to improve this application? Visit <a href="http://community.modelmetrics.com" target="_blank">Community@ModelMetrics.com</a> or contact Reid Carlberg at <a href="mailto:rcarlberg@modelmetrics.com">rcarlberg@modelmetrics.com</a> or on Twitter at <a href="http://Twitter.com/ReidCarlberg" target="_blank">@ReidCarlberg</a>.</p>
	
	<p>Visit <a href="http://modelmetrics.com" target="_blank">Model Metrics</a> on the web to learn more about our services.</p>
	</body>
</html>

