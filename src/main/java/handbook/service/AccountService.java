package handbook.service;

import handbook.dto.User;
import handbook.exception.ProcessException;

public interface AccountService {
	void register(User user) throws ProcessException;
}
