<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="main-contain">
	<h3>List Tag</h3>
	<c:forEach items="${tagList}" var="tag">
		<div class="tag">
			<a href="<c:url value="/tag/${tag.tagNameSlug}" />"><c:out value="${tag.tagName}"></c:out></a>
		</div>
	</c:forEach>
</div>


