<%@include file="header.jsp" %>
<div class="main-contain">
	<h3>Article Detail</h3>
	
	<p>
		<c:out value="${article.articleTitle}"></c:out>
	</p>
	<textarea>
		${article.articleContent}
	</textarea>
</div>

<%@include file="footer.jsp" %>
