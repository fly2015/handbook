package handbook.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import handbook.controller.AccountController;
@Controller
public class AccountControllerImpl implements AccountController{

	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/register"})
	public String register() {
		return "register";
	}

}
