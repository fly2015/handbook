/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.dao;

import java.util.List;

import handbook.dto.Answer;

public interface AnswerDao {
	Answer readAnswer(int answerId);
	Answer readAnswer(String answerSlug);
	List<Answer> readListAnswer();
	
	int addAnswer(Answer answer);
}
