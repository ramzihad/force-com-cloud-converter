<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Upload</title>
		
						
		
	</head>

	<body >


		
			<h1>Object Exists - Overwrite?</h1>
			
			<p>The object "<s:property value="uploadContext.wrapperBean.sheetName" />" exists in Salesforce.</p>
			 
			<p>Do you want to continue?</p>

			<p><a href="import.action">No - Go back</a></p>
			
			<p><a href="import3.action">Yes - Continue - this will delete the current object and all data associated with it.</a></p>


	</body>
</html>
