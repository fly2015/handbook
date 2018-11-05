<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<div class="main-contain">
	<h3><span>>> </span>Top useful articles</h3>
	<div class="top-article top-use-article">
		<c:forEach items="${topUserfulArticles}" var="article" varStatus="theCount">
			<div class="article-item">
				<span>${theCount.count}. </span>
				<a href="<c:url value="/article/${article.articleTitleSlug}"/> "><c:out value="${article.articleTitle}"></c:out></a>
			</div>
		</c:forEach>
	</div>

	
	<h3><span>>> </span>Top newest articles</h3>
	<div class="top-article top-newest-article">
		<c:forEach items="${topNewestArticles}" var="article" varStatus="theCount">
			<div class="article-item">
				<span>${theCount.count}. </span>
				<a href="<c:url value="/article/${article.articleTitleSlug}"/> "><c:out value="${article.articleTitle}"></c:out></a>
			</div>
		</c:forEach>
	</div>
</div>
