<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Upload</title>
		<script type="text/javascript" charset="UTF-8"
			src="js/loader.js"></script>
	</head>

	<body onload="hideLoader()">

		<s:actionerror />
		<s:fielderror />
		<div id="form">
			<s:form action="generate" method="POST" >

				<h3>
					Upload Database information
				</h3>

				<table>
					<tr>
						<td>
							<s:textfield name="username" label="Username" />
						</td>
					</tr>
					<tr>
						<td>
							<s:password name="password" label="Password" />
						</td>
					</tr>
					<tr>
						<td>
							<b>Database information</b>
						</td>
					</tr>
					<tr>
						<td>
							<s:textfield name="dbName" label="Database Name (*)" />
						</td>
					</tr>
					<tr>
						<td>
							<s:textfield name="dbUser" label="Database User (*)" />
						</td>
					</tr>
					<tr>
						<td>
							<s:password name="dbPassword" label="Database Password" />
						</td>
					</tr>
					<tr>
						<td>
							<s:textfield name="dbUrl" label="Database URL (*)" />
						</td>
					</tr>
					<tr>
						<td>
							<s:textfield name="dbTable" label="Database Table (*)" />
						</td>
					</tr>
					<tr>
						<td>
							<s:textarea cols="29" rows="5" name="externalIds" label="External IDs" />
						</td>
					</tr>
					<tr>
						<td>
							<s:textarea cols="29" rows="5" name="lookupFields" label="Lookup Fields (*)" />
						</td>
					</tr>
					<tr>
						<td>
							<s:textarea cols="29" rows="5" name="picklistFields" label="Picklist Fields (*)" />
						</td>
					</tr>
					<tr>
						<td>
							<s:submit value="Upload" id="butSubmit" onclick="showLoader()" />
						</td>
					</tr>
					<tr style="color:#AB0000">
						<td colspan="2">
							<s:actionmessage />
						</td>
					</tr>

				</table>

			</s:form>
		</div>
		<%@ include
			file="/WEB-INF/jsp/includes/loader.jsp"%>
	</body>
</html>
