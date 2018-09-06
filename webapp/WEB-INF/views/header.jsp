<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<% out.print(request.getContextPath());%>/resources/css/stylesheet.css">
<title>Insert title here</title>
<c:set var="pageUrl" value="${pageContext.request.contextPath}"></c:set>
</head>
<body>
	<div id="container">
		<header>
			<nav>
				<div class="nav-left">
					<ul>
						<li><a href="${pageUrl}/">Home</a></li>
						<li><a href="${pageUrl}/tag">Tags</a></li>
					</ul>
				</div>
				<div class="nav-middle">
					<form action="header_submit" method="get" accept-charset="utf-8">
						<input type="text" value="">
						<input type="button" name="Search" value="Search">
					</form>			
				</div>
				<div class="nav-right">
					<ul>
						<sec:authentication var="principal" property="principal"></sec:authentication>
						<sec:authorize access="isAuthenticated()">
							<c:out value="${principal.username}"></c:out>
						</sec:authorize>
						<li><a href="${pageUrl}/login">Login</a></li>
						<li><a href="${pageUrl}/register">Register</a></li>
						<li><a href="${pageUrl}/logout">Logout</a></li>
					</ul>
				</div>
			</nav>
		</header>
		<hr>