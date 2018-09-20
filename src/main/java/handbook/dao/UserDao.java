/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.dao;

import java.util.List;

import handbook.dto.Role;
import handbook.dto.User;
import handbook.exception.ProcessException;

public interface UserDao {
	User authenticate(String username, String password);
	User readUser(int userId); 
	User readUserByUserName(String username);
	List<Role> readRoleList(String username);
	void writeUser(User user) throws ProcessException;
}
