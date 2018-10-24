<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<div class="main-contain">
	<h3><c:out value="${article.articleTitle}"></c:out></h3>
	
	<p>
		${article.articleContent}
	</p>
</div>


