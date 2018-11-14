$(document).ready(function() {
	
	var activatedMenu = getActivatedMenuFromUrlVars();
	if (activatedMenu != '')
	{
		$('.' + activatedMenu).addClass("activated-menu");
	}
});


function getActivatedMenuFromUrlVars()
{
    var hashes = window.location.href.split('/');
    if(hashes[hashes.length - 1] === "home")
	{
    	return "menu-home";
	}
    
    if(hashes[hashes.length - 1] === "tags")
	{
    	return "menu-tags";
	}
    
    if(hashes[hashes.length - 1] === "articles")
	{
    	return "menu-articles";
	}
    
    if(hashes[hashes.length - 1] === "add")
	{
    	if(hashes[hashes.length - 2] === "tag")
    	{
        	return "menu-add-tag";
    	}
    	
    	if(hashes[hashes.length - 2] === "article")
    	{
        	return "menu-add-article";
    	}
	}
    
    if(hashes[hashes.length - 1].substring(0,6	) === "search")
	{
    	return "menu-articles";
	}

    return "";
}