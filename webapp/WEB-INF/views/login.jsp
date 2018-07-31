<%@include file="header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h4>Login Form</h4>

<spring:url value="/login" var="loginUrl" />
<form:form method="post" modelAttribute="userFormLogin" action="${loginUrl}">
	<table>
	  <tr>
	    <td>Username: </td>
	    <td><input type="text" name="username" value=""/></td>
	  </tr>
	  <tr>
	  	<td>Password: </td>
	    <td><input type="text" name="password" value=""/></td>
	  </tr>
	  
	  <tr>
	    <td colspan="2" align="right"><input type="submit" value="Login"/></td>
	  </tr>
	</table>
</form:form>


<%@include file="footer.jsp" %>
