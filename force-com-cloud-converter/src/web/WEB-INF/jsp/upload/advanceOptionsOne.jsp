<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>

<html>
	<head>
		<title>Advance Options</title>
	</head>

	<body>
		<h3>
			Advance Options page 1
		</h3>
		<br />
		<br />
		You may modify the excel information or you may continue as it is.
		<br />
		<br />
		<s:form action="checkExistance" method="POST">
			<a href="init.action">Back</a>
			<s:submit value="Continue" />
			<br />
			<br />
			<table border="1">
				<tr style="background-color: #CCCCCC">
					<td>
						<b>Field Name</b>
					</td>
					<s:iterator value="uploadContext.wrapperBean.names" var="name">
						<td>
							${name}
						</td>
					</s:iterator>
				</tr>
				<tr style="background-color: #75908D">
					<td>
						<b>Field Label</b>
					</td>
					<s:iterator value="uploadContext.wrapperBean.labels"
						status="status">
						<td>
							<s:textfield
								id="uploadContext.wrapperBean.labels[%{#status.index}]"
								name="uploadContext.wrapperBean.labels[%{#status.index}]"
								value="%{uploadContext.wrapperBean.labels[#status.index]}"
								theme="simple" />
						</td>
					</s:iterator>
				</tr>
				<tr style="background-color: #EDF3EE">
					<td>
						<b>Field Type</b>
					</td>
					<s:iterator value="uploadContext.wrapperBean.types" status="status">
						<td>
							<s:select list="fieldTypes" listKey="id" listValue="value"
								theme="simple"
								value="%{uploadContext.wrapperBean.types[#status.index]}" />

						</td>
					</s:iterator>

				</tr>

				<s:iterator value="uploadContext.wrapperBean.objects" var="object">

					<tr>
						<td width="70px" style="background-color: #CCCCCC">
							<b>Example</b>
						</td>
						<s:iterator value="object" var="value">
							<td>
								${value}
							</td>
						</s:iterator>
					</tr>
				</s:iterator>
			</table>
			<br />
			<br />
			<a href="init.action">Back</a><s:submit value="Continue" />
		</s:form>
	</body>
</html>

