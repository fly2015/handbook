package handbook.security;

import handbook.dto.User;

public interface UserAuthenticationService {
	User loadUserByUsername(String username);
}
