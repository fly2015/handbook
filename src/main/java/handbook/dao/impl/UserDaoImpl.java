/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import handbook.dao.UserDao;
import handbook.dto.Role;
import handbook.dto.User;

@Component
public class UserDaoImpl extends AbtractDao implements UserDao{
	@Autowired
	protected JdbcOperations jdbc;
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
		StringBuilder builder = new StringBuilder();
		builder.append("select * from User where username = ?");
		builder.append(" AND status_id = 1");
		
		SqlRowSet queryForRowSet = jdbc.queryForRowSet(builder.toString(), username);
		User user = new User();
		if (queryForRowSet.first())
		{
			user.setUserId(queryForRowSet.getInt("user_id"));
			user.setUsername(queryForRowSet.getString("username"));
			user.setPassword(queryForRowSet.getString("password"));
			user.setEmail(queryForRowSet.getString("email"));
		}
		
		return user;
	}

	@Override
	public List<Role> readRoleList(String username) {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT r.role_id, r.role_name from user_role ur, role r, user u "); 
		builder.append("WHERE r.role_id = ur.role_id ");
		builder.append("AND u.user_id = ur.user_id ");
		builder.append("AND u.username = ? ");
		builder.append("AND r.status_id = 1 ");
		builder.append("AND u.status_id = 1");
		
		List<Map<String, Object>> queryForList = jdbc.queryForList(builder.toString(), username);
		
		List<Role> roles = new ArrayList<Role>();
		for (Map<String, Object> map : queryForList) {
			
			Role role = new Role();
			role.setRoleName(map.get("role_name").toString());
			role.setRoleId(Integer.valueOf(map.get("role_id").toString()));
			roles.add(role);
		}
		
		return roles;
	}

	
}
