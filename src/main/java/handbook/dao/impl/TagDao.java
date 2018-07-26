/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.dao.impl;

import java.util.List;

import handbook.dto.Tag;

public interface TagDao {
	List<Tag> readListTag();
	Tag readTag(int tagId);
	Tag readTag(String tagSlug);
}
