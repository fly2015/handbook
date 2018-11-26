<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="customtld" prefix="cfn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="main-contain">
	
	<h3 class="title">Article > Useful articles</h3>
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

</div>
