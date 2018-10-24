<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<div class="main-contain">
	<h3>List of Articles search by tag</h3>

	<div class="article-list">
		<c:forEach items="${articleList}" var="article">
			<div class="article-item">
				<a href="<c:url value="/article/${article.articleTitleSlug}"/> "><c:out
						value="${article.articleTitle}"></c:out></a>
			</div>
		</c:forEach>
	</div>
</div>

