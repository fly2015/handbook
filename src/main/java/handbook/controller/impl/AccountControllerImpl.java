package handbook.controller.impl;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import handbook.constant.StatusName;
import handbook.constant.StatusType;
import handbook.constant.VisibleType;
import handbook.controller.AccountController;
import handbook.dto.Role;
import handbook.dto.Status;
import handbook.dto.User;
import handbook.exception.ProcessException;
import handbook.exception.ValidationException;
import handbook.service.AccountService;
import handbook.service.StatusService;
import handbook.validation.RegisterFormValidation;
@Controller
public class AccountControllerImpl implements AccountController{
	private static final Logger logger = Logger.getLogger(AccountControllerImpl.class);
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private RegisterFormValidation validation;
	
	@Autowired
	private StatusService statusService;
	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/register"})
	public String initRegisterForm() {
		return "register";
	}

	@Override
	@RequestMapping(method = RequestMethod.POST, value = { "/register"})
	public ModelAndView register(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		User user = buildUser(request);
		try {
			validation.validate(user);
			accountService.register(user);
			
			modelAndView.addObject("message", "Register sucessfully. Please contact admin to active your account.");
		} catch (ProcessException e) {
			logger.error(e.getMessage());
			modelAndView.addObject("message", "Technical error.");
		}
		catch (ValidationException e) {
			modelAndView.addObject("message", e.getMessage());
		}
		
		
		modelAndView.setViewName("register");
		return modelAndView;
	}

	private User buildUser(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		
		Status status = new Status();
		Status selectedStatus = statusService.readStatusByStatusNameAndType(VisibleType.IS_VISIBLE.getVisibleType(), StatusType.USER.name(), StatusName.ACTIVE.name());
		status.setStatusId(selectedStatus.getStatusId());
		user.setStatus(status );
		User createdUser = new User();
		createdUser.setUserId(0);
		user.setCreatedByUser(createdUser);
		user.setLastModifiedUser(createdUser);
		
		//todo
		Role role = new Role();
		role.setRoleId(2);
		user.setRole(role);
		return user;
	}

}
