/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.controller.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import handbook.controller.AuthenticateController;

@Controller
public class AuthenticateControllerImpl implements AuthenticateController {

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
		
		return null;
	}

}
