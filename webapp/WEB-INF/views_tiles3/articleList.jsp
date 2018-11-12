<%@page import="handbook.constant.Pagination"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="customtld" prefix="cfn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="main-contain">
	<h3><span>>> </span>List of Articles</h3>
	
	<div class="article-list">
		<c:forEach items="${articleList}" var="article" varStatus="theCount">
			<div class="article-item">
				<a href="<c:url value="/article/${article.articleTitleSlug}"/> ">
					<span class="artile-list-item">${cfn:formatArticleIndex(article.articleId)}. </span>
					<c:out value="${article.articleTitle}"></c:out>
				</a>
			</div>
		</c:forEach>
	</div>
	
	
	<c:set var="totalCount" scope="session" value="${numOfArticles}"/>
    <c:set var="perPage" scope="session" value="${Pagination.NUMBER_OF_ITEM_ARTICLES_PAGE}"/>
    <c:set var="totalPages" scope="session" value="${totalCount/perPage}"/>
	
	<c:set var="pageIndex" scope="session" value="${page}"/>
	
	<div class="pagination-section">
		<div class="pagination">
			
			 <c:if test="${totalPages > 0 && pageIndex > 1}">
				<a href="${pageIndex - 1}">&laquo;</a>
			 </c:if>	
			  
			  
			  <c:forEach begin="1" end="${totalPages}" varStatus="page">
			  		<a href="<spring:url value="/"/>articles/${page.count}"><c:out value="${page.count}"></c:out> </a>
			  </c:forEach>
			  
			  <c:if test="${totalPages > 0 && pageIndex < totalPages - 1 }">
				<a href="${pageIndex + 1}">&raquo;</a>
			  </c:if>
			  
		</div>
	</div>
		
</div>

