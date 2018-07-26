/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.dao;

import handbook.dto.User;

public interface UserDao {
	boolean login(String username, String password);
	User readUser(int userId); 
}
