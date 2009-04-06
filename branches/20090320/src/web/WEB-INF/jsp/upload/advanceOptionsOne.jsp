
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
			<s:submit value="Next" />
			<br />
			<br />
			<table border="1">

				<tr><td>
					<b>Field Name</b>
				</td><td>
					<b>Field Label</b>
				</td><td>
					<b>Data Type</b>
				</td>
				<s:iterator value="advanceOptionsBeans" status="status">
					 <s:if test="${status.index==1}">	
					 	<s:iterator value="advanceOptionsBeans[#status.index].data">
								<td>Example</td>
						</s:iterator>
					</s:if>
				</s:iterator>
				
				</tr>

				<s:iterator value="advanceOptionsBeans" var="bean" status="status">
					<tr>
						<td>
							${bean.name}
						</td>
						<td>
							
							
							<s:textfield
								id="advanceOptionsBeans[%{#status.index}].label"
								name="advanceOptionsBeans[%{#status.index}].label"
								value="%{advanceOptionsBeans[#status.index].label}"
								theme="simple" />
						
						</td>
						<td>
							<s:select list="fieldTypes" listKey="id" listValue="value"
								theme="simple" name="advanceOptionsBeans[%{#status.index}].type"
								value="%{advanceOptionsBeans[#status.index].type}" />
						</td>
						
						<s:iterator value="advanceOptionsBeans[#status.index].data" var="d">
							<td>${d}</td>
						</s:iterator>
						
						
					</tr>
				</s:iterator>
			</table>
			<s:submit value="Next" />
		</s:form>


				<%--<tr style="background-color: #CCCCCC">
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
				
			</table>--%>
			<br />
			<br />
			<a href="init.action">Back</a>
		
	</body>
</html>

