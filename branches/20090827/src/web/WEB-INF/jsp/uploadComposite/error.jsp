<%@ taglib prefix="s" uri="/struts-tags"%>


<html>


	<head>
		<title>Cloud Converter Cannot Continue</title>

	</head>

	<body>
		<h1>Cloud Converter Cannot Continue</h1>
		
		<p>Message: <s:property value="uploadContext.errorMessage" /></p>
		
		<s:if test="uploadContext.message != null">
			<p><s:property value="uploadContext.message" /></p>
		</s:if>
		
		<p>Read our <a href="<s:url action="troubleshooting"></s:url>">Troubleshooting tips</a>.</p>

		<p>Questions? Contact Model Metrics - <a href="mailto:cloudconverter@modelmetrics.com">cloudconverter@modelmetrics.com</a></p>


	</body>
</html>
