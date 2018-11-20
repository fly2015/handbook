package handbook.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import handbook.dao.CommentDao;
import handbook.dto.Comment;

@Component
public class CommentDaoImpl extends AbstractDao implements CommentDao{

	@Override
	public List<Comment> readCommentList(Integer articleId, Integer articleStatusId, Integer commentStatusId) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select cm.* from comment cm, article ar "
				+ "where cm.article_id = ar.article_id and ar.status_id = ? and cm.status_id= ? ");
		stringBuilder.append("and ar.article_id = ? ");
		stringBuilder.append("order by cm.created_date desc");
		List<Map<String, Object>> queryForList = jdbc.queryForList(stringBuilder.toString(), articleStatusId, commentStatusId, articleId);
		return buildCommentList(queryForList);
	}

	private List<Comment> buildCommentList(List<Map<String, Object>> queryForList) {
		List<Comment> comments = new ArrayList<>();
		for (Map<String, Object> map : queryForList)
		{
			comments.add(buildComment(map));
		}
		return comments;
	}

	private Comment buildComment(Map<String, Object> map) {
		Comment comment = new Comment();
		comment.setArticleId(Integer.valueOf(map.get("article_id").toString()));
		comment.setCommentId(Integer.valueOf(map.get("comment_id").toString()));
		comment.setCommentContent(map.get("comment_content").toString());
		return comment;
	}

	@Override
	public Comment readCommentbyId(Integer commentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeComment(Comment comment) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("insert into comment(article_id, comment_content , status_id, created_by_user ");
		stringBuilder.append("values(?, ?, ? ,?)");
	}
	
}
