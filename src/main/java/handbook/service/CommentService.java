package handbook.service;

import java.util.List;


import handbook.dto.Comment;

public interface CommentService {
	List<Comment> readCommentList(Integer articleId, Integer articleStatusId, Integer commentStatusId);
	void writeComment(Comment comment);
}
