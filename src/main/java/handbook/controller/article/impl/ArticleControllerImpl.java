package handbook.controller.article.impl;

import java.util.Arrays;
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

import handbook.constant.FilterOption;
import handbook.constant.Pagination;
import handbook.constant.Status;
import handbook.constant.StatusType;
import handbook.controller.article.ArticleController;
import handbook.dto.Article;
import handbook.dto.Comment;
import handbook.dto.Tag;
import handbook.dto.User;
import handbook.exception.ProcessException;
import handbook.exception.ValidationException;
import handbook.service.ArticleService;
import handbook.service.CommentService;
import handbook.service.TagService;
import handbook.util.PaginationUtils;
import handbook.util.StatusUtils;
import handbook.validation.ArticleFormValidation;

@Controller
public class ArticleControllerImpl implements ArticleController{
	@Autowired
	private ArticleService articleService;
	@Autowired
	private TagService tagService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private ArticleFormValidation articleValidation;
	
	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/tag/{tagSlug}" })
	public String readArticleListByTag(@PathVariable("tagSlug") String tagSlug, Model model) {
		List<Article> articleList = articleService.readArticleListByTag(tagSlug, Status.ENABLE.getStatus(), Status.ENABLE.getStatus());
		model.addAttribute("articleList", articleList);
		return "articleByTag";
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/article/{artileTitleSlug}" })
	public ModelAndView readArticleBySlug(@PathVariable("artileTitleSlug") String articleTitleSlug, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		
		Article article = articleService.readArticleBySlug(articleTitleSlug);
		
		if(article.getArticleId() != null)
		{
			List<Comment> commentList = commentService.readCommentList(article.getArticleId(), 
					Status.ENABLE.getStatus(), Status.ENABLE.getStatus());
			modelAndView.addObject("comments", commentList);
		}
		
		modelAndView.addObject("article", article);
		modelAndView.setViewName("articleDetail");
		return modelAndView;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/article/add" })
	public ModelAndView initAddNewArticleForm() {
		List<Tag> tagList = tagService.readTagList(Pagination.START_POSITION_ADD_ARTICLE_PAGE, 
				Pagination.NUMBER_OF_ITEM_ADD_ARTICLE_PAGE,
				Status.ENABLE.getStatus());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addNewArticle");
		modelAndView.addObject("statusList", StatusUtils.getInstance().buildStatusList(StatusType.ARTICLE));
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
		
		
		List<Tag> tagList = tagService.readTagList(Pagination.START_POSITION_ADD_ARTICLE_PAGE, 
				Pagination.NUMBER_OF_ITEM_ADD_ARTICLE_PAGE,
				Status.ENABLE.getStatus());
		
		modelAndView.setViewName("addNewArticle");
		modelAndView.addObject("statusList", StatusUtils.getInstance().buildStatusList(StatusType.ARTICLE));
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
		
		//article.setStatusId(Integer.valueOf(request.getParameter("statusId")));
		article.setStatusId(Status.ACTIVE.getStatus());
		return article;
	}

	
	/*@Override
	@RequestMapping(method = RequestMethod.GET, value = {"/articles" })
	public ModelAndView readArticleList() {
		Integer numOfArticles = articleService.countArticles(ArticleStatus.ENABLE.getStatus());
		Integer totalPages = (int)Math.ceil((float)numOfArticles/Pagination.NUMBER_OF_ITEM_ARTICLES_PAGE);
		
		List<Article> articleList = articleService.readArticleList(Pagination.NUMBER_OF_ITEM_ARTICLES_PAGE, Pagination.START_POSITION_ARTICLES_PAGE, ArticleStatus.ENABLE.getStatus());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("articleList", articleList);
		modelAndView.addObject("numOfArticles", numOfArticles);
		modelAndView.addObject("totalPages", totalPages);
		modelAndView.addObject("pageIndex", 1);
		
		modelAndView.setViewName("articleList");
		return modelAndView;
	}*/
	
	@Override
	@RequestMapping(method = RequestMethod.GET, value = {"/articles", "/articles/{page}" })
	public ModelAndView readArticleList(@PathVariable(value = "page", required = false) Integer page) {
		
		Integer numOfArticles = articleService.countArticles(Status.ENABLE.getStatus());
		Integer numberOfPages = PaginationUtils.getInstance().getNumberOfPages(numOfArticles, Pagination.NUMBER_OF_ITEM_ARTICLES_PAGE);
		
		page = PaginationUtils.getInstance().verifyRequestedPageNumber(page, numberOfPages);
		Integer startPosition =   PaginationUtils.getInstance().caculateStartPosition(page, Pagination.NUMBER_OF_ITEM_ARTICLES_PAGE);
		List<Article> articleList = articleService.readArticleList(Pagination.NUMBER_OF_ITEM_ARTICLES_PAGE, startPosition, Status.ENABLE.getStatus());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("articleList", articleList);
		modelAndView.addObject("numOfArticles", numOfArticles);
		modelAndView.addObject("numberOfPages", numberOfPages);
		modelAndView.addObject("pageIndex", page);
		modelAndView.setViewName("articleList");
		return modelAndView;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = {"/articles/userful" })
	public ModelAndView readUserFulArticle() {
		ModelAndView modelAndView = new ModelAndView();
	
		List<Article> topUserfulArticles = articleService.readArticleList(Pagination.NUMBER_OF_ITEM_ARTICLES_HOME,
				Pagination.START_POSITION_ARTICLES_HOME, 
				Status.ENABLE.getStatus(),
				Arrays.asList(FilterOption.TOP_USEFUL_ARTICLE));
		
		modelAndView.addObject("topUserfulArticles", topUserfulArticles);
		modelAndView.setViewName("userfulArticles");
		
		return modelAndView;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = {"/articles/newest" })
	public ModelAndView readNewestArticle() {
		ModelAndView modelAndView = new ModelAndView();
		List<Article> topNewestArticles = articleService.readArticleList(Pagination.NUMBER_OF_ITEM_ARTICLES_HOME,
				Pagination.START_POSITION_ARTICLES_HOME, 
				Status.ENABLE.getStatus(), 
				Arrays.asList(FilterOption.TOP_NEWEST_ARTICLE));
		
		modelAndView.addObject("topNewestArticles", topNewestArticles);
		modelAndView.setViewName("newestArticles");
		
		return modelAndView;
	}
}
