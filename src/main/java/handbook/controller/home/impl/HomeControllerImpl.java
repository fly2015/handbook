/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.controller.home.impl;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import handbook.controller.home.HomeController;

@Controller
public class HomeControllerImpl implements HomeController {
    static Logger logger = LogManager.getLogger(HomeController.class);
	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/login"})
	public String login() {
	    logger.info("Start Login page XXXXX.");
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
		
		logger.info("Logout");
		return "redirect:/login?logout";
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/home","/" })
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}

}
