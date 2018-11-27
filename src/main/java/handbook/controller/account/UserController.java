package handbook.controller.account;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface UserController {
	String initRegisterForm();
	ModelAndView register(HttpServletRequest request);
}
