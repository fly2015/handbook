package handbook.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import handbook.controller.CommentController;

@Controller
public class CommentControllerImpl implements CommentController{

	@Override
	@ModelAttribute
	@RequestMapping(method = RequestMethod.POST, value = { "/comment/add" })
	public void writeComment( 
			@RequestParam String articleId, 
			@RequestParam String commentContent) 
	{
		System.out.println("Add Comment");
	}

	@Override
	public void readCommentListByArticleSlug(
			@RequestParam Integer articleId, 
			@RequestParam Integer commentStatusId, 
			@RequestParam Integer userStatusId)
	{
		// TODO Auto-generated method stub
		
	}

}
