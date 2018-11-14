<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<header>
	<nav class="nav-header">
		<div class="nav-left">
			<ul>
				<sec:authorize access="hasRole('ADMIN')">
					<li><a class="menu-home" href="home">Home</a></li>
					<li><a class="menu-tags" href="tags">Tags</a></li>
					<li><a class="menu-articles" href="articles">Articles</a></li>
					<li><a class="menu-add-tag" href="tag/add">+Tag</a></li>
					<li><a class="menu-add-article" href="article/add">+Article</a></li>
				</sec:authorize>
				
				<sec:authorize access="hasRole('USER')">
					<li><a class="menu-home" href="home">Home</a></li>
					<li><a class="menu-tags" href="tags">Tags</a></li>
					<li><a class="menu-articles" href="articles">Articles</a></li>
					<li><a class="menu-add-article" href="article/add">+ Article</a></li>
				</sec:authorize>
				
			</ul>
		</div>
		
		<div class="nav-middle">
			<sec:authorize access="hasRole('USER') or hasRole('ADMIN')">
				<c:url var="actionUrl" value="articles/search"></c:url>
				<form action="${actionUrl}" method="GET" accept-charset="utf-8">
					<input size="30" type="text" name="keyword"> <input
						class="input-font" type="submit" value="Search">
				</form>
			</sec:authorize>
		</div>
		
		<div class="nav-right">
			<ul>
				<sec:authentication var="principal" property="principal"></sec:authentication>

				<sec:authorize access="isAuthenticated()">
					<li>
						<a class="menu-box-item-username" href="<c:url value="/" />"><c:out value="${principal.username}"></c:out></a>
					<li>
					<li><a href="logout">Logout</a></li>
				</sec:authorize>

				<sec:authorize access="!isAuthenticated()">
					<li><a href="login">Login</a></li>
					<li><a href="register">Register</a></li>
				</sec:authorize>
			</ul>
		</div>
	</nav>
	
</header>

