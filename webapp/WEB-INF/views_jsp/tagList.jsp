<%@include file="header.jsp" %>

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

<%@include file="footer.jsp" %>
