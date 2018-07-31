/**
 * @author fr.quochien@gmail.com
 * @date Jul 30, 2018
 */
package handbook.service.impl;

import org.springframework.stereotype.Service;

import handbook.dto.User;
import handbook.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	/* 
	 * @see handbook.service.AuthenticationService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public User login(String username, String password) {
		return new User();
	}

}
