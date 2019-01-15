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
    	return "menu-articles";
	}
    
    if(hashes[length1] === "userful")
	{
    	return "menu-articles-userful";
	}
    
    if(hashes[length1] === "newest")
	{
    	return "menu-articles-newest";
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

    return "menu-home";
}
