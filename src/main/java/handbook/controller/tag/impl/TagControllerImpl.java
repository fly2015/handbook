/**
 * @author fr.quochien@gmail.com
 * @date Jul 31, 2018
 */
package handbook.controller.tag.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import handbook.constant.Pagination;
import handbook.constant.Status;
import handbook.constant.StatusType;
import handbook.controller.tag.TagController;
import handbook.dto.Tag;
import handbook.dto.User;
import handbook.exception.ProcessException;
import handbook.exception.ValidationException;
import handbook.service.AccountService;
import handbook.service.TagService;
import handbook.util.StatusUtils;
import handbook.validation.TagFormValidation;
@Controller
public class TagControllerImpl implements TagController{
	final static Logger logger = LogManager.getLogger(TagControllerImpl.class);
	@Autowired
	private AccountService accountService;
	@Autowired
	private TagService tagService;
	@Autowired
	private TagFormValidation validation;
	
	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/tags" })
	public ModelAndView readListTag(HttpServletRequest request) {
		List<Tag> readTagList = tagService.readTagList(Pagination.START_POSITION_TAG_PAGE, 
				Pagination.NUMBER_OF_ITEM_TAG_PAGE,
				Status.ENABLE.getStatus());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("tagList", readTagList);

		modelAndView.setViewName("tagList");
		return modelAndView;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/tag/add" })
	public ModelAndView initAddNewTagForm() {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("statusList", StatusUtils.getInstance().buildStatusList(StatusType.TAG));
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
			
			modelAndView.addObject("message", "Add tag sucessfully");
		}
		catch (ProcessException e)
		{
			modelAndView.addObject("message", e.getMessage());
		}
		catch (ValidationException e) {
			modelAndView.addObject("message", e.getMessage());
		}
		
		modelAndView.addObject("statusList", StatusUtils.getInstance().buildStatusList(StatusType.TAG));
		
		modelAndView.setViewName("addNewTag");
		return modelAndView;
	}

	private Tag buildTagData(HttpServletRequest request) {
		Tag tag = new Tag();
		tag.setTagName(request.getParameter("tagName"));
		String slug = StringUtils.replaceAll(request.getParameter("tagName"), " ", "-");
		tag.setTagNameSlug(slug);

		//tag.setStatusId(Integer.valueOf(request.getParameter("statusId")));
		tag.setStatusId(Status.ACTIVE.getStatus());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
		
		User selectedUser = accountService.readUserByUserName(principal.getUsername(), 1);
		
		tag.setCreatedByUser(selectedUser);
		tag.setLastModifiedUser(selectedUser);
		
		return tag;
	}

}
