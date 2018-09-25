<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<div class="main-contain">
	<h3>List Article By Tag</h3>
	
	<div>
		<ul>
			<c:forEach items="${articleList}" var="article">
				<li><a href="<c:url value="/article/${article.articleTitleSlug}"/> "><c:out value="${article.articleTitle}"></c:out></a></li>
			</c:forEach>	
		</ul>
	</div>
</div>

