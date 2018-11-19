$(document).ready(function(){
	
	$("#btn-comment").click(function(e) {
		console.log("Started add comment");
		var data = {}
		var headers = {}
		
		var articleId = $("#article-id").val();
		var commentContent = CKEDITOR.instances['comment-content'].getData()
		var csrfParameter = $("#csrf").attr("name");
		var csrfToken = $("#csrf").val();
		console.log(csrfParameter); 
		
		$("#btn-comment").prop("disabled", true);
		
		
		$.ajax({
            type: "POST",
            //async: false,
            url: "comment/add",
            data: jQuery.param({ articleId: articleId, commentContent : commentContent, _csrf : csrfToken}) ,
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            timeout: 600000,
            success: function (data) {
                console.log("Comment added");
            },
            error: function (e) {
            	console.log("Fails");
                $("#btn-comment").prop("disabled", false);
            }
		});
		
	});

});