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
import handbook.exception.ProcessException;
import handbook.exception.ValidationException;
import handbook.service.TagService;

@Service
public class TagServiceImpl implements TagService {
	@Autowired
	private TagDao tagDao;
	
	@Override
	public List<Tag> readTagList(Integer startPosition, Integer numberOfItem, Integer status) {
		if (status == null)
		{
			return tagDao.readListTag(startPosition, numberOfItem);
		}
		
		return tagDao.readListTag(startPosition, numberOfItem, status);
	}

	@Override
	public void addNewtagList(Tag tag) throws ProcessException, ValidationException {
		Tag selectedTag = tagDao.readTagByTagSlug(tag.getTagNameSlug());
		if (selectedTag != null)
		{
			throw new ValidationException("Tag is existing");
		}
		tagDao.writeTag(tag);
	}
}
