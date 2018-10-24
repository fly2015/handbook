<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/stylesheet.css" />">
<script src="<spring:url value="/resources/js/jquery/jquery-3.3.1.min.js" />" type="text/javascript"></script>
<script src="<spring:url value="/resources/js/style.js" />" type="text/javascript"></script>

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