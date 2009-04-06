<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Sign On</title>

</head>

<body>

<h1>Set your target salesforce.com org</h1>

<p>Note: If using this for layouts, and you login as the org's system admin, 
the utility will not return accurate field "editable" information.  You should 
login as a normal user with API access.</p>

<s:if test="message != null">
	<h2><s:property value="message" /></h2>
</s:if>

<s:form action="login.action">
    <s:textfield label="username" key=" username"/>
    <s:password label="password" key="password" />
    <s:select label="version" key="version" list="#{'10.0':'10.0', '11.0':'11.0', '12.0':'12.0', '13.0':'13.0', '14.0':'14.0'}" />
    <s:select label="stage" key="stage" list="#{'test':'Sandbox','www':'Production'}" />
    <s:submit name="submit" />
</s:form>

<h2>Release Notes</h2>

<ul>
<li>9/6/07 - changed the layouts function to include more detail about read-only fields, required fields, etc.</li>
</ul>

<h2>Future To Do List</h2>

<ul>
<li>In your next enhancement,  can you please include the feature of showing the sections and the fields associated with each section.</li>
<li>Include way to generate a per object row count</li>
</ul>
</body>
</html>