package handbook.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import handbook.controller.CommentController;

@Controller
public class CommentControllerImpl implements CommentController{

	@Override
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/comment/add")
	public void writeComment( 
			@RequestParam(name="articleId") String articleId, 
			@RequestParam(name="commentContent") String commentContent) 
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
