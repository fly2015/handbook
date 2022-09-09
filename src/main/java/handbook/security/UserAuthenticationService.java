package handbook.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import handbook.dao.UserDao;
import handbook.dto.Role;
import handbook.dto.User;

public class UserAuthenticationService implements UserDetailsService{
    static Logger logger = LogManager.getLogger(UserAuthenticationService.class);
	private final UserDao userDao;
	
	public UserAuthenticationService(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		// todo status Utils
	    logger.info("Retreving user info " + username);

		User user = null;
		try {
			user = userDao.readUserByUsername(username, 1);
		} catch (Exception e) {
			logger.info(e);
			throw e;
		}
		
		if(user != null)
		{
			// read roles from db
			List<Role> roles = userDao.readRoleList(user.getUsername());
			List<GrantedAuthority> authorities =  new ArrayList<GrantedAuthority>();
			for (Role role : roles) {
				String ROLE = "ROLE_" + StringUtils.upperCase(role.getRoleName());
				authorities.add(new SimpleGrantedAuthority(ROLE));
			}

			org.springframework.security.core.userdetails.User userSercurity = 
					new org.springframework.security.core.userdetails.User(user.getUsername(), new BCryptPasswordEncoder().encode(user.getPassword()), authorities);
			
			return userSercurity;
		}
		
		throw new UsernameNotFoundException("User " + username + " not found");
	}
}
