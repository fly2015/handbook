<%@include file="header.jsp" %>

<div class="main-contain">
	<p>Make your file become easier	!</p>
	<h3>List Tag</h3>
	<c:forEach items="${tagList}" var="tag">
		<a href="<% out.print(request.getContextPath());%>/${tag.tagName}"><c:out value="${tag.tagName}"></c:out></a>
		<br>
	</c:forEach>
		
</div>

<%@include file="footer.jsp" %>
