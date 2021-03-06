/**
 * @author fr.quochien@gmail.com
 * @date Jul 31, 2018
 */
package handbook.service;

import java.util.List;

import handbook.dto.Tag;
import handbook.exception.ProcessException;
import handbook.exception.ValidationException;

public interface TagService {
	List<Tag> readTagList(Integer startPosition, Integer numberOfItem, Integer status);
	void addNewtagList(Tag tag) throws ProcessException, ValidationException;
}
