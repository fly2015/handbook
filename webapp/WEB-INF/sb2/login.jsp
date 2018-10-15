
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="container">
 <div class="row">
     <div class="col-md-4 col-md-offset-4">
         <div class="login-panel panel panel-default">
             <div class="panel-heading">
                 <h3 class="panel-title">Please Sign In</h3>
             </div>
             <div class="panel-body">
             	<c:if test="${param.error != null}">
				    <p class="alert alert-danger">
				        <spring:message code="message.badCredentials">   
				        </spring:message>
				    </p>
				</c:if>
				<spring:url value="/login" var="loginUrl" />
                 <form role="form" method="post" action="${loginUrl}">
                     <fieldset>
                         <div class="form-group">
                             <input class="form-control" autocomplete="off" placeholder="Username" name="username" type="text" autofocus>
                         </div>
                         <div class="form-group">
                             <input class="form-control"  placeholder="Password" name="password" type="password" value="">
                         </div>
                         <div class="checkbox">
                             <label>
                                 <input name="remember" type="checkbox" value="Remember Me">Remember Me
                             	 <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />	
                             </label>
                         </div>
                         <!-- Change this to a button or input when using this as a form -->
                         <input type="submit" class="btn btn-lg btn-success btn-block" value="Login"/>	
                         <a href="#" class="btn btn-sm btn-danger btn-block">Register</a>
                         <a href="#" class="btn btn-sm btn-danger btn-block">Forgot password</a>
                     </fieldset>
                 </form>
                </div>
            </div>
        </div>
    </div>
</div>