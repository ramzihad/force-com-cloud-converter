<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Migrate Utility</title>
</head>

<body>

<h1>NEW! Migrate A Field - Setup</h1>

<p>If you haven't used this before, you should use it on a dev org or in your sandbox first to get used to it.</p>

<p>This is an aggressive routine.  It will go through every object record in the org.  If you have a million records of the object you're working with, it will attempt to do that.</p>

<p><s:actionmessage /></p>

<s:form action="migrateSetup.action">

<p>Preview Field: <s:select label="Preview Field"
       name="previewField"
       list="fields"
       listKey="name"
       listValue="label + ' (' + name + ')'" emptyOption="true"
       required="true"
/></p>

<p>Source Field: <s:select label="Source Field"
       name="sourceField"
       list="fields"
       listKey="name"
       listValue="label + ' (' + name + ')'" emptyOption="true"
       required="true"
/></p>

<p>Target Field: <s:select label="Target Field"
       name="targetField"
       list="fields"
       listKey="name"
       listValue="label + ' (' + name + ')'" emptyOption="true"
       required="true"
/></p>

<p>Conflict Resolution: <s:select label="Conflict Resolution"
       name="resolution"
       list="conflictResolutionTypes"
       listKey="name"
       listValue="name"  emptyOption="true"
       required="true"
/></p>

<p>Source Disposition: <s:select label="Source Disposition"
       name="disposition"
       list="sourceDispositionTypes"
       listKey="name"
       listValue="name"  emptyOption="true"
       required="true"
/></p>

<p>Update Batch Size: <s:textfield label="Update Batch Size" key="updateBatchSize"/></p>

<p>Concatenator: <s:textfield label="Concatenator" key="concatenator"/></p>


<s:submit name="submit" />

</s:form>



</body>
</html>