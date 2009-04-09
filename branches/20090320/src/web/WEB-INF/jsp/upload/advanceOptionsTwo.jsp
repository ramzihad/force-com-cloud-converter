<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>

<html>
	<head>
		<title>Advance Options</title>
		<script type="text/javascript" charset="UTF-8"
			src="js/jquery-1.3.1.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$("select.salesforceObjects").change(function() {
					var parent = $(this).parent().parent();
					parent.find("img.loader").css('display','');
					$.getJSON("loadObjectFields.action",{id: $(this).val()}, function(j){
				    	var options = '';
				    	for (var i = 0; i < j.length; i++) {
				        	options += '<option value="' + j[i].value + '">' + j[i].value + '</option>';
				      	}
				      	parent.find("select.objectFields").html(options);
				      	parent.find("img.loader").css('display','none');
				    })
				});
			});
		</script>
	</head>

	<body>
		<h3>
			Advance Options page 2
		</h3>
		<s:form action="checkExistance" method="POST" theme="simple">
			<a href="init.action">Back</a>
				<s:submit value="Next" theme="simple"/>
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
						<s:iterator value="externalIds" var="advBean" status="status">
						
						<tr>
							<td>
								${advBean.label}
							</td>
							<td>
								<s:select list="uniques" listKey="id" listValue="value"
									theme="simple" name="externalIds[%{#status.index}].unique"
									value="%{externalIds[#status.index].unique}" />
	
							</td>
						</tr>
						</s:iterator>
					</table>
					<br />
					<br />
			</s:if>
		
		<br />
		
			<s:if test="%{foundLookup}">
				Lookup Field Settings
				<table border="1">
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
					
					<s:iterator value="lookups" var="advBean" status="status">
					<tr>
						<td>
							${advBean.label}
						</td>
						<td>
							<s:select cssClass="salesforceObjects" list="salesforceObjects" listKey="id" listValue="value"
								theme="simple" name="lookups[%{#status.index}].objectSource"
								value="%{lookups[#status.index].objectSource}" />
							<img class="loader" style="display: none;" src="./img/loading.gif"/>
						</td>
						<td>
							<select name="objectFields" class="objectFields"></select>
						</td>
					</tr>
					</s:iterator>
					
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

