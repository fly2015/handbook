<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="main-contain">
	<h3 class="title">Tag > Create a new Tag	</h3>

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
			<%-- <tr>
				<td>Status:</td>
				<td>
					<select class="input-font" name="statusId">
							<c:forEach items="${statusList}" var="status">
								<option value="${status.key}">${status.value}</option>
							</c:forEach>
					</select>
				</td>
			</tr> --%>
			<tr>
				<td colspan="2" align="right">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<input class="input-font"type="submit" value="Create" />
				</td>
			</tr>
		</table>
	</form>
</div>

