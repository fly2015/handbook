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
public class TagDaoImpl extends AbtractDao implements TagDao{
	
	/* 
	 * @see handbook.dao.TagDao#readListTag()
	 */
	@Override
	public List<Tag> readListTag() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> queryForList = jdbc.queryForList("select * from tag");
		return new ArrayList<Tag>();
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

}
