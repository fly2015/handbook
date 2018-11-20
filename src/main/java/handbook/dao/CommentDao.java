package handbook.dao;

import java.util.List;

import handbook.dto.Comment;

public interface CommentDao {
	List<Comment> readCommentList(Integer articleId, Integer articleStatusId, Integer commentStatusId);
	Comment readCommentbyId(Integer commentId);
	void writeComment(Comment comment);
}
