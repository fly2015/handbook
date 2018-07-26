/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.dto;

public class Tag extends AbstractDto {
	private int tagId;
	private String tagName;
	private String tagNameSlug;

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagNameSlug() {
		return tagNameSlug;
	}

	public void setTagNameSlug(String tagNameSlug) {
		this.tagNameSlug = tagNameSlug;
	}
}
