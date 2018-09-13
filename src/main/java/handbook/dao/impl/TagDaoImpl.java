/**
 * @author fr.quochien@gmail.com
 * @date Jul 31, 2018
 */
package handbook.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;


import handbook.dao.TagDao;
import handbook.dto.Tag;

@Component
public class TagDaoImpl extends AbstractDao implements TagDao{
	@Override
	public List<Tag> readListTag(int startPosition, int numberOfItem) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from tag limit ?, ?");
		List<Map<String, Object>> queryForList = jdbc.queryForList(stringBuilder.toString(), startPosition, numberOfItem);
		
		List<Tag> tags = new ArrayList<Tag>();
		for (Map<String, Object> map : queryForList) {
			Tag tag = new Tag();
			tag.setTagId(Integer.valueOf(map.get("tag_id").toString()));
			tag.setTagNameSlug(map.get("tag_name_slug").toString());
			tag.setTagName(map.get("tag_name").toString());
			
			tags.add(tag);
		}
		
		return tags;
	}

	/* 
	 * @see handbook.dao.TagDao#readTag(int)
	 */
	@Override
	public Tag readTag(int tagId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* 
	 * @see handbook.dao.TagDao#readTag(java.lang.String)
	 */
	@Override
	public Tag readTag(String tagSlug) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeTag(Tag tag) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tag(tag_name, tag_name_slug, status_id, created_by_user, last_modified_by_user) ");
		sql.append("VALUES (?, ?, ?, ?, ?)");
		jdbc.update(sql.toString(), tag.getTagName(), tag.getTagNameSlug(), tag.getStatus().getStatusId(),
				tag.getCreatedByUser().getUserId(), tag.getLastModifiedUser().getUserId());
	}

}
