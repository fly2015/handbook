package handbook.service;

import java.util.List;


import handbook.dto.Article;

public interface ArticleService {
	List<Article> readArticleListByTag(String tagSlug);
	Article readArticle(String articleTitleSlug);
}
