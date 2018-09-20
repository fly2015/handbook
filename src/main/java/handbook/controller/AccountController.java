package handbook.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface AccountController {
	String initRegisterForm();
	ModelAndView register(HttpServletRequest request);
}
