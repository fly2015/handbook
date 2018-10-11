<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="hng">
<meta name="author" content="hng">
<title>Let's make game harder</title>

<!-- Bootstrap Core CSS -->
<link href="<spring:url value="/resources/sb2/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type="text/css">

<!-- MetisMenu CSS -->
<link href="<spring:url value="/resources/sb2/vendor/metisMenu/metisMenu.min.css" />" rel="stylesheet" type="text/css">

<!-- Custom CSS -->
<link href="<spring:url value="/resources/sb2/dist/css/sb-admin-2.css" />" rel="stylesheet" type="text/css">

<!-- Morris Charts CSS -->
<link href="<spring:url value="/resources/sb2/vendor/morrisjs/morris.css" />" rel="stylesheet" type="text/css">

<!-- Custom Fonts -->
<link href="<spring:url value="/resources/sb2/vendor/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

</head>
<body>
	
	<t:insertAttribute name="loginPage" />
	<div id="wrapper">
	
		<%-- <t:insertAttribute name="header" /> --%>
		<!-- Page Content -->
		<div id="page-wrapper">
			
			<%-- <t:insertAttribute name="body" /> --%>
		</div>
		<!-- /#page-wrapper -->
		
	</div>
	
	
	<%-- <script src="<spring:url value="/resources/js/jquery/jquery-3.3.1.min.js" />" type="text/javascript"></script> --%>
	
	<!-- jQuery -->
	<script src="<spring:url value="/resources/sb2/vendor/jquery/jquery.min.js" />" type="text/javascript"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<spring:url value="/resources/sb2/vendor/bootstrap/js/bootstrap.min.js" />" type="text/javascript"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<spring:url value="/resources/sb2/vendor/metisMenu/metisMenu.min.js" />" type="text/javascript"></script>

    <!-- Morris Charts JavaScript -->
    <script src="<spring:url value="/resources/sb2/vendor/raphael/raphael.min.js" />" type="text/javascript"></script>
    <script src="<spring:url value="/resources/sb2/vendor/morrisjs/morris.min.j" />" type="text/javascript"></script>
    <script src="<spring:url value="/resources/sb2/data/morris-data.js" />" type="text/javascript"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<spring:url value="/resources/sb2/dist/js/sb-admin-2.js" />" type="text/javascript"></script>
	
</body>
</body>
</html>