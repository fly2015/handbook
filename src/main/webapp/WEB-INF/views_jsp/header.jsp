<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
						<li><a href="<c:url value="/" />">Home</a></li>
						<li><a href="<c:url value="/tags" />">Tags</a></li>
						<sec:authorize access="hasRole('ADMIN')">
						 	<li><a href="<c:url value="/tag/add" />">New tag</a></li>
						 	<li><a href="<c:url value="/article/add" />">New article</a></li>
						</sec:authorize>
					</ul>
				</div>
				<div class="nav-middle">
					<c:url var="actionUrl" value="/search"></c:url>
					<form action="${actionUrl}" method="get" accept-charset="utf-8">
						<input size="40" type="text" name="keyword">
						<input type="submit" value="Search">
					</form>			
				</div>
				<div class="nav-right">
					<ul>
						<sec:authentication var="principal" property="principal"></sec:authentication>
						
						<sec:authorize access="isAuthenticated()">
							<li><c:out value="${principal.username}"></c:out><li>
							<li><a href="<c:url value="/logout" />">Logout</a></li>
						</sec:authorize>
						
						<sec:authorize access="!isAuthenticated()">
						    <li><a href="${pageUrl}/login">Login</a></li>
						    <li><a href="<c:url value="/register" />">Register</a></li>
						</sec:authorize>
					</ul>
				</div>
			</nav>
		</header>
		<hr>