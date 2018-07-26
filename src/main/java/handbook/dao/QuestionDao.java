/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.dao;

import java.util.List;

import handbook.dto.Question;

public interface QuestionDao {
	Question readQuestion(int questionId);
	Question readQuestion(String questionSlug);
	List<Question> readListQuestion();
	
	int addQuestion(Question question);
}
