package handbook.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface ArticleController {
	String readArticleListByTag(String tagSlug, Model model);
	String readArticleBySlug(String articleTitleSlug, Model model);
	ModelAndView readArticleList(Integer numberOfItem, Integer startPosition);
	ModelAndView initAddNewArticleForm();
	ModelAndView addNewArticle(HttpServletRequest request);
	ModelAndView searchArticle(HttpServletRequest request);
}
