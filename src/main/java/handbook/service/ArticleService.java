package handbook.service;

import java.util.List;


import handbook.dto.Article;
import handbook.exception.ProcessException;

public interface ArticleService {
	List<Article> readArticleListByTag(String tagSlug);
	Article readArticle(String articleTitleSlug);
	void addArticle(Article article) throws ProcessException;
}
