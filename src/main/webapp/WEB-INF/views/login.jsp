<%@include file="header.jsp" %>
<h4>Login Form</h4>
<form method="post" action="<% out.print(request.getContextPath()); %>/login">
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
</form>


<%@include file="footer.jsp" %>
