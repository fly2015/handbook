package handbook.validation;

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
	}
	
}
