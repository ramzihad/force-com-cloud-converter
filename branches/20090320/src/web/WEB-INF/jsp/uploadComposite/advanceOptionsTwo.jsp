
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>

<html>
	<head>
		<title>Advance Options 2</title>
		
	</head>

	<body>
		<h3>
			Advance Options page 2
		</h3>
		<s:form action="importOptionsTwo" method="POST" id="advForm"
			disabled="disabled" theme="simple">
			<a href="backToPageOne.action">Back</a>
			<s:submit value="Next" />


			<br />
			<br />
			<s:iterator value="lookupIdWrapperList" var="lookupIdWrapper"
				status="parentStatus">

				<b>Object ${parentStatus.index+1}</b>
				<br />
				<br />
				External ID Settings
				<br />
				<table border="1">
					<tr>
						<td>
							Field
						</td>
						<td colspan="2">
							Unique
						</td>
					</tr>
					<s:iterator value="#lookupIdWrapper.externalIds"
						var="externalIdBean" status="statusId">

						<tr>
							<td>
								${externalIdBean.name}
							</td>
							<td>
								<s:select list="uniques" listKey="id" listValue="value"
									theme="simple"
									name="lookupIdWrapperList[%{#parentStatus.index}].externalIds[%{#statusId.index}].unique"
									value="%{lookupIdWrapperList.[#parentStatus.index].externalIds[#statusId.index].unique}" />

							</td>
						</tr>
					</s:iterator>
				</table>
				<br />
				<br />
			</s:iterator>
		</s:form>

		<br />
		<br />
		<a href="backToPageOne.action">Back</a>

	</body>
</html>

