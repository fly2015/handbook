/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.dao;

import java.util.List;

import handbook.dto.Article;

public interface ArticleDao {
	//Article readArticle(int answerId);
	Article readArticleBySlug(String answerSlug);
	List<Article> readArticleListByTagSlug(String tagSlug);
	
	//int write(Article answer);
}
