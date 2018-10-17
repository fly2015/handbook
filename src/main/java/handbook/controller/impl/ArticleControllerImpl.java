package handbook.controller.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import handbook.controller.ArticleController;
import handbook.dto.Article;
import handbook.dto.Status;
import handbook.dto.Tag;
import handbook.dto.User;
import handbook.exception.ProcessException;
import handbook.exception.ValidationException;
import handbook.service.ArticleService;
import handbook.service.StatusService;
import handbook.service.TagService;
import handbook.validation.ArticleFormValidation;

@Controller
public class ArticleControllerImpl implements ArticleController{
	@Autowired
	private ArticleService articleService;
	@Autowired
	private StatusService statusService;
	@Autowired
	private TagService tagService;
	
	@Autowired
	private ArticleFormValidation articleValidation;
	
	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/tag/{tagSlug}" })
	public String readArticleListByTag(@PathVariable("tagSlug") String tagSlug, Model model) {
		List<Article> articleList = articleService.readArticleListByTag(tagSlug);
		model.addAttribute("articleList", articleList);
		return "articleByTag";
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/article/{artileTitleSlug}" })
	public String readArticleBySlug(@PathVariable("artileTitleSlug") String articleTitleSlug, Model model) {
		Article article = articleService.readArticleBySlug(articleTitleSlug);
		model.addAttribute(article);
		return "articleDetail";
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/article/add" })
	public ModelAndView initAddNewArticleForm() {
		List<Status> statusList = statusService.readStatusList(1);
		List<Tag> tagList = tagService.readTagList(0, 50);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addNewArticle");
		modelAndView.addObject("statusList", statusList);
		modelAndView.addObject("tagList", tagList);
		return modelAndView;
	}

	@Override
	@RequestMapping(method = RequestMethod.POST, value = { "/article/add" })
	public ModelAndView addNewArticle(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		Article article = buildArticleData(request);
		try {
			articleValidation.validate(article);
			articleService.addArticle(article);			
			modelAndView.addObject("message", "Create successful !");
		} 
		catch (ValidationException e1)
		{
			modelAndView.addObject("message", e1.getMessage());
		}
		catch (ProcessException e) 
		{
			modelAndView.addObject("message", "Unsuccessful !");
		}
		
		//init form
		List<Status> statusList = statusService.readStatusList(1);
		List<Tag> tagList = tagService.readTagList(0, 50);
		modelAndView.setViewName("addNewArticle");
		modelAndView.addObject("statusList", statusList);
		modelAndView.addObject("tagList", tagList);
		
		return modelAndView;
	}

	private Article buildArticleData(HttpServletRequest request) {
		Article article = new Article();
		article.setArticleTitle(request.getParameter("articleTitle"));
		
		String slug = StringUtils.replaceAll(request.getParameter("articleTitle"), " ", "-");
		article.setArticleTitleSlug(slug);
		
		article.setArticleContent(request.getParameter("articleContent"));
		
		User user = new User();
		user.setUserId(1);
		article.setCreatedByUser(user);
		article.setLastModifiedUser(user);
		
		Set<Tag> tags = new HashSet<>();
		String[] tagIds = request.getParameterValues("tagIds");
		if (tagIds != null)
		{
			for (int i = 0; i < tagIds.length; i++) {
				int tagId = Integer.valueOf(tagIds[i]);
				
				Tag tag = new Tag();
				tag.setTagId(tagId);
				
				tags.add(tag);
			}
		}
		

		article.setTags(tags);
		
		Status status = new Status();
		status.setStatusId(Integer.valueOf(request.getParameter("statusId")));
		article.setStatus(status );
		return article;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/search" })
	public ModelAndView searchArticle(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		String keyword = request.getParameter("keyword");
		
		List<Article> articleList = new ArrayList<>();
		if (StringUtils.isNotEmpty(keyword))
		{
			articleList = articleService.searchArticle(keyword);
		}
		
		modelAndView.addObject("articleList", articleList);
		modelAndView.setViewName("searchArticleResult");
		return modelAndView;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/articles" })
	public ModelAndView readArticleList(Integer numberOfItem, Integer startPosition) {
		
		numberOfItem = (numberOfItem != null) ? numberOfItem : 30;
		startPosition = (startPosition != null) ? startPosition: 0;
		List<Article> articleList = articleService.readArticleList(numberOfItem, startPosition);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("articleList", articleList);
		modelAndView.setViewName("articleList");
		return modelAndView;
	}
}
