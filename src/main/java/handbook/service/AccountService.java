package handbook.service;

import handbook.dto.User;
import handbook.exception.ProcessException;
import handbook.exception.ValidationException;

public interface AccountService {
	void register(User user) throws ProcessException, ValidationException;
	User readUserByUserName(String userName, Integer statusId);
}
