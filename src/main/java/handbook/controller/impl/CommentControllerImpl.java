package handbook.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import handbook.constant.ArticleStatus;
import handbook.constant.CommentStatus;
import handbook.controller.CommentController;
import handbook.controller.response.CommentResponse;
import handbook.dto.Comment;
import handbook.exception.ProcessException;
import handbook.service.AuthenticationUtil;
import handbook.service.CommentService;

@RestController
public class CommentControllerImpl implements CommentController{
	
	@Autowired
	private CommentService commentService;
	@Autowired
	private AuthenticationUtil authenticationUtil;
	
	@Override
	// @ResponseBody, not necessary, since class is annotated with @RestController
	// @RequestBody - Convert the json data into object (SearchCriteria) mapped by field name.
	// @JsonView(Views.Public.class) - Optional, filters json data to display.
	// @JsonView(Views.Public.class)
	@RequestMapping(method = RequestMethod.POST, value = "/comment/add"/*, produces="application/json"*/)
	public CommentResponse writeComment( 
			@RequestParam(name="articleId") Integer articleId, 
			@RequestParam(name="commentContent") String commentContent) 
	{
		CommentResponse response = new CommentResponse();
		Comment comment = new Comment();
		comment.setArticleId(articleId);
		comment.setCommentContent(commentContent);
		comment.setStatusId(CommentStatus.ENABLE.getStatus());
		comment.setCreatedByUser(authenticationUtil.readAuthenticatedUser());
		
		try {
			commentService.writeComment(comment);
		} catch (ProcessException e) {
			// write log
			response.setMessage(e.getMessage());
			response.setMsgCode("500");
			return response;
		}
		
		List<Comment> comments = commentService.readCommentList(articleId, ArticleStatus.ENABLE.getStatus(), CommentStatus.ENABLE.getStatus());
		if(comments.isEmpty())
		{
			response.setMessage("No comment found.");
			response.setMsgCode("204");
			return response;	
		}
		
		response.setComments(comments);
		return response;
	}

	@Override
	public List<Comment> readCommentListByArticleSlug(
			@RequestParam Integer articleId, 
			@RequestParam Integer commentStatusId, 
			@RequestParam Integer userStatusId)
	{
		return commentService.readCommentList(articleId, ArticleStatus.ENABLE.getStatus(), CommentStatus.ENABLE.getStatus());
	}

}
