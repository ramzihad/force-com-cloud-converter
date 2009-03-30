<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>

<html>
	<head>
		<title>View</title>
	</head>

	<body>
		<h3>
			View Excel Info
		</h3>
		<table border="1">
			<tr style="background-color: #CCCCCC">
				<s:iterator value="bean.names" var="name">
					<td>
						${name}
					</td>
				</s:iterator>
			</tr>
			<tr style="background-color: #EDF3EE">
				<s:iterator value="bean.types" var="type">
					<td>
						${type}
					</td>
				</s:iterator>
			</tr>

			<s:iterator value="bean.objects" var="object">
				<tr>
					<s:iterator value="object" var="value">
						<td>${value}</td>
					</s:iterator>
				</tr>
			</s:iterator>
		</table>
		<br />
		<a href="init.action">Back</a>
	</body>
</html>
