package handbook.service;

import java.util.List;


import handbook.dto.Article;
import handbook.exception.ProcessException;

public interface ArticleService {
	List<Article> readArticleListByTag(String tagSlug);
	Article readArticleBySlug(String articleTitleSlug);
	void addArticle(Article article) throws ProcessException;
	List<Article> searchArticle(String keyword);
	List<Article> readArticleList(Integer numberOfItem, Integer startPosition, Integer statusId);
	List<Article> readArticleList(Integer numberOfItem, Integer startPosition, Integer statusId, List<String> filters);
}
