<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">

	<jsp:include page="/WEB-INF/sb2/layout/topNav.jsp"></jsp:include>
	
	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<li class="sidebar-search">
					<div class="input-group custom-search-form">
					
						<c:url var="actionUrl" value="/search"></c:url>
						<form action="${actionUrl}" method="get" accept-charset="utf-8">
							<input type="text" name="keyword" class="form-control" placeholder="Search...">
						</form>
						<span class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div> <!-- /input-group -->
				</li>
				<li><a href="<c:url value="/" />"><i class="glyphicon glyphicon-home"></i>
						Home</a></li>
				<li><a href="<c:url value="/article/add" />"><i class="glyphicon glyphicon-plus"></i>
						Article</a></li>
				<li><a href="<c:url value="/articles" />"><i class="fa fa-list-ul	"></i>
						List Articles</a></li>
				<li><a href="<c:url value="/tag/add" />"><i class="glyphicon glyphicon-plus-sign"></i>
						Tag</a></li>		
				<li><a href="<c:url value="/tags" />"><i class="glyphicon glyphicon-tags"></i>
						List Tags</a></li>
						
				<li><a href="#"><i class="fa fa-user"></i>
						Yours<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="#"> Posts</a></li>
						<li><a href="#"> Tags</a></li>
						<li><a href="#"> Replies</a></li>
					</ul> <!-- /.nav-second-level -->
				</li>
			</ul>
		</div>
		<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
</nav>