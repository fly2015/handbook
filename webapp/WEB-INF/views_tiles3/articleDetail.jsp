<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script src="resources/ckeditor/ckeditor.js" type="text/javascript"></script>
<script src="resources/js/ajax.js" type="text/javascript"></script>

<div class="main-contain">
	<div class="article-section">
		<h3 class="title">Article > Details	</h3>
		<h3><c:out value="${article.articleTitle}"></c:out></h3>
		<p>
			${article.articleContent}
		</p>
	</div>
	
	<div id="comment">
		<h3>Additional information </h3>
		<c:forEach items="${comments}" var="comment">
			<p>${comment.commentContent}</p>
		</c:forEach>
	</div>
	
	<sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
		<div class="comment-section">
			<form action="" id="commentForm" method="POST">
				<input id="article-id" name="articleId" type="hidden" value="${article.articleId}"/>
				<textarea id="comment-content" name="commentContent"></textarea>
			  	<div class="btn-comment-section">
			  		<input id="csrf" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			  		<input id="btn-comment" type="button" name="" value="Comment">
			  	</div>
			</form>
		</div>
	</sec:authorize>
	
</div>


<script>
	CKEDITOR.replace( 'comment-content' );
</script>
