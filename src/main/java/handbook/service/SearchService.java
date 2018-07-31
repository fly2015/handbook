/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.service;

import java.util.List;

import handbook.dto.Article;

public interface SearchService {
	List<Article> searchList(List<Integer> tagIds, String keyword);
}
