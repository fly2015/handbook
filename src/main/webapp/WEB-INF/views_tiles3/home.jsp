<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="customtld" prefix="cfn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script src="resources/js/article-search-ajax.js" type="text/javascript"></script>
<div class="main-contain">
	
	<h3 class="title">Article > Search Form</h3>
	<div class="top-article top-use-article">
		<input size="40" type="text" id="searchString" name="searchString" autocomplete="off"> 
		<input class="input-font" id="btn-article-search" type="button" value="Search">
	</div>
	
	<br>
	<div class="search-response-section disabled">
		<h3 class="title">Search > Result</h3>
		<div id="search-response-content">
			
		</div>
	</div>
	
	<div class="pagination-section disabled">
		<div class="pagination">
			<a href="articles/${pageIndex - 1}">&laquo;</a>
		  	<a href="articles/${page.count}"><c:out value="${page.count}"></c:out> </a>
			<a href="articles/${pageIndex + 1}">&raquo;</a>
		</div>
	</div>
	
</div>
