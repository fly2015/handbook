/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.dao;

import java.util.List;

import handbook.dto.Tag;
import handbook.exception.ProcessException;

public interface TagDao {
	List<Tag> readListTag(Integer startPosition, Integer numberOfItem);
	List<Tag> readListTag(Integer startPosition, Integer numberOfItem, Integer statusId);
	Tag readTag(Integer tagId);
	Tag readTagByTagSlug(String tagSlug);
	void writeTag(Tag tag) throws ProcessException;
}
