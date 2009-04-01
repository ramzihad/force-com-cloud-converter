<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Upload</title>
		
						<link rel="stylesheet" href="https://na4.salesforce.com/sCSS/15.0/1238015590000/Theme2/common.css" />
		
	</head>

	<body onload="hideLoader()">

		<s:actionmessage />
		<s:fielderror />
		<s:form action="upload" method="POST">

		
			<h1>Object Exists - Overwrite?</h1>
			
			<p>The object "<s:property value="uploadContext.wrapperBean.sheetName" />" exists in Salesforce.</p>
			 
			<p>Do you want to continue?</p>

			<p><a href="import.action">No - Go back</a></p>
			
			<p><a href="import3.action">Yes - Continue - this will delete the current object and all data associated with it.</a></p>


		
		</s:form>
	</body>
</html>
