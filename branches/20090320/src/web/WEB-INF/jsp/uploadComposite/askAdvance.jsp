<%@ taglib prefix="s" uri="/struts-tags"%>


<s:form action="importBranch" method="POST"
	enctype="multipart/form-data" theme="simple">

Do you want to configure advance options?
	<br />
	<s:radio list="optionsList" name="selectedOption">
	</s:radio>
	<br />
	<br />
	<s:submit value="Next" />
	<br/>
	<p><s:actionmessage /></p>
</s:form>