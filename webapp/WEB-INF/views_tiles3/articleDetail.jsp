<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="main-contain">
	<div class="article-section">
		<h3><c:out value="${article.articleTitle}"></c:out></h3>
		<p>
			${article.articleContent}
		</p>
	</div>
	
	<sec:authorize access="hasRole('ADMIN')">
		<div class="comment-section">
			<form action="#" id="usrform">
				<textarea name="content" rows="8" cols="80"></textarea>
			  	
			  	<div class="btn-comment-section">
			  		<input class="btn-comment	" type="submit" name="" value="Comment">
			  	</div>
			  	
			</form>
		</div>
	</sec:authorize>
	
</div>


