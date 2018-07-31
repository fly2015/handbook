/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.dto;

public class Article extends AbstractDto {
	private int articleId;
	private String articleTitle;
	private String articleTitleSlug;
	private String articleContent;

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleTitleSlug() {
		return articleTitleSlug;
	}

	public void setArticleTitleSlug(String articleTitleSlug) {
		this.articleTitleSlug = articleTitleSlug;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

}
