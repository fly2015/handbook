package handbook.controller;

import java.util.List;

import handbook.dto.Comment;

public interface CommentController {
	List<Comment> writeComment(Integer articleId, String commentContent);
	void readCommentListByArticleSlug(Integer articleId, Integer commentStatusId, Integer userStatusId);
}
