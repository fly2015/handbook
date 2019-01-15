<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page session="false"%>	
<!DOCTYPE html">
<html>
<head>
<base href="<spring:url value="/" />"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/stylesheet.css">
<script src="resources/js/jquery/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="resources/js/style.js" type="text/javascript"></script>

<title>Let's make life easier</title>

</head>
<body>
	<div id="container">
		<div id="header">
			<t:insertAttribute name="header" />
		</div>
				
		<div id="content">
			<t:insertAttribute name="body" />
		</div>
		
		<div id="footer">
			<t:insertAttribute name="footer" />
		</div>
	</div>
</body>
</body>
</html>