<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>Loading objects...</title>
		<meta http-equiv="refresh" content="5;url=<s:url includeParams="all" />"/>
		<SCRIPT TYPE="text/javascript" SRC="http://ajax.googleapis.com/ajax/libs/dojo/1.3/dojo/dojo.xd.js"></SCRIPT>
	</head>

	<body>

	<h1>Importing Your App > Please Wait</h1>
	
	<p>Have a suggestion on how to improve this application? Contact Reid Carlberg at <a href="mailto:rcarlberg@modelmetrics.com">rcarlberg@modelmetrics.com</a>.</p>
	
	<p>Visit <a href="http://modelmetrics.com" target="_blank">Model Metrics</a> on the web to learn more about our services.</p>
	
	<h2>Current Status, Newest First</h2>
	
	<p>This page refreshes automatically every five seconds.  Please be patient.</p>
	
	<p>
	
	<s:iterator value="uploadContext.statusSubscriber.status">
		- <s:property /><br/>
	</s:iterator>
	
	</p>

	</body>
</html>

