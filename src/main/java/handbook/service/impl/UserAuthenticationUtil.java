package handbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import handbook.constant.Status;
import handbook.dto.User;
import handbook.service.AccountService;

@Component
public class UserAuthenticationUtil {
	@Autowired
	private AccountService accountService;
	
	public User readAuthenticatedUser()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) auth
				.getPrincipal();
		return accountService.readUserByUserName(principal.getUsername(), Status.ACTIVE.getStatus());
	}
}
