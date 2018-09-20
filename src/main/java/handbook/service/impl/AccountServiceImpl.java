package handbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import handbook.dao.UserDao;
import handbook.dto.User;
import handbook.exception.ProcessException;
import handbook.service.AccountService;

public class AccountServiceImpl implements AccountService{
	@Autowired
	private UserDao userDao;
	@Override
	public void register(User user) throws ProcessException {
		userDao.writeUser(user);
	}
}
