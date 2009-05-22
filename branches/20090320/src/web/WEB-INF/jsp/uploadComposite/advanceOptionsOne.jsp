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
		<s:form action="importOptionsOne" method="POST">
			<a href="backToOptionsOne.action">Back</a>
			<s:submit value="Next" />
			<br />
			<br />
			<s:iterator value="advanceOptionsWrapperBeans" 
			var="optionOneBean" status="parentStatus">
				
				<h3><s:property value="sheet" /> </h3>
				<table border="1">
	
					<tr><td>
						<b>Field Name</b>
					</td><td>
						<b>Field Label</b>
					</td><td>
						<b>Data Type</b>
					</td>
					
					<s:iterator value="#optionOneBean.advanceOptionsBeans" status="status">
						 <s:if test="#status.index==1">	
						 	<s:iterator value="advanceOptionsWrapperBeans[#parentStatus.index].advanceOptionsBeans[#status.index].data">
									<td><b>Example</b></td>
							</s:iterator>
						</s:if>
					</s:iterator>
					</tr>
					
					<s:iterator value="#optionOneBean.advanceOptionsBeans" var="bean"  status="status">
						<tr>
							<td>
								<s:property value="name" />
							</td>
							<td>
								<s:textfield
									id="advanceOptionsWrapperBeans[%{#parentStatus.index}].advanceOptionsBeans[%{#status.index}].label"
									name="advanceOptionsWrapperBeans[%{#parentStatus.index}].advanceOptionsBeans[%{#status.index}].label"
									value="%{advanceOptionsWrapperBeans[#parentStatus.index].advanceOptionsBeans[#status.index].label}"
									theme="simple" />
							
							</td>
							<td>
								<s:select list="fieldTypes" listKey="id" listValue="value"
									theme="simple" name="advanceOptionsWrapperBeans[%{#parentStatus.index}].advanceOptionsBeans[%{#status.index}].type"
									value="%{advanceOptionsWrapperBeans[#parentStatus.index].advanceOptionsBeans[#status.index].type}" />
							</td>
							
							<s:iterator value="advanceOptionsWrapperBeans[#parentStatus.index].advanceOptionsBeans[#status.index].data" var="d">
								<td>${d}</td>
							</s:iterator>
							
							
						</tr>
					</s:iterator>
				</table>
				<br/><br/>
			</s:iterator>
			<s:submit value="Next" />
		</s:form>

			<br />
			<br />
			<a href="backToOptionsOne.action">Back</a>
		
	</body>
</html>

