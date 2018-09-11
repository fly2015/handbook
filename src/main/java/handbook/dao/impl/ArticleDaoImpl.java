package handbook.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import handbook.dao.ArticleDao;
import handbook.dto.Article;

@Component
public class ArticleDaoImpl extends AbstractDao implements ArticleDao{

	@Override
	public Article readArticleBySlug(String articleSlug) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from article where article_title_slug = ?");
		Map<String, Object> map = jdbc.queryForMap(stringBuilder.toString(), articleSlug);
		
		Article article = new Article();
		if (!map.isEmpty())
		{
			article.setArticleId(Integer.valueOf(map.get("article_id").toString()));
			article.setArticleTitle(map.get("article_title").toString());
			article.setArticleTitleSlug(map.get("article_title_slug").toString());
			article.setArticleContent(map.get("article_content").toString());
		}
		
		return article;
	}

	@Override
	public List<Article> readArticleListByTagSlug(String tagSlug) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from article a, tag t, tag_article ta ");
		stringBuilder.append("where a.article_id = ta.article_id and t.tag_id = ta.tag_id ");
		stringBuilder.append("and t.tag_name_slug = ?");

		List<Article> articles = new ArrayList<Article>();
		List<Map<String, Object>> queryForList = jdbc.queryForList(stringBuilder.toString(), tagSlug);
		
		for (Map<String, Object> map : queryForList) {
			Article article = new Article();
			article.setArticleId(Integer.valueOf(map.get("article_id").toString()));
			article.setArticleTitle(map.get("article_title").toString());
			article.setArticleTitleSlug(map.get("article_title_slug").toString());
			article.setArticleContent(map.get("article_content").toString());
			articles.add(article);
		}
		return articles;
	}

}
