<%@page import="handbook.constant.Pagination"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="customtld" prefix="cfn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="main-contain">
	<h3 class="title">User > Bookmark of articles</h3>
	
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
	
	<c:if test="${numberOfPages ne null && page ne null}">
		<c:set var="numberOfPages" value="${numberOfPages}"/>
		<c:set var="pageIndex" value="${page}"/>
		
		<div class="pagination-section">
			<div class="pagination">
				
				 <c:if test="${numberOfPages > 0 && pageIndex > 1}">
					<a href="articles/${pageIndex - 1}">&laquo;</a>
				 </c:if>	
				  
				  <c:forEach begin="1" end="${numberOfPages}" varStatus="page">
				  		<a href="articles/${page.count}"><c:out value="${page.count}"></c:out> </a>
				  </c:forEach>
				  
				  <c:if test="${numberOfPages > 0 && pageIndex < numberOfPages - 1 }">
					<a href="articles/${pageIndex + 1}">&raquo;</a>
				  </c:if>
				  
			</div>
		</div>
	</c:if>
    
		
</div>

