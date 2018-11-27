<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<header>
	<nav class="nav-header">
		<div class="nav-left">
			<ul>
				<sec:authorize access="hasRole('ADMIN') or hasRole('SUPER-USER') or hasRole('USER')">
					<li><a class="menu-home" href="home">Home</a></li>
					<li><a class="menu-tags" href="tags">Tags</a></li>
					<li><a class="menu-articles" href="articles">Articles</a></li>
					<li><a class="menu-articles-userful" href="articles/userful">Most Userful</a></li>
					<li><a class="menu-articles-newest" href="articles/newest">Newest</a></li>
				</sec:authorize>
				
				<sec:authorize access="hasRole('ADMIN') or hasRole('SUPER-USER')">
					<li><a class="menu-add-tag" href="tag/add">+Tag</a></li>
					<li><a class="menu-add-article" href="article/add">+Article</a></li>
				</sec:authorize>
				
			</ul>
		</div>
		
		<!-- <div class="nav-middle">
			
		</div> -->
		
		<div class="nav-right">
			<ul>
				
				<sec:authorize access="hasRole('ADMIN')">
					<li><a class="menu-manage menu-manage-article" href="#">Manage Articles</a></li>
					<li><a class="menu-manage menu-manage-comment" href="#">Manage Comments</a></li>
					<li><a class="menu-manage menu-manage-tag" href="#">Manage Tags</a></li>
					<li><a class="menu-manage menu-manage-account" href="#">Manage Accounts</a></li>
				</sec:authorize>
				
				<sec:authorize access="hasRole('ADMIN') or hasRole('SUPER-USER')">
					<li><a class="menu-manage menu-manage-your-content" href="#">Your Contents</a></li>
				</sec:authorize>

				
				<sec:authorize access="isAuthenticated()">
					<li><a href="logout">Logout</a></li>
				</sec:authorize>
				
				<sec:authorize access="!isAuthenticated()">
					<li><a href="login">Login</a></li>
					<li><a href="register">Register</a></li>
				</sec:authorize>
			</ul>
		</div>
	</nav>
	
</header>

