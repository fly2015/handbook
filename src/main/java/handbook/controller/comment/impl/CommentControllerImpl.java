package handbook.controller.comment.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import handbook.constant.ArticleStatus;
import handbook.constant.CommentStatus;
import handbook.controller.comment.CommentController;
import handbook.dto.Comment;
import handbook.exception.ProcessException;
import handbook.exception.ValidationException;
import handbook.service.CommentService;
import handbook.service.impl.UserAuthenticationUtil;
import handbook.validation.CommentFormValidation;

@RestController
public class CommentControllerImpl implements CommentController{
	
	private static final String MESSAGE = "message";
	@Autowired
	private CommentService commentService;
	@Autowired
	private UserAuthenticationUtil userAuthenticationUtil;
	@Autowired
	private CommentFormValidation commentFormValidation;
	@Override
	// @ResponseBody, not necessary, since class is annotated with @RestController
	// @RequestBody - Convert the json data into object (SearchCriteria) mapped by field name.
	// @JsonView(Views.Public.class) - Optional, filters json data to display.
	// @JsonView(Views.Public.class)
	@RequestMapping(method = RequestMethod.POST, value = "/comment/add"/*, produces="application/json"*/)
	public ResponseEntity<Map<String, Object>> writeComment( 
			@RequestParam(name="articleId") Integer articleId, 
			@RequestParam(name="commentContent") String commentContent) 
	{
		Comment comment = new Comment();
		comment.setArticleId(articleId);
		comment.setCommentContent(commentContent);
		comment.setStatusId(CommentStatus.ENABLE.getStatus());
		comment.setCreatedByUser(userAuthenticationUtil.readAuthenticatedUser());
		
		Map<String, Object> headers = new HashMap<>();
		
		try {
			commentFormValidation.validate(comment);
			commentService.writeComment(comment);
		} catch (ValidationException e1) {
			// TODO Auto-generated catch block
			headers.put(MESSAGE, e1.getMessage());
			//return new ResponseEntity<>(headers, HttpStatus.OK);
		} catch (ProcessException e) {
			//Write log
			headers.put(MESSAGE, "Can not write your comment!");
			//return new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		List<Comment> comments = commentService.readCommentList(articleId, ArticleStatus.ENABLE.getStatus(), CommentStatus.ENABLE.getStatus());
		if(comments.isEmpty())
		{
			headers.put(MESSAGE, "No Comment found.");
			//return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
		}

		headers.put("comments", comments);
		return new ResponseEntity<>(headers, HttpStatus.OK);
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
