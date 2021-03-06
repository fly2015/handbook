<%@include file="header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="main-contain">
	<h4>Register Form</h4>
	<p class="message"><c:out value="${message}"></c:out> </p>
	<spring:url value="/register" var="registerUrl" />
	<form method="post" action="${registerUrl}">
		<table>
		  <tr>
		    <td>Username: </td>
		    <td><input type="text" name="username" value=""/></td>
		  </tr>
		  <tr>
		    <td>Email: </td>
		    <td><input type="text" name="email" value=""/></td>
		  </tr>
		  <tr>
		  	<td>Password: </td>
		    <td><input type="text" name="password" value=""/></td>
		    <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
		  </tr>
		  
		  <tr>
		    <td colspan="2" align="right"><input type="submit" value="Register"/></td>
		    
		  </tr>
		</table>
	</form>
</div>




<%@include file="footer.jsp" %>
