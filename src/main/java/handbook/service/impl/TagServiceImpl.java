/**
 * @author fr.quochien@gmail.com
 * @date Jul 31, 2018
 */
package handbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import handbook.dao.TagDao;
import handbook.dto.Tag;
import handbook.service.TagService;

@Service
public class TagServiceImpl implements TagService{
	@Autowired
	private TagDao tagDao;
	/* 
	 * @see handbook.service.TagService#readTagList()
	 */
	@Override
	public List<Tag> readTagList() {
		List<Tag> readListTag = tagDao.readListTag();
		Tag tag = new Tag();
		tag.setTagName("aaaaaaaaaaaaa");
		readListTag.add(tag);
		return readListTag;
	}

}