<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>



<html>

	<head>

		<title>Advanced Options: Labels & Data Types</title>

	</head>



	<body>

		<h1>Advance Options: Verify Field Names and Data Types</h1>

		

		

		<s:form action="importOptionsOne" method="POST">

			<p><s:submit name="submit" value="Back" />	
			<s:submit name="submit" value="Next" /></p>

			

			<p><s:iterator value="advanceOptionsWrapperBeans" var="optionOneBean" status="parentStatus"></p>

				

				<h3><s:property value="sheet" /> </h3>

				<table border="1">

	

					<tr>

						<th>Name</th>

						<th>Label</th>

						<th>Type</th>

						<th>External ID?</th>

						<th>Example</th>



					</tr>

					

					<s:iterator value="#optionOneBean.advanceOptionsBeans" var="bean"  status="status">

						<tr>

							<td><s:property value="name" /></td>

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

							<td>

							<s:checkbox

									id="advanceOptionsWrapperBeans[%{#parentStatus.index}].advanceOptionsBeans[%{#status.index}].externalId"

									name="advanceOptionsWrapperBeans[%{#parentStatus.index}].advanceOptionsBeans[%{#status.index}].externalId"

									fieldValue="true"

									value="%{advanceOptionsWrapperBeans[#parentStatus.index].advanceOptionsBeans[#status.index].externalId}"

									theme="simple" />

							</td>

							

							<s:if test="advanceOptionsWrapperBeans[#parentStatus.index].advanceOptionsBeans[#status.index].data.size > 0">

								<td><s:property value="advanceOptionsWrapperBeans[#parentStatus.index].advanceOptionsBeans[#status.index].data.get(0)" /></td>
							</s:if>
<s:else>
<td>&nbsp;</td>
</s:else>

							

							

						</tr>

					</s:iterator>

				</table>

				<br/><br/>

			</s:iterator>

			<s:submit name="submit" value="Back" />	

			<s:submit name="submit" value="Next" />

		</s:form>





		

	</body>

</html>



