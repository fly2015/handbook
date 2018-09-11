package handbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import handbook.dao.ArticleDao;
import handbook.dto.Article;
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
	public Article readArticle(String articleTitleSlug) {
		return dao.readArticleBySlug(articleTitleSlug);
	}
}
