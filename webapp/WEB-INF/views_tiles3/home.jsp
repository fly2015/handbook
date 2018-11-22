<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="customtld" prefix="cfn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="main-contain">
	
	<h3 class="title">Article > Search Form</h3>
	<div class="top-article top-use-article">
	<sec:authorize access="hasRole('USER') or hasRole('ADMIN')">
		<c:url var="actionUrl" value="articles/search"></c:url>
		<form action="${actionUrl}" method="GET" accept-charset="utf-8">
			<input size="40" type="text" name="keyword"> <input
				class="input-font" type="submit" value="Search">
		</form>
	</sec:authorize>
	</div>
	
	<br>
	<h3 class="title">Search > Result</h3>
	<div class="top-article top-use-article">
		<c:forEach items="${topUserfulArticles}" var="article" varStatus="theCount">
			<div class="article-item">
				<a href="<c:url value="/article/${article.articleTitleSlug}"/> ">
					<span class="artile-list-item">${cfn:formatArticleIndex(article.articleId)}. </span>
					<c:out value="${article.articleTitle}"></c:out>
				</a>
			</div>
		</c:forEach>
	</div>
	
	<%-- <h3 class="title">Home > Useful articles</h3>
	<div class="top-article top-use-article">
		<c:forEach items="${topUserfulArticles}" var="article" varStatus="theCount">
			<div class="article-item">
				<a href="<c:url value="/article/${article.articleTitleSlug}"/> ">
					<span class="artile-list-item">${cfn:formatArticleIndex(article.articleId)}. </span>
					<c:out value="${article.articleTitle}"></c:out>
				</a>
			</div>
		</c:forEach>
	</div> --%>

	
	<%-- <h3 class="title">Home > Newest articles</h3>
	<div class="top-article top-newest-article">
		<c:forEach items="${topNewestArticles}" var="article" varStatus="theCount">
			<div class="article-item">
				<a href="<c:url value="/article/${article.articleTitleSlug}"/> ">
					<span class="artile-list-item">${cfn:formatArticleIndex(article.articleId)}. </span>
					<c:out value="${article.articleTitle}"></c:out>
				</a>
			</div>
		</c:forEach>
	</div> --%>
</div>
