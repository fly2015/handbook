package handbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import handbook.dao.UserDao;
import handbook.dto.User;
import handbook.exception.ProcessException;
import handbook.exception.ValidationException;
import handbook.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private UserDao userDao;
	@Override
	public void register(User user) throws ProcessException, ValidationException {
		User selectedUser = userDao.readUserByUsername(user.getUsername());
		
		if (selectedUser != null)
		{
			throw new ValidationException("Username is existing");
		}
		
		userDao.writeUser(user);
	}
}
