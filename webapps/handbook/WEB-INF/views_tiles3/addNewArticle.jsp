<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<script src="<c:url value="/resources/ckeditor/ckeditor.js" />" type="text/javascript"></script>


<div class="main-contain">
	<h3 class="title">Aticle > Create a new Article</h3>

	<spring:url value="/article/add" var="actionUrl" />
	<p class="message"><c:out value="${message}"></c:out></p>
	<form class="add-article-form" method="post" action="${actionUrl}">
		<table>
		  <tr>
		    <td	>Title: </td>
		    <td><input autocomplete="name" type="text" size="100" name="articleTitle" value=""/></td>
		  </tr>
		  <tr>
		  	<td>
		  		Tags:
		  	</td>
		    <td>
			    <c:forEach items="${tagList}" var="tag">
			    	<div class="tag-list">
		    			<div class="tag-check">
		    				<input type="checkbox" name="tagIds" value='<c:out value="${tag.tagId}"></c:out>'/>
		    			</div>
		    			<div class="tag-label">
		    				<label>${tag.tagName}</label>
		    			</div>
			    	</div>
			    	
			    </c:forEach>
   			</td>
		  </tr>
		  
		  <%-- <tr>
		    <td>Status: </td>
		    <td>
		    	<select class="input-font" name="statusId">
		    		<c:forEach items="${statusList}" var="status">
		    			<option value="${status.key}">${status.value}</option>
		    		</c:forEach>
		    	</select>
		    </td>
		  </tr> --%>
		  
		  <tr>
		    <td></td>
		    <td>
		    	<textarea name="articleContent" id="editor1"></textarea>
		    </td>
		  </tr>
		  <tr>
		    <td colspan="2" align="right">
		    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		    	<input class="input-font" type="submit" value="Create"/>
		    </td>
		  </tr>
		</table>
	</form>
</div>


<script>
	CKEDITOR.replace( 'editor1' );
</script>

