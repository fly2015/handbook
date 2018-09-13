/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.dao;

import java.util.List;

import handbook.dto.Tag;

public interface TagDao {
	List<Tag> readListTag(int startPosition, int numberOfItem);
	Tag readTag(int tagId);
	Tag readTag(String tagSlug);
	void writeTag(Tag tag) throws Exception;
}
