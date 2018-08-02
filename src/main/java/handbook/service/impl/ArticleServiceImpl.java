package handbook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import handbook.dto.Article;
import handbook.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Override
	public List<Article> readArticleListByTag(String tagSlug) {
		List<Article> articleList = new ArrayList<Article>();

		// article 1
		Article article = new Article();
		article.setArticleTitle("Solution 1");
		article.setArticleTitleSlug("solution-1");
		articleList.add(article);

		// article 2
		article = new Article();
		article.setArticleTitle("Solution 2");
		article.setArticleTitleSlug("solution-2");
		articleList.add(article);

		// article 3
		article = new Article();
		article.setArticleTitle("Solution 3");
		article.setArticleTitleSlug("solution-3");
		articleList.add(article);

		return articleList;
	}

	@Override
	public Article readArticle(String articleTitleSlug) {
		Article article = new Article();
		article.setArticleTitle("Solution");
		article.setArticleContent(
				"Conscious of its spiritual and moral heritage, "
				+ "the Union is founded on the indivisible, universal values of human dignity, "
				+ "freedom, equality and solidarity; "
				+ "it is based on the principles of democracy and the rule of law. "
				+ "It places the individual at the heart of its activities, "
				+ "by establishing the citizenship of the Union and by creating an area of freedom, "
				+ "security and justice");
		return article;
	}
}
