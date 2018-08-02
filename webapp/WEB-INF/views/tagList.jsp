<%@include file="header.jsp" %>

<div class="main-contain">
	<h3>List Tag</h3>
	<c:forEach items="${tagList}" var="tag">
		<a href="<% out.print(request.getContextPath());%>/tag/${tag.tagNameSlug}"><c:out value="${tag.tagName}"></c:out></a>
		<br>
	</c:forEach>
		
</div>

<%@include file="footer.jsp" %>
