<%@include file="header.jsp" %>

<div class="main-contain">
	<h3>List Article By Tag</h3>
	
	<c:forEach items="${articleList}" var="article">
		<a href="<% out.print(request.getContextPath());%>/article/${article.articleTitleSlug}"><c:out value="${article.articleTitle}"></c:out></a>
		<br>
	</c:forEach>
</div>

<%@include file="footer.jsp" %>
