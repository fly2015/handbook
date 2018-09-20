package handbook.validation;


import handbook.dto.AbstractDto;
import handbook.exception.ValidationException;

public interface Validation {
	 <T extends AbstractDto> void validate(T t) throws ValidationException;
}
