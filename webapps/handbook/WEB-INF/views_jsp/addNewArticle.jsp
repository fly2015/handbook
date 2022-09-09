<%@include file="header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script src="<c:url value="/resources/js/ckeditor/ckeditor.js" />" type="text/javascript"></script>


<div class="main-contain">
	<h4>Add New Article Form</h4>

	<spring:url value="/article/add" var="actionUrl" />
	<p class="message"><c:out value="${message}"></c:out></p>
	<form method="post" action="${actionUrl}">
		<table>
		  <tr>
		    <td>Title: </td>
		    <td><input type="text" size="100" name="articleTitle" value=""/></td>
		  </tr>
		  <tr>
		  	<td>
		  		Tags:
		  	</td>
		    <td>
			    <c:forEach items="${tagList}" var="tag">
			    	<input type="checkbox" name="tagIds" value='<c:out value="${tag.tagId}"></c:out>'/>
   					<label>${tag.tagName}</label>
			    </c:forEach>
   			</td>
		  </tr>
		  
		  <tr>
		    <td>Status: </td>
		    <td>
		    	<select name="statusId">
		    		<c:forEach items="${statusList}" var="status">
		    			<option value="${status.statusId}">${status.statusName}</option>
		    		</c:forEach>
		    	</select>
		    </td>
		  </tr>
		  
		  <tr>
		    <td></td>
		    <td>
		    	<textarea name="articleContent" id="editor1"></textarea>
		    </td>
		  </tr>
		  <tr>
		   	<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
		    <td colspan="2" align="right"><input type="submit" value="Create"/></td>
		  </tr>
		</table>
	</form>
</div>


<script>
	CKEDITOR.replace( 'editor1' );
</script>

<%@include file="footer.jsp" %>
