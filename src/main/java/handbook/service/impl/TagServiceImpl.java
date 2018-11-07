/**
 * @author fr.quochien@gmail.com
 * @date Jul 31, 2018
 */
package handbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import handbook.constant.StatusType;
import handbook.constant.TagStatus;
import handbook.constant.Visible;
import handbook.dao.StatusDao;
import handbook.dao.TagDao;
import handbook.dto.Status;
import handbook.dto.Tag;
import handbook.exception.ProcessException;
import handbook.exception.ValidationException;
import handbook.service.TagService;

@Service
public class TagServiceImpl implements TagService {
	@Autowired
	private TagDao tagDao;
	
	@Autowired
	private StatusDao statusDao;
	
	@Override
	public List<Tag> readTagList(Integer startPosition, Integer numberOfItem, TagStatus tagStatus) {
		if (tagStatus == null)
		{
			return tagDao.readListTag(startPosition, numberOfItem);
		}
		
		Status status = statusDao.readStatusByStatusNameAndType(Visible.IS_VISIBLE.getVisibleType(), 
				StatusType.TAG.name(), tagStatus.name());
		
		return tagDao.readListTag(startPosition, numberOfItem, status.getStatusId());
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
