
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<div class="main-contain">
	<h4 class="title">Login Form</h4>
	<c:if test="${param.error != null}">
    <p class="alert alert-danger">
        <spring:message code="message.badCredentials">   
        </spring:message>
    </p>
</c:if>
	<spring:url value="/login" var="loginUrl" />
	<form method="post" action="${loginUrl}">
		<table>
		  <tr>
		    <td>Username: </td>
		    <td><input autocomplete="off" type="text" name="username" value=""/></td>
		  </tr>
		  <tr>
		  	<td>Password: </td>
		    <td><input type="password" name="password" value=""/></td>
		    <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
		  </tr>
		  
		  <tr>
		    <td colspan="2" align="right"><input class="input-font" type="submit" value="Login"/></td>
		    
		  </tr>
		</table>
	</form>
</div>

