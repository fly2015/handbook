package handbook.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import handbook.constant.ArticleStatus;
import handbook.constant.CommentStatus;
import handbook.controller.CommentController;
import handbook.dto.Comment;
import handbook.service.CommentService;

@Controller
public class CommentControllerImpl implements CommentController{
	
	@Autowired
	private CommentService commentService;
	
	@Override
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/comment/add")
	public List<Comment> writeComment( 
			@RequestParam(name="articleId") Integer articleId, 
			@RequestParam(name="commentContent") String commentContent) 
	{
		return commentService.readCommentList(articleId, ArticleStatus.ENABLE.getStatus(), CommentStatus.ENABLE.getStatus());
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
