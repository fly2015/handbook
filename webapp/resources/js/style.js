$(document).ready(function() {
	var activatedMenu = getActivatedMenuFromUrlVars();
	if (activatedMenu != '')
	{
		$('.' + activatedMenu).addClass("activated-menu");
	}
	
	initSubMenu();
	
	
});

function initSubMenu()
{
	$(".sub-menu-your-account").removeClass("disabled");
}

function getActivatedMenuFromUrlVars()
{
    var hashes = window.location.href.split('/');
    var length1 = hashes.length - 1;

    if(hashes[length1] === "home")
	{
    	return "menu-home";
	}
    
    if(hashes[length1] === "tags")
	{
    	return "menu-tags";
	}
    
    if(hashes[length1] === "articles")
	{
    	console.log("aaaaaaaaaaaaaaaaaaa");
    	var length2 = hashes.length - 2;
    	if(hashes[length2] === "userful")
		{
    		console.log("bbbbbbbbbbbbb");
	    	return "menu-articles-userful";
		}
	    
	    if(hashes[length2] === "newest")
		{
	    	console.log("cccccccccccccccccc");
	    	return "menu-articles-newest";
		}
    	    
    	return "menu-articles";
	}
    
   
    
    if(hashes[length1] === "add")
	{
    	var length2 = hashes.length - 2;
    	if(hashes[length2] === "tag")
    	{
        	return "menu-add-tag";
    	}
    	
    	if(hashes[length2] === "article")
    	{
        	return "menu-add-article";
    	}
	}

    
    getActiveMenuHasSubMenu(hashes);

    return "menu-home";
}


function getActiveMenuHasSubMenu(hashes)
{
	var length1 = hashes.length - 1;
	if (hashes[length1] === "manage")
	{
		return "sub-menu-article";
	}
}