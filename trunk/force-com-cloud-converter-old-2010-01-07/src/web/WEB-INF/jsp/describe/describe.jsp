<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<head>

    <title>Describe</title>

			<link rel="stylesheet" type="text/css" media="all" href="./css/describe.css" />





</head>



<body>



<h1>Describe: "<s:property value="describeContext.target" />"</h1>











<p>

<s:if test="!showAll">

<a href="<s:url action="describe"><s:param name="showAll" value="'true'" /></s:url>">Show All Field Properties</a> 

</s:if>

<s:if test="showAll">

<a href="<s:url action="describe"><s:param name="showAll" value="'false'" /></s:url>">Show Main Field Properties</a> 

</s:if>



|

<a href="<s:url action="select" />">Select New Object</a> |

<a href="<s:url value="describeWorkbook.xls"></s:url>">Excel</a> |

<s:if test="results.layoutable">

	<a href="<s:url action="layoutsv2"></s:url>">Switch to Layouts</a> |

</s:if> 

<a href="<s:url value="dataTemplateWorkbook.xls" />">Data Template As Excel</a>

</p>





<h2>Object Level Information</h2>



<p><a href="http://www.salesforce.com/us/developer/docs/api/Content/sforce_api_calls_describesobjects_describesobjectresult.htm#topic-title" target="_blank">What do these fields mean?</a></p>



<table>

	<tr>

		<td>Name</td>

		<td><s:property value="results.name" /></td>

	</tr>

	<tr>

		<td>Label</td>

		<td><s:property value="results.label" /></td>

	</tr>

	<tr>

		<td>Plural Label</td>

		<td><s:property value="results.labelPlural" /></td>

	</tr>

	<tr>

		<td>Key Prefix</td>

		<td><s:property value="results.keyPrefix" /></td>

	</tr>

	<tr>

		<td>URL New</td>

		<td><s:property value="results.urlNew" /></td>

	</tr>

	<tr>

		<td>URL Detail</td>

		<td><s:property value="results.urlDetail" /></td>

	</tr>

	<tr>

		<td>URL Edit</td>

		<td><s:property value="results.urlEdit" /></td>

	</tr>

</table>	



<h2>Fields</h2>



<p><a href="http://www.salesforce.com/us/developer/docs/api/Content/sforce_api_calls_describesobjects_describesobjectresult.htm#i1427375" target="_blank">What do these fields mean?</a></p>



<table>

	<tr>

		<s:iterator value="fields">

			<s:if test="showAll || main">

				<th><s:property value="label" /></th>

			</s:if>

		</s:iterator>		

	</tr>

	<s:iterator value="displayableFields">

		<tr>

			<s:iterator value="properties">

				<s:if test="showAll || sobjectFieldBean.main">

				<s:if test="!multiline">

					<td><s:property value="value" /></td>

				</s:if>

				<s:if test="multiline">

					<td>

						<s:iterator value="multilineValue" status="rowstatus"><s:property /><s:if test="!#rowstatus.last"><br /></s:if></s:iterator>

					</td>

				</s:if>

				</s:if>

			</s:iterator>

		</tr>

	</s:iterator>

</table>



<h2>Record Types</h2>



<table>

	<tr>

		<th>Id</th>

		<th>Name</th>

		<th>Available</th>

		<th>Default?</th>

	</tr>

	<s:iterator value="results.recordTypeInfos">

		<tr>

			<td><s:property value="recordTypeId" /></td>

			<td><s:property value="name" /></td>

			<td><s:property value="available" /></td>

			<td><s:property value="defaultRecordTypeMapping" /></td>

		</tr>

	</s:iterator>

</table>



</body>

</html>