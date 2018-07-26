/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.dto;

public class Answer extends AbstractDto {
	private int answerId;
	private Question question;
	private String answerContent;

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

}
