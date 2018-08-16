package handbook.security.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import handbook.dao.UserDao;
import handbook.dto.Role;
import handbook.dto.User;
import handbook.exception.EntityNotFoundException;
import handbook.security.UserAuthenticationService;

public class UserAuthenticationServiceImpl implements UserAuthenticationService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws EntityNotFoundException {
		User user = userDao.readUserByUserName(username);
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
					new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
			
			return userSercurity;
		}
		
		throw new UsernameNotFoundException("User " + username + " not found");
	}
}
