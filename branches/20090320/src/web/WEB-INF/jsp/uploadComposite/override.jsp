<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Upload</title>
	</head>

	<body onload="hideLoader()">

		<s:actionerror />
		<s:fielderror />
		<s:form action="upload" method="POST">

			<h3>
				Object exists
			</h3>
			
			The object exists in Salesforce.<br /> 
			Do you want to continue and delete it?
			<br />
			<br />
			<a href="import.action">Go back</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="import3.action">Continue - this will delete the current object and all data</a>

		</s:form>
	</body>
</html>
