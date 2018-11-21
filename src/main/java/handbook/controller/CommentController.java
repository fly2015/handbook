package handbook.controller;

import java.util.List;

import handbook.controller.response.CommentResponse;
import handbook.dto.Comment;

public interface CommentController {
	CommentResponse writeComment(Integer articleId, String commentContent);
	List<Comment> readCommentListByArticleSlug(Integer articleId, Integer commentStatusId, Integer userStatusId);
}
