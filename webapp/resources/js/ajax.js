$(document).ready(function(){
	
	$("#btn-comment").click(function(e) {
		console.log("Started add comment");
		$("#btn-comment").prop("disabled", true);
		performAjaxComment();
	});
});

function performAjaxComment() {
	
	var data = {}
	var headers = {}
	
	var articleId = $("#article-id").val();
	var commentContent = CKEDITOR.instances['comment-content'].getData()
	var csrfParameter = $("#csrf").attr("name");
	var csrfToken = $("#csrf").val();
	
	$.ajax({
        type: "POST",
        url: "comment/add",
        data: jQuery.param({ articleId: articleId, commentContent : commentContent, _csrf : csrfToken}) ,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        dataType: "json",
        timeout: 600000,
        success: function (data) {
        	$("#btn-comment").prop("disabled", false);
            display(data);
        },
        error: function (e) {
        	console.log("Fails");
            $("#btn-comment").prop("disabled", false);
        }
	});
}

function display(data) {
	/*var json = "<h4>Feedback F</h4><pre>"
			+ JSON.stringify(data, null, 4) + "</pre>";*/
	
	
	var headerTag = "<h3>Additional information </h3>";

	var comments = data["comments"];
	var commentContentTags = "";
	if(comments)
	{
		for(i = 0; i< comments.length; i++)
		{
			commentContent = comments[i]["commentContent"]
			if(commentContent)
			{
				commentContentTags += "<p>" + commentContent + "</p>";
			}
		}
	}
	
	var message = data["message"];
	var messageTag = "";
	if(message)
	{
		messageTag = "<p class='validation-message'>" + message + "</p>";
	}
	
	
	var commentResponseContent = headerTag + commentContentTags + messageTag;
	
	$('#comment').html(commentResponseContent);
}