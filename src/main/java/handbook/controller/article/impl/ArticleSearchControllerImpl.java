package handbook.controller.article.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import handbook.controller.article.ArticleSearchController;
import handbook.dto.Article;
import handbook.service.ArticleService;

@Controller
public class ArticleSearchControllerImpl implements ArticleSearchController{
	@Autowired
	private ArticleService articleService;
	
	@Override
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = { "article/search" })
	public ResponseEntity<?> searchArticles(@RequestParam(name="searchString") String searchString) {
		
		Map<String, Object> headers = new HashMap<>();
		
		if(StringUtils.isEmpty(searchString))
		{
			headers.put("message", "Invalid search string !");
			return new ResponseEntity<>(headers, HttpStatus.OK);
		}
		
		List<Article> articleList = articleService.searchArticle(searchString);
		if(CollectionUtils.isEmpty(articleList))
		{
			headers.put("message", "No data found !");
			return new ResponseEntity<>(headers, HttpStatus.OK);
		}
		
		headers.put("articles", articleList);
		return new ResponseEntity<>(headers, HttpStatus.OK);
	}
}
