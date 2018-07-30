/**
 * @author fr.quochien@gmail.com
 * @date Jul 30, 2018
 */
package handbook.service;

import handbook.dto.User;

public interface AuthenticationService {
	User login(String username, String password);
}
