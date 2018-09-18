package handbook.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface ArticleController {
	String readArticleListByTag(String tagSlug, Model model);
	String readArticle(String articleTitleSlug, Model model);
	ModelAndView initAddNewArticleForm();
	ModelAndView addNewArticle(HttpServletRequest request);
}
