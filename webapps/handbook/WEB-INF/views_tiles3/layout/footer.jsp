<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<nav>
	<ul>
		<sec:authentication var="principal" property="principal"></sec:authentication>
		<sec:authorize access="isAuthenticated()">
			<li><span class="menu-box-item-username"><c:out value="${principal.username}"></c:out>  is logging</span><li>
		</sec:authorize>
	</ul>
	
</nav>
