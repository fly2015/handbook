$(document).ready(function(){
	
	$("#btn-article-search").click(function(e) {
		console.log("Started search article");
		$("#btn-article-search").prop("disabled", true);
		performAjaxComment();
	});
});

function performAjaxComment() {
	
	var data = {}
	var headers = {}
	
	var searchString = $("#searchString").val();
	
	$.ajax({
        type: "GET",
        url: "search-article",
        data: jQuery.param({ searchString: searchString}) ,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        dataType: "json",
        timeout: 600000,
        success: function (data) {
        	$("#btn-article-search").prop("disabled", false);
            display(data);
        },
        error: function (e) {
        	console.log("Fails");
            $("#btn-article-search").prop("disabled", false);
        }
	});
}

function display(data) {
	$(".search-response-section").removeClass("disabled");
	var articles = data["articles"];
	
	console.log(articles.length);
	
	var articleBlockData = "";
	if(articles)
	{
		for(i = 0; i< articles.length; i++)
		{
			var articleUnit = 	'<div class="article-item">' +
								'<a href="article/' + articles[i]["articleTitleSlug"] +  '">' +
								'<span class="artile-list-item">' + formatting(articles[i]["articleId"]) + '. </span>'
								+ articles[i]["articleTitle"] + 
								'</a>' +
								'</div>';
			
			articleBlockData += articleUnit;
		}
	}
	
	var message = data["message"];
	var messageTag = "";
	if(message)
	{
		messageTag = "<p class='validation-message'>" + message + "</p>";
	}
	
	
	var responseContent =  messageTag + articleBlockData;
	
	$('#search-response-content').html(responseContent);
}

function formatting(str, len)
{
   return ("00000"+str).slice(-len);
}