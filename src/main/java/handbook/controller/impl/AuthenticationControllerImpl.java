/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.controller.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import handbook.controller.AuthenticationController;
import handbook.dto.User;
import handbook.service.AuthenticationService;

@Controller
public class AuthenticationControllerImpl implements AuthenticationController {
	@Autowired
	private AuthenticationService authenticationService;
	
	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/login", "" })
	public String login() {
		return "login";
	}

	@Override
	@RequestMapping(method = RequestMethod.POST, value = { "/login" })
	public String login(
			@RequestParam("username") String username, 
			@RequestParam("password") String password,
			Model model, 
			HttpServletRequest request) {
		
		User user = authenticationService.login(username, password);
		
		request.getSession().invalidate();
		request.getSession().setAttribute("user", user);
		
		return "home";
	}

}
