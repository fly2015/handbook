package handbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import handbook.dao.ArticleDao;
import handbook.dto.Article;
import handbook.exception.ProcessException;
import handbook.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao dao;
	@Override
	public List<Article> readArticleListByTag(String tagSlug) {
		return dao.readArticleListByTagSlug(tagSlug);
	}

	@Override
	public Article readArticleBySlug(String articleTitleSlug) {
		return dao.readArticleBySlug(articleTitleSlug);
	}

	@Override
	public void addArticle(Article article) throws ProcessException {
		String requestArticleSlug = article.getArticleTitleSlug();
		Article selectedArticle = dao.readArticleBySlug(requestArticleSlug);
		if (selectedArticle != null && article.getArticleId() > 0)
		{
			String newArticleSlug = requestArticleSlug + "-" + selectedArticle.getArticleId();
			article.setArticleTitleSlug(newArticleSlug);
		}
		
		dao.writeArticle(article);
		Article insertedArticle = dao.readArticleBySlug(article.getArticleTitleSlug());
		insertedArticle.setTags(article.getTags());
		dao.writeRelationArticleAndTags(insertedArticle);
	}

	@Override
	public List<Article> searchArticle(String keyword) {
		return dao.searchArticleListByTitle(keyword);
	}

	@Override
	public List<Article> readArticleList(Integer numberOfItem, Integer startPosition, Integer statusId) {
		return dao.readArticleList(numberOfItem, startPosition, statusId);
	}

	@Override
	public List<Article> readArticleList(Integer numberOfItem, Integer startPosition, Integer statusId, List<String> filters) {
		return dao.readArticleList(numberOfItem, startPosition, statusId,  filters);
	}

	@Override
	public Integer countArticles(Integer statusId) {
		return dao.readNumberOfArticles(statusId);
	}

	@Override
	public List<Article> readArticleListByTag(String tagSlug, Integer tagStatus, Integer articleStatus) {
		return dao.readArticleListByTagSlug(tagSlug, tagStatus, articleStatus);
	}
}
