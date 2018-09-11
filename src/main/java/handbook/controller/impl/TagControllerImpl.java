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

import handbook.controller.TagController;
import handbook.dto.Tag;
import handbook.service.TagService;
@Controller
public class TagControllerImpl implements TagController{
	@Autowired
	private TagService tagService;

	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/tags" })
	public String readListTag(Model model, HttpServletRequest request) {
		List<Tag> readTagList = tagService.readTagList(0, 50);
		model.addAttribute("tagList", readTagList);
		return "tagList";
	}

}
