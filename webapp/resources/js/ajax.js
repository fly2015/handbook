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
            console.log("Comment added");
            display(data);
        },
        error: function (e) {
        	console.log("Fails");
            $("#btn-comment").prop("disabled", false);
        }
	});
}

function display(data) {
	var json = "<h4>Ajax Response</h4><pre>"
			+ JSON.stringify(data, null, 4) + "</pre>";
	$('#comment').html(json);
}