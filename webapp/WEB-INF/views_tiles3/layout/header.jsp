<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<header>
	<nav>
		<div class="nav-left">
			<ul>
				<li><a href="<c:url value="/" />">Home</a></li>
				<li><a href="<c:url value="/tags" />">Tags</a></li>
				<sec:authorize access="hasRole('ADMIN')">
					<li><a href="<c:url value="/tag/add" />">+ Tag</a></li>
					<li><a href="<c:url value="/article/add" />">+ Article</a></li>
				</sec:authorize>
				<li><a href="<c:url value="/" />">Articles</a></li>
				<li><a href="<c:url value="/" />">Top 10</a></li>
			</ul>
		</div>
		<div class="nav-middle">
			<c:url var="actionUrl" value="/search"></c:url>
			<form action="${actionUrl}" method="get" accept-charset="utf-8">
				<input size="30" type="text" name="keyword"> <input
					type="submit" value="Search">
			</form>
		</div>
		<div class="nav-right">
			<ul>
				<sec:authentication var="principal" property="principal"></sec:authentication>

				<sec:authorize access="isAuthenticated()">
					<li><c:out value="${principal.username}"></c:out><li>
					<li><a href="<c:url value="/" />">Your post</a></li>
					<li><a href="<c:url value="/logout" />">Logout</a></li>
				</sec:authorize>

				<sec:authorize access="!isAuthenticated()">
					<li><a href="<c:url value="/login" />">Login</a></li>
					<li><a href="<c:url value="/register" />">Register</a></li>
				</sec:authorize>
			</ul>
		</div>
	</nav>
	<div>
	</div>
</header>
<hr>