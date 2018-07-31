/**
 * @author fr.quochien@gmail.com
 * @date Jul 31, 2018
 */
package handbook.controller.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import handbook.controller.HelperController;
import handbook.dto.Tag;
import handbook.service.TagService;
@Controller
public class HelperControllerImpl implements HelperController{
	@Autowired
	private TagService tagService;

	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/help" })
	public String findHelper(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<Tag> readTagList = tagService.readTagList();
		model.addAttribute("tagList", readTagList);
		return "help";
	}

}
