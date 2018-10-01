package handbook.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import handbook.dto.AbstractDto;
import handbook.dto.Tag;
import handbook.exception.ValidationException;

@Component
public class TagFormValidation implements Validation{

	@Override
	public <T extends AbstractDto> void validate(T t) throws ValidationException {
		Tag tag = (Tag) t;
		
		if (StringUtils.isEmpty(tag.getTagName()))
		{
			throw new ValidationException("Tag name must be entered");
		}
		
		if (tag.getStatus() == null || tag.getStatus().getStatusId() == null)
		{
			throw new ValidationException("Status must be entered");
		}
		
		if (tag.getTagName().length() > 100)
		{
			throw new ValidationException("Max length of tag name is 100");
		}
	}

}
