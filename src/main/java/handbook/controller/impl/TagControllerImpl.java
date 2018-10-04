/**
 * @author fr.quochien@gmail.com
 * @date Jul 31, 2018
 */
package handbook.controller.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import handbook.controller.TagController;
import handbook.dto.Status;
import handbook.dto.Tag;
import handbook.dto.User;
import handbook.exception.ProcessException;
import handbook.exception.ValidationException;
import handbook.service.AccountService;
import handbook.service.StatusService;
import handbook.service.TagService;
import handbook.validation.TagFormValidation;
@Controller
public class TagControllerImpl implements TagController{
	final static Logger logger = Logger.getLogger(TagControllerImpl.class);
	@Autowired
	private AccountService accountService;
	@Autowired
	private TagService tagService;
	@Autowired
	private StatusService statusService;
	@Autowired
	private TagFormValidation validation;
	
	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/tags" })
	public ModelAndView readListTag(HttpServletRequest request) {
		List<Tag> readTagList = tagService.readTagList(0, 50);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("tagList", readTagList);

		modelAndView.addObject("activeClassMenu", "menu-tags");
		modelAndView.setViewName("tagList");
		return modelAndView;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/tag/add" })
	public ModelAndView initAddNewTagForm() {
		List<Status> statusList = statusService.readStatusList(1);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("statusList", statusList);
		modelAndView.setViewName("addNewTag");
		return modelAndView;
	}

	@Override
	@RequestMapping(method = RequestMethod.POST, value = { "/tag/add" })
	public ModelAndView addNewTag(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		Tag tag = buildTagData(request);
		try
		{
			validation.validate(tag);
			tagService.addNewtagList(tag);
		}
		catch (ProcessException e)
		{
			modelAndView.addObject("message", e.getMessage());
		}
		catch (ValidationException e) {
			modelAndView.addObject("message", e.getMessage());
		}
		
		List<Status> statusList = statusService.readStatusList(1);
		modelAndView.addObject("statusList", statusList);
		
		modelAndView.setViewName("addNewTag");
		return modelAndView;
	}

	private Tag buildTagData(HttpServletRequest request) {
		Tag tag = new Tag();
		tag.setTagName(request.getParameter("tagName"));
		String slug = StringUtils.replaceAll(request.getParameter("tagName"), " ", "-");
		tag.setTagNameSlug(slug);
		Status status = new Status();
		status.setStatusId(Integer.valueOf(request.getParameter("statusId")));
		tag.setStatus(status);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		User principal = (User) auth.getPrincipal();
		
		User selectedUser = accountService.readUserByUserName(principal.getUsername(), 1);
		
		tag.setCreatedByUser(selectedUser);
		tag.setLastModifiedUser(selectedUser);
		
		return tag;
	}

}
