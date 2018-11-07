/**
 * @author fr.quochien@gmail.com
 * @date Jul 31, 2018
 */
package handbook.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;


import handbook.dao.TagDao;
import handbook.dto.Tag;
import handbook.exception.ProcessException;

@Component
public class TagDaoImpl extends AbstractDao implements TagDao{
	@Override
	public List<Tag> readListTag(Integer startPosition, Integer numberOfItem) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from tag limit ?, ?");
		List<Map<String, Object>> queryForList = jdbc.queryForList(stringBuilder.toString(), startPosition, numberOfItem);
		
		return buildTagList(queryForList);
	}

	@Override
	public List<Tag> readListTag(Integer startPosition, Integer numberOfItem, Integer statusId) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from tag where status_id = ? limit ?, ?");
		List<Map<String, Object>> queryForList = jdbc.queryForList(stringBuilder.toString(), statusId, startPosition, numberOfItem);
		
		return buildTagList(queryForList);
	}
	
	@Override
	public Tag readTag(Integer tagId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tag readTagByTagSlug(String tagSlug) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from tag where tag_name_slug = ?");
		List<Map<String, Object>> queryForList = jdbc.queryForList(stringBuilder.toString(), tagSlug);
		if(CollectionUtils.isNotEmpty(queryForList))
		{
			return buidTag(queryForList.get(0));
		}
		
		return null;
	}
	
	private List<Tag> buildTagList(List<Map<String, Object>> queryForList) {
		List<Tag> tags = new ArrayList<Tag>();
		for (Map<String, Object> map : queryForList) {
			Tag tag = buidTag(map);
			tags.add(tag);
		}
		
		return tags;
	}

	private Tag buidTag(Map<String, Object> map) {
		Tag tag = new Tag();
		tag.setTagId(Integer.valueOf(map.get("tag_id").toString()));
		tag.setTagNameSlug(map.get("tag_name_slug").toString());
		tag.setTagName(map.get("tag_name").toString());
		return tag;
	}
	
	@Override
	public void writeTag(Tag tag) throws ProcessException
	{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tag(tag_name, tag_name_slug, status_id, created_by_user, last_modified_by_user) ");
		sql.append("VALUES (?, ?, ?, ?, ?)");
		try
		{
			jdbc.update(sql.toString(), tag.getTagName(), tag.getTagNameSlug(), tag.getStatus().getStatusId(),
					tag.getCreatedByUser().getUserId(), tag.getLastModifiedUser().getUserId());
		}
		catch (Exception e) {
			throw new ProcessException("Create tag fail");
		}
		
	}
}
