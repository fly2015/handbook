<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="  <% out.print(request.getContextPath());%>/resources/css/stylesheet.css">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<header>
			<nav>
				<ul>
					<li><a href="<% out.print(request.getContextPath());%>/">Home</a></li>
					<li><a href="<% out.print(request.getContextPath());%>/login">Login</a></li>
					<li><a href="<% out.print(request.getContextPath());%>/">Register</a></li>
					<li><a href="<% out.print(request.getContextPath());%>/help">Find help	</a></li>
				</ul>
			</nav>
		</header>
		<hr>