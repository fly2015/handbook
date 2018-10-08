/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import handbook.controller.HomeController;

@Controller
public class HomeControllerImpl implements HomeController {
	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/login"})
	public String login() {
		return "login";
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/logout"})
	public String logout(HttpServletRequest request, HttpServletResponse response) 
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/login?logout";
	}

	
	/* * 
	 * For none sercurity login. It is disabled when spring security is on
	 * */
	@Override
	@RequestMapping(method = RequestMethod.POST, value = { "/login" })
	public String login(
			@RequestParam("username") String username, 
			@RequestParam("password") String password,
			Model model, 
			HttpServletRequest request) {
		
		/*User user = authenticationService.login(username, password);
		user.setUsername("admin");
		user.setUserId(1);
		
		request.getSession().invalidate();
		request.getSession().setAttribute("user", user);*/
		
		return null;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/home","/" })
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("activeClassMenu", "menu-home");
		modelAndView.setViewName("home");
		return modelAndView;
	}

}
