<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Upload</title>
		
	</head>

	<body >

		<h1>Step 1: Select Your Excel File</h1>

		<s:actionerror />
		<s:fielderror />
		<s:form action="processUpload" method="POST" enctype="multipart/form-data" theme="simple">

			
			
			<p>This routine will import your Microsoft Excel based application and data into Salesforce.</p>
			
			<p>Select your file and click on "upload".  Importing your app will take a short amount of time.  You will see a Success! screen when it is complete.</p>
			
			<p>File: <s:file name="upload" label="File" /> <s:submit value="Step 2: Upload" id="butSubmit" onclick="showLoader()" />

			<p><s:actionmessage /></p>

		</s:form>
		
		<h2>Important Excel File Formatting Tips</h2>
		
		<ul>
		<li>Maximum file size is 1 MB.</li>
		<li>The object name comes from the work sheet name.  </li>
		<li>You must ensure that empty columns and rows are empty.  To do this, select empty columns to the right of your data and empty rows below your data and use "Edit" and then "Delete" from the Excel menu.</li>
		<li>Your XLS file can have multiple work sheets.  Import Your App will import each work sheet as a separte object.</li>
		<li>Objects will be created in the order in which the spreadsheets appear, left to right.</li>
		<li>If object B needs to lookup to object A, object B should be to the right of object A.</li>  
		<li>The first row will contain your field names.  Import Your App will remove spaces and other special characters.</li>
		<li>The second row will determine field data type.  Import Your App will assume that all data in your a column matches the data in the second row.</li>
		<li>Phone numbers should be formatted as (XXX) XXX-XXXX</li>
		<li>This routine only supports "XLS" files, not "XLSX".</li>
		</ul>
		
		
	</body>
</html>
