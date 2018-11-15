$(document).ready(function(){
	
	$("#btn-comment").click(function(e) {
		console.log("Started add comment");
		var data = {}
		var headers = {}
		data["aritlceId"] = $("#article-id").val();
		data["commentContent"] = $("#comment-content").val();
		
		var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
	    var csrfToken = $("meta[name='_csrf.token']").attr("content"); 
	    var csrfHeader = $("meta[name='_csrf_header']").attr("content")
	    
	    data[csrfParameter] = csrfToken;
	    headers[csrfHeader] = csrfToken;
	    
		$("#btn-comment").prop("disabled", true);
		
		
		$.ajax({
            type: "POST",
            async: false,
            contentType: "application/html",
            url: "comment/add",
            headers: headers,
            data: data,
            dataType: 'json',
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