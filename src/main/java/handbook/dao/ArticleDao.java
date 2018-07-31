/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.dao;

import java.util.List;

import handbook.dto.Article;

public interface ArticleDao {
	Article read(int answerId);
	Article read(String answerSlug);
	List<Article> readList();
	
	int write(Article answer);
}
