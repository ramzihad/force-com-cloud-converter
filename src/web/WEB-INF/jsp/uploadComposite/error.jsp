<%@ taglib prefix="s" uri="/struts-tags"%>


<html>


	<head>
		<title>Error</title>

	</head>

	<body>
		<h1>Error</h1>
		
		<p>Hey -- it's Beta software, that's bound to happen from time to time. :-)</p>
		<p>Please report this to Model Metrics - <a href="mailto:rcarlberg@modelmetrics.com">rcarlberg@modelmetrics.com</a></p>
		<p><s:actionmessage /></p>
		
		<p>Message: <s:property value="errorMessage" /></p>
		
		<p><a href="import1.action">Please try again.</a> (That will sometimes work.)</p>
	</body>
</html>
