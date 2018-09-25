<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="main-contain">
	<h3>List Tag</h3>
	
	<div>
		<ul>
			<c:forEach items="${tagList}" var="tag">
				<li class="tag"><a href="<c:url value="/tag/${tag.tagNameSlug}" />"><c:out value="${tag.tagName}"></c:out></a></li>
			</c:forEach>
		</ul>
	</div>
</div>


