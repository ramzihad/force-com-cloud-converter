<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

    <%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
    <html>
        <head>
            <title><decorator:title default="Welcome!" /> - Model Metrics' Cloud Converter & Force.com Platform Utilities</title>
			<link rel="stylesheet" href="https://na4.salesforce.com/sCSS/15.0/1238015590000/Theme2/common.css" />
            <decorator:head />
        </head>
        <body>
		
		<div id="puHeader" style="float:left; text-align: center;"><a href="http://www.modelmetrics.com/solutions/cloudconverter/" target="_blank"><img src="./img/logo_cloudconverter_white.gif" /></a><br/><a href="http://www.modelmetrics.com/solutions/cloudconverter/" target="_blank">Cloud Converter from Model Metrics</a></div>
		
		<div id="puHeader2" style="float:right; text-align: center;"><a href="http://modelmetrics.com" target="_blank"><img src="./img/mmlogo.jpg" /></a><br/><a href="http://modelmetrics.com" target="_blank">Platform Utilities from Model Metrics</a></div>

		<div id="puMain" style="clear: both">
			<p>&nbsp;</p>        
            <decorator:body />
            
        </div>

        <div id="puFooter" style="font-size: 75%; color: #000066; clear: both">
        
        <p class="footer">Questions? Comments? <a href="http://community.salesforce.com/sforce/?category.id=developers">Join the conversation.</a></p>
       <p class="footer">
       	Version: August 28, 2009 - Profile (mb):
       	
       	<%
       	
       		Runtime r = Runtime.getRuntime();
       		out.println("Free: " + (r.freeMemory() / 1024 / 1024));
			out.println("Total: " + (r.totalMemory() / 1024 / 1024));
       		out.println("Max: " + (r.maxMemory() / 1024 / 1024));

       		
       	%>
       </p>
       </div>
       
<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-8160326-1");
pageTracker._trackPageview();
} catch(err) {}</script>

        </body>
    </html>