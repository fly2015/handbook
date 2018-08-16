/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.dao.impl;

import java.util.List;

import handbook.dao.UserDao;
import handbook.dto.Role;
import handbook.dto.User;

public class UserDaoImpl extends AbtractDao implements UserDao{

	/* 
	 * @see handbook.dao.UserDao#login(java.lang.String, java.lang.String)
	 */
	@Override
	public User authenticate(String username, String password) {
		// TODO Auto-generated method stub
		return new User();
	}

	/* 
	 * @see handbook.dao.UserDao#readUser(int)
	 */
	@Override
	public User readUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User readUserByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> readRoleList(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
