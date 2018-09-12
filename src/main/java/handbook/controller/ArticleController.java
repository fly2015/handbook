package handbook.controller;


import org.springframework.ui.Model;

public interface ArticleController {
	String readArticleListByTag(String tagSlug, Model model);
	String readArticle(String articleTitleSlug, Model model);
	String callAddNewArticleForm();
}
