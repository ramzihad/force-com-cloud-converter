<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>MM Events</title>



</head>

<body>

<h1>MM Events</h1>

<s:form action="mmevents.action">
    <s:textfield label="Start (YYYY-MM-DD)" key="dateStart"/>
    <s:textfield label="End (YYYY-MM-DD)" key="dateEnd"/>
    <s:select label="Hours Sub Type" key="subType" list="#{'Billable Hours':'Billable Hours','Billable Travel Time':'Billable Travel Time'}" />
    <s:textfield label="Opportunity Like" key="opportunityLike"/>
    <s:textfield label="Billable Detail Like" key="billableDetailLike"/>    
    <s:submit name="submit" />
</s:form>

<s:if test="eventsContext.events != null">
<p><a href="mmeventsMultiple.xls">Excel (Multiple Tabs)</a> | <a href="mmeventsSingle.xls">Excel (Single Tab)</a></p>
</s:if>

<table>
	<tr>
		<th>Opportunity</th>
		<th>Owner</th>
		<th>Date</th>
		<th>Sub Type</th>
		<th>Billable Detail</th>
		<th>Duration In Minutes</th>
		<th>Duration In Hours</th>		
		<th>Description</th>
	</tr>
	
	<s:iterator value="results">
		<tr>
			<td><s:property value="opportunity" /></td>
			<td><s:property value="username" /></td>
			<td><s:property value="date" /></td>			
			<td><s:property value="subtype" /></td>
			<td><s:property value="billableDetail" /></td>
			<td><s:property value="durationMinutes" /></td>			
			<td><s:property value="durationHours" /></td>						
			<td><s:property value="description" /></td>			
		</tr>	
	</s:iterator>
</table>

</body>
</html>