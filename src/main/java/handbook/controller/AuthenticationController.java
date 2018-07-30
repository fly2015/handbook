/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface AuthenticationController {
	String login();
	String login(String username, String password, Model model, HttpServletRequest request);
}
