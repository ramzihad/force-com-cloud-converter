<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>

<html>
	<head>
		<title>Advance Options</title>
	</head>

	<body>
		<h3>
			Advance Options page 2
		</h3>
		<s:form action="checkExistance" method="POST">
			<a href="init.action">Back</a>
			<s:submit value="Next" />
			<br />
			<br />
			<s:if test="%{foundExternalId}">
			External ID Settings
			<br />
				<table border="1">
					<tr>
						<td>
							Field
						</td>
						<td>
							Unique
						</td>
					</tr>
					<tr>
						<td>
							Field Label
						</td>
						<td>
							<select name="externalIdUnique" >
								<option value="true">
									true
								</option>
								<option value="false">
									false
								</option>
							</select>
						</td>
					</tr>
				</table>
				<br />
				<br />
			</s:if>
		
		<br />
		
			<s:if test="%{foundLookup}">
				Lookup Field Settings
				<table>
					<tr>
						<td>
							Field
						</td>
						<td>
							Source Object
						</td>
						<td>
							Source Field
						</td>
					</tr>
					<tr>
						<td>
							Field Label
						</td>
						<td>
							Source Object
						</td>
						<td>
							Source Field
						</td>
					</tr>
				</table>
			</s:if>
			<br />
			<br />


		</s:form>



		<br />
		<br />
		<a href="init.action">Back</a>

	</body>
</html>

