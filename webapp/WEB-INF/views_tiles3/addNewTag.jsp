<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="main-contain">
	<h3>Add New Tag Form</h3>

	<spring:url value="/tag/add" var="actionUrl" />
	<p style="color: red">
		<c:out value="${message}"></c:out>
	</p>
	<form method="post" action="${actionUrl}">
		<table>
			<tr>
				<td>Name:</td>
				<td><input class="input-font" type="text" name="tagName" value="" /></td>
			</tr>
			<tr>
				<td>Status:</td>
				<td><select class="input-font" name="statusId">
						<c:forEach items="${statusList}" var="status">
							<option value="${status.statusId}">${status.statusName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<td colspan="2" align="right">
					<input class="input-font"type="submit" value="Create" />
				</td>
			</tr>
		</table>
	</form>
</div>

