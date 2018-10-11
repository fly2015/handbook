<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<div class="main-contain">
	<h3>Article Detail</h3>
	
	<p>
		<c:out value="${article.articleTitle}"></c:out>
	</p>
	<textarea>
		${article.articleContent}
	</textarea>
</div>


