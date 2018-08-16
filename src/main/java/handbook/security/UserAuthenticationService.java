package handbook.security;

import org.springframework.security.core.userdetails.UserDetails;

import handbook.exception.EntityNotFoundException;

public interface UserAuthenticationService {
	UserDetails loadUserByUsername(String username) throws EntityNotFoundException;
}
