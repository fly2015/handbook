<%@include file="header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="main-contain">
	<h4>Add New Tag Form</h4>

	<spring:url value="/tag/add" var="actionUrl" />
	<form method="post" action="${actionUrl}">
		<table>
		  <tr>
		    <td>Name: </td>
		    <td><input type="text" name="tagName" value=""/></td>
		  </tr>
		  <tr>
		    <td>Status: </td>
		    <td>
		    	<select name="status">
		    		<option value="">1</option>
		    	</select>
		    </td>
		  </tr>
		  <tr>
		   	<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
		    <td colspan="2" align="right"><input type="submit" value="Create"/></td>
		  </tr>
		</table>
	</form>
</div>




<%@include file="footer.jsp" %>
