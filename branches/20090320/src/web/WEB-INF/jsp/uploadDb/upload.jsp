<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Upload</title>
		<script type="text/javascript" charset="UTF-8" src="js/loader.js"></script>
	</head>

	<body onload="hideLoader()">

		<s:actionerror />
		<s:fielderror />
		<div id="form">
			<s:form action="generate" method="POST">

				<h3>
					Upload Database information
				</h3>

				<table>
					<tr>
						<td>
							Username:
						</td>
						<td>
							<s:textfield name="sfdcUsername" theme="simple"/>
						</td>
					</tr>
					<tr>
						<td>
							Password:
						</td>
						<td>
							<s:password name="sfdcPassword" theme="simple" />
						</td>
					</tr>
					<tr>
						<td>
							Security Token:
						</td>
						<td>
							<s:password name="sfdcSecurityToken"
								theme="simple" />
						</td>
					</tr>
					<tr style="background-color:#9EBDA6">
						<td>
							<b>Database information</b>
						</td>
						<td>
							&nbsp;
						</td>
					</tr>

					<tr>
						<td>
							Database User (*):
						</td>
						<td>
							<s:textfield name="dbUser"  theme="simple"/>
						</td>
					</tr>
					<tr>
						<td>
							Database Password
						</td>
						<td>
							<s:password name="dbPassword"  theme="simple" />
						</td>
					</tr>
					<tr>
						<td>
							Database Type Name (*):
						</td>
						<td>
							<s:textfield name="dbTypeName" theme="simple"/>
						</td>
					</tr>
					<tr>
						<td>
							Database User (*):
						</td>
						<td>
							<s:textfield name="dbDriver"  theme="simple"/>
						</td>
					</tr>
					<tr>
						<td>
							Database Connection (*):
						</td>
						<td>
							<s:textfield name="dbConnection" theme="simple"/>
						</td>
					</tr>
					<tr>
						<td>
							Database Query (*):
						</td>
						<td>
							<s:textfield name="dbSelect"  theme="simple"/>
						</td>
					</tr>
					<tr style="background-color:#9EBDA6">
						<td>
							<b>External Ids</b>
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					<s:iterator value="externalIds" status="status">
						<tr>
							<td>External ID ${status.index}</td>
							<td>
								<s:textfield id="externalIds[%{#status.index}]"
								name="externalIds[%{#status.index}]"
								value="%{externalIds[#status.index]}"  theme="simple"/>
							</td>
						</tr>
					</s:iterator>
					<tr style="background-color:#9EBDA6">
						<td>
							<b>Picklist Fields</b>
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					<s:iterator value="picklistInfos" status="status">
						<tr>
							<td>Picklist ${status.index}</td>
							<td>
								Field name <s:textfield id="picklistInfos[%{#status.index}].fieldName"
								name="picklistInfos[%{#status.index}].fieldName" 
								value="%{picklistInfos[#status.index].fieldName}" theme="simple"/>
							
								Source SQL <s:textfield id="picklistInfos[%{#status.index}].sourceSql"
								name="picklistInfos[%{#status.index}].sourceSql"
								value="%{picklistInfos[#status.index].sourceSql}" theme="simple"/>
							</td>
						</tr>
					</s:iterator>
					<tr style="background-color:#9EBDA6">
						<td>
							<b>Lookup Fields</b>
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					<s:iterator value="lookupSettings" status="status">
						<tr>
							<td>Lookup Field ${status.index}</td>
							<td>
								Local name <s:textfield id="lookupSettings[%{#status.index}].localName"
								name="lookupSettings[%{#status.index}].localName"
								value="%{lookupSettings[#status.index].localName}" theme="simple"/>
								
								Local Relationship Name <s:textfield id="lookupSettings[%{#status.index}].localRelationshipName"
								name="lookupSettings[%{#status.index}].localRelationshipName"
								value="%{lookupSettings[#status.index].localRelationshipName}" theme="simple"/>
								
								Parent Object Name <s:textfield id="lookupSettings[%{#status.index}].parentObjectName"
								name="lookupSettings[%{#status.index}].parentObjectName"
								value="%{lookupSettings[#status.index].parentObjectName}" theme="simple"/>
								
								Parent External Id Name <s:textfield id="lookupSettings[%{#status.index}].parentExternalIdName"
								name="lookupSettings[%{#status.index}].parentExternalIdName"
								value="%{lookupSettings[#status.index].parentExternalIdName}" theme="simple"/>
							</td>
							
						</tr>
					</s:iterator>
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
		<%@ include file="/WEB-INF/jsp/includes/loader.jsp"%>
	</body>
</html>
