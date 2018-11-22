package handbook.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import handbook.dto.Comment;

public interface CommentController {
	ResponseEntity<?> writeComment(Integer articleId, String commentContent);
	List<Comment> readCommentListByArticleSlug(Integer articleId, Integer commentStatusId, Integer userStatusId);
}
