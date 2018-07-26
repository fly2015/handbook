/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.dto;

public class Question extends AbstractDto {
	private int questionId;
	private int questionContent;
	private String questionContentSlug;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(int questionContent) {
		this.questionContent = questionContent;
	}

	public String getQuestionContentSlug() {
		return questionContentSlug;
	}

	public void setQuestionContentSlug(String questionContentSlug) {
		this.questionContentSlug = questionContentSlug;
	}

}
