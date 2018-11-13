<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<div class="main-contain">
	<h3><c:out value="${article.articleTitle}"></c:out></h3>
	
	<p>
		${article.articleContent}
	</p>
	
	<div class="comment-section">
		<form action="#" id="usrform">
		  <textarea rows="10" cols="80">
					At w3schools.com you will learn how to make a website. We offer free tutorials in all web development technologies. 
			</textarea>
		  <br>
		  <input class="btnComment" type="submit" name="" value="Comment">
		</form>
	</div>
</div>


