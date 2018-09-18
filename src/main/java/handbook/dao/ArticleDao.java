/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.dao;

import java.util.List;

import handbook.dto.Article;
import handbook.exception.ProcessException;

public interface ArticleDao {
	//Article readArticle(int answerId);
	Article readArticleBySlug(String answerSlug);
	List<Article> readArticleListByTagSlug(String tagSlug);
	void writeArticle(Article article) throws ProcessException;
	void writeRelationArticleAndTags(Article article) throws ProcessException;
}
