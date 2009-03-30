<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>

<html>
	<head>
		<title>View</title>
		
				<link rel="stylesheet" href="https://na4.salesforce.com/sCSS/15.0/1238015590000/Theme2/common.css" />
		
	</head>

	<body>
		<table>
		
		<tr>
		<td>
		
		<h1>Complete!</h1>

		<p>Congratulations! You have Imported Your App.</p>
		
		<p>Step 3: Update your permissions to control which profiles can see the object. </p>
		
		<p>Simply edit the profile(s) you want to have access to the object and change tab visibility from "Tab Hidden" to "Default On".</p>
		
		<p>The tab visibility you want to change is "<s:property value="uploadContext.wrapperBean.sheetName" />".</p>
		
		<p><a href="<s:property value="uploadContext.profileListUrl" />" target="_parent">Click here to go to your profile list.</a></p>
		
		<p>Or you can do this step later and <a href="import.action">import another.</a></p>
		
		</td>
		<td valign="top">
		<img src="./img/mmlogo.jpg" />
		</td>
		</tr>
		</table>
	</body>
</html>
