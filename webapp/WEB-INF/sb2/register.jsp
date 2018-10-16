
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="container">
 <div class="row">
     <div class="col-md-4 col-md-offset-4">
         <div class="login-panel panel panel-default">
             <div class="panel-heading">
                 <h3 class="panel-title">Please Register</h3>
             </div>
             <div class="panel-body">
             	<c:if test="${message != null}">
             		<p class="alert alert-danger"><c:out value="${message}"></c:out></p>
             	</c:if>
			    
				 <spring:url value="/register" var="registerUrl" />
                 <form role="form" method="post" action="${registerUrl}">
                     <fieldset>
                         <div class="form-group">
                             <input class="form-control" autocomplete="off" placeholder="Username" name="username" type="text" autofocus>
                         </div>
                         <div class="form-group">
                             <input class="form-control"  placeholder="Email" name="email" type="email" value="">
                         </div>
                         <div class="form-group">
                             <input class="form-control"  placeholder="Password" name="password" type="password" value="">
                         </div>
                         <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
                         <!-- Change this to a button or input when using this as a form -->
                         <input type="submit" class="btn btn-primary btn-lg btn-block" value="Register"/>
                         <a href="<c:url value="/login" />" class="btn btn-lg btn-success btn-block">Login</a>
                     </fieldset>
                 </form>
                </div>
            </div>
        </div>
    </div>
</div>