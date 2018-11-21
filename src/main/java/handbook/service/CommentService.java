package handbook.service;

import java.util.List;


import handbook.dto.Comment;
import handbook.exception.ProcessException;

public interface CommentService {
	List<Comment> readCommentList(Integer articleId, Integer articleStatusId, Integer commentStatusId);
	void writeComment(Comment comment) throws ProcessException;
}
