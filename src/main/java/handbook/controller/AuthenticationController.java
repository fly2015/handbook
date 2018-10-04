/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface AuthenticationController {
	ModelAndView home();
	String login();
	String logout(HttpServletRequest request, HttpServletResponse response);
	String login(String username, String password, Model model, HttpServletRequest request);
}
