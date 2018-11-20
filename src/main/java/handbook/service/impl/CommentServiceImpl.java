package handbook.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import handbook.dao.CommentDao;
import handbook.dto.Comment;
import handbook.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentDao commentDao;
	
	@Override
	public List<Comment> readCommentList(Integer articleId, Integer articleStatusId, Integer commentStatusId) {
		return commentDao.readCommentList(articleId, articleStatusId, commentStatusId);
	}

	@Override
	public void writeComment(Comment comment) {
		commentDao.writeComment(comment);;
	}
	
}
