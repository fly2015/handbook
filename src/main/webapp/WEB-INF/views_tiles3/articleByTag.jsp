<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="customtld" prefix="cfn" %>

<div class="main-contain">
	<h3 class="title">Tag > List of Articles</h3>

	<div class="article-list">
		<c:forEach items="${articleList}" var="article" varStatus="theCount">
			<div class="article-item">
				<a href="<c:url value="/article/${article.articleTitleSlug}"/> ">
					<span class="artile-list-item">${cfn:formatArticleIndex(article.articleId)}. </span>
					<c:out value="${article.articleTitle}"></c:out>
				</a>
			</div>
		</c:forEach>
		
		<c:if test="${empty articleList}">
			<p>There is no article, please add some! Thanks</p>
		</c:if>
	</div>
</div>

