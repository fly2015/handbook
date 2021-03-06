package handbook.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import handbook.constant.FilterOption;
import handbook.dao.ArticleDao;
import handbook.dto.Article;
import handbook.dto.Tag;
import handbook.exception.ProcessException;

@Component
public class ArticleDaoImpl extends AbstractDao implements ArticleDao{

	@Override
	public Article readArticleBySlug(String articleSlug) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from article where article_title_slug = ?");
		Map<String, Object> map = null;
		try 
		{
			map = jdbc.queryForMap(stringBuilder.toString(), articleSlug);
		} 
		catch (Exception e) {
			// TODO: handle exception
		}	
		
		Article article = null;
		if (map != null && !map.isEmpty())
		{
			article = buildArticleData(map);
		}
		
		return article;
	}

	@Override
	public List<Article> readArticleListByTagSlug(String tagSlug) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from article a, tag t, tag_article ta ");
		stringBuilder.append("where a.article_id = ta.article_id and t.tag_id = ta.tag_id ");
		stringBuilder.append("and t.tag_name_slug = ?");
		
		List<Map<String, Object>> queryForList = jdbc.queryForList(stringBuilder.toString(), tagSlug);
		return buildArticleListData(queryForList);
	}
	
	@Override
	public List<Article> readArticleListByTagSlug(String tagSlug, Integer tagStatus, Integer articleStatus) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from article a, tag t, tag_article ta ");
		stringBuilder.append("where a.article_id = ta.article_id and t.tag_id = ta.tag_id ");
		stringBuilder.append("and t.tag_name_slug = ? and a.status_id = ? and t.status_id = ?");
		
		List<Map<String, Object>> queryForList = jdbc.queryForList(stringBuilder.toString(), tagSlug, tagStatus, articleStatus);
		return buildArticleListData(queryForList);
	}
	
	@Override
	public void writeArticle(Article article) throws ProcessException {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into article(article_title, article_title_slug, article_content, status_id, created_by_user, last_modified_by_user) ");
		sql.append("values(?, ?, ?, ?, ?, ?)");
		
		Object[] args = new Object[6];
		args[0] = article.getArticleTitle();
		args[1] = article.getArticleTitleSlug();
		args[2] = article.getArticleContent();
		args[3] = article.getStatusId();
		args[4] = article.getCreatedByUser().getUserId();
		args[5] = article.getLastModifiedUser().getUserId();
		jdbc.update(sql.toString(), args);
	}

	@Override
	public void writeRelationArticleAndTags(Article article) throws ProcessException {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into tag_article(tag_id, article_id) ");
		sql.append("values(?, ?)");
		
		for (Tag tag : article.getTags()) {
			jdbc.update(sql.toString(), tag.getTagId(), article.getArticleId());
		}
	}

	@Override
	public List<Article> searchArticleListByTitle(String keyword) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select DISTINCT(a.article_id), a.article_title, a.article_title_slug, a.article_content from article a, tag t, tag_article ta ");
		stringBuilder.append("where a.article_id = ta.article_id and t.tag_id = ta.tag_id ");
		stringBuilder.append("and a.article_title like ?");

		
		List<Map<String, Object>> queryForList = jdbc.queryForList(stringBuilder.toString(), "%" + keyword + "%");
		return buildArticleListData(queryForList);
	}
	
	@Override
	public List<Article> readArticleList(Integer numberOfItem, Integer startPosition) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from article limit ?, ?");
		List<Map<String, Object>> queryForList = jdbc.queryForList(stringBuilder.toString(), startPosition, numberOfItem);
		return buildArticleListData(queryForList);
	}
	
	@Override
	public List<Article> readArticleList(Integer numberOfItem, Integer startPosition, Integer statusId) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from article where status_id = ? limit ?, ?");
		List<Map<String, Object>> queryForList = jdbc.queryForList(stringBuilder.toString(), statusId, startPosition, numberOfItem);
		return buildArticleListData(queryForList);
	}
	
	private List<Article> buildArticleListData(List<Map<String, Object>> queryForList) {
		List<Article> articles = new ArrayList<Article>();
		for (Map<String, Object> map : queryForList) {
			Article article = buildArticleData(map);
			articles.add(article);
		}
		return articles;
	}

	private Article buildArticleData(Map<String, Object> map) {
		Article article = new Article();
		article.setArticleId(Integer.valueOf(map.get("article_id").toString()));
		article.setArticleTitle(map.get("article_title").toString());
		article.setArticleTitleSlug(map.get("article_title_slug").toString());
		article.setArticleContent(map.get("article_content").toString());
		return article;
	}

	@Override
	public List<Article> readArticleList(Integer numberOfItem, Integer startPosition, Integer statusId, List<String> filters) {
		if(CollectionUtils.isEmpty(filters))
		{
			return readArticleList(numberOfItem, startPosition, statusId);
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from article where status_id = ?");
		
		if(hasFilter(filters, FilterOption.TOP_USEFUL_ARTICLE))
		{
			
		}
		
		if(hasFilter(filters, FilterOption.TOP_NEWEST_ARTICLE))
		{
			stringBuilder.append(" order by article_id desc");
		}
		
		stringBuilder.append(" limit ?, ?");
		
		List<Map<String, Object>> queryForList = jdbc.queryForList(stringBuilder.toString(), statusId, startPosition, numberOfItem);
		return buildArticleListData(queryForList);
	}

	private boolean hasFilter(List<String> filters, String filterOption)
	{
		for (String filter : filters) {
			if(filterOption.equals(filter))
			{
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Integer readNumberOfArticles(Integer statusId) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select count(*) as countNum from article where status_id = ?");
		Map<String, Object> map = jdbc.queryForMap(stringBuilder.toString(), statusId);
		
		if(map.isEmpty())
		{
			return 0;
		}
		
		return Integer.valueOf(map.get("countNum").toString());
	}

}
