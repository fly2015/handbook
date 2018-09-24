package handbook.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import handbook.dto.AbstractDto;
import handbook.dto.User;
import handbook.exception.ValidationException;

@Component
public class RegisterFormValidation implements Validation
{
	@Override
	public <T extends AbstractDto> void validate(T t) throws ValidationException {	
		User user = (User) t;
		
		if (user == null)
		{
			throw new ValidationException("Technical error.");
		}
		
		if (StringUtils.isEmpty(user.getUsername()))
		{
			throw new ValidationException("Username must be entered");
		}
		
		if (StringUtils.isEmpty(user.getPassword()))
		{
			throw new ValidationException("Password must me entered");
		}
		
		if (StringUtils.isEmpty(user.getEmail()))
		{
			throw new ValidationException("Email must be entered");
		}
		
		if(user.getUsername().length() > 100)
		{
			throw new ValidationException("Username max length is 100.");
		}
		
		if(user.getPassword().length() > 100)
		{
			throw new ValidationException("Password max length is 100.");
		}
		
		if(user.getEmail().length() > 100)
		{
			throw new ValidationException("Email max length is 100.");
		}
	}
	
}
