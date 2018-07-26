/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.service;

import java.util.List;

import handbook.dto.Question;

public interface QuestionSearch {
	List<Question> searchQuestions(int projectId, List<Integer> tagIds, String keyword);
}
