package handbook.controller.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import handbook.controller.ArticleController;
import handbook.dto.Article;
import handbook.service.ArticleService;

@Controller
public class ArticleControllerImpl implements ArticleController{
	@Autowired
	private ArticleService articleService;
	
	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/tag/{tagSlug}" })
	public String readArticleListByTag(@PathVariable("tagSlug") String tagSlug, Model model) {
		List<Article> articleList = articleService.readArticleListByTag(tagSlug);
		model.addAttribute("articleList", articleList);
		return "articleByTag";
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/article/{artileTitleSlug}" })
	public String readArticle(@PathVariable("artileTitleSlug") String articleTitleSlug, Model model) {
		Article article = articleService.readArticle(articleTitleSlug);
		model.addAttribute(article);
		return "articleDetail";
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/article/add" })
	public String callAddNewArticleForm() {
		return "addNewArticle";
	}
}
