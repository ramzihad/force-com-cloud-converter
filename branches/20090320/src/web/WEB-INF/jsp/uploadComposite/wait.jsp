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

	<h1>More Information</h1>
	
	<p>Have a suggestion on how to improve this application? Visit <a href="http://modelmetrics.com" target="_blank">Model Metrics</a> on the web to learn more about our services or provide feedback.</p>
	</body>
</html>

