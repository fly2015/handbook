package handbook.controller.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import handbook.controller.AccountController;
import handbook.dto.Status;
import handbook.dto.User;
import handbook.exception.ProcessException;
import handbook.exception.ValidationException;
import handbook.service.AccountService;
import handbook.validation.RegisterFormValidation;
@Controller
public class AccountControllerImpl implements AccountController{
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private RegisterFormValidation validation;
	
	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/register"})
	public String initRegisterForm() {
		return "register";
	}

	@Override
	@RequestMapping(method = RequestMethod.POST, value = { "/register"})
	public ModelAndView register(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		Status status = new Status();
		status.setStatusId(0);
		user.setStatus(status );
		User createdUser = new User();
		createdUser.setUserId(0);
		user.setCreatedByUser(createdUser);
		user.setLastModifiedUser(createdUser);
		try {
			validation.validate(user);
			accountService.register(user);
			
			modelAndView.addObject("message", "Register sucessfully. "
					+ "Please contact admin to active your account.");
		} catch (ProcessException e) {
			modelAndView.addObject("message", e.getMessage());
		}
		catch (ValidationException e) {
			modelAndView.addObject("message", e.getMessage());
		}
		
		
		modelAndView.setViewName("register");
		return modelAndView;
	}

}
