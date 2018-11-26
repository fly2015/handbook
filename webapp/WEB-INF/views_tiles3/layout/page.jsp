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
		
		<sec:authorize access="hasRole('ADMIN')">
			<div class="sub-menu">
				<div class="sub-menu-content">
					<nav class="sub-menu-article disabled">
						<ul>
							<li><a href="manage/account/visible">Visible articles</a></li>
							<li><a href="manage/account/invisible">Invisible articles</a></li>
						</ul>
					</nav>
					
					<nav class="sub-menu-comment disabled">
						<ul>
							<li><a href="manage/comment/visible">Visible comments</a></li>
							<li><a href="manage/comment/invisible">Invisible comments</a></li>
						</ul>
					</nav>
					
					<nav class="sub-menu-tag disabled">
						<ul>
							<li><a href="manage/tag/visible">Visible tags</a></li>
							<li><a href="manage/tag/invisible">Invisible tags</a></li>
						</ul>
					</nav>
					
					<nav class="sub-menu-account disabled">
						<ul>
							<li><a href="manage/account/activated">Activated accounts</a></li>
							<li><a href="manage/account/inactivated">Inactivated accounts</a></li>
						</ul>
					</nav>
					
					<nav class="sub-menu-your-account">
						<ul>
							<li><a href="#">Your approved articles</a></li>
							<li><a href="#">Your unapproved articles</a></li>
							<li><a href="#">Your approved comments</a></li>
							<li><a href="#">Your unapproved comments</a></li>
						</ul>
					</nav>
					
				</div>
			</div>
		</sec:authorize>

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