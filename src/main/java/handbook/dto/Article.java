/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.dto;

import java.util.Set;

public class Article extends AbstractDto {
	private Integer articleId;
	private String articleTitle;
	private String articleTitleSlug;
	private String articleContent;
	private Integer sequence;
	private Set<Tag> tags;	

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
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

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

}
