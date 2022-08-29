package handbook.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import handbook.dao.UserDao;
import handbook.dto.User;
import handbook.exception.ProcessException;
import handbook.exception.ValidationException;
import handbook.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	private static final Logger logger = LogManager.getLogger(AccountServiceImpl.class);
	@Autowired
	private UserDao userDao;
	@Override
	public void register(User user) throws ProcessException, ValidationException {
		logger.info("Start register");
		
		User selectedUser = userDao.readUserByUsername(user.getUsername());
		if (selectedUser != null)
		{
			throw new ValidationException("Username is existing");
		}
		
		userDao.writeUser(user);
		User insertedUser = userDao.readUserByUsername(user.getUsername());
		insertedUser.setRole(user.getRole());
		userDao.writeRelationUserAndRole(insertedUser);
		
		logger.info("End register");
	}
	@Override
	public User readUserByUserName(String username, Integer statusId) {
		return userDao.readUserByUsername(username, statusId);
	}
	@Override
	public User readUserByUserName(String userName) {
		return userDao.readUserByUsername(userName);
	}
}
