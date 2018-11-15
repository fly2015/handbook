package handbook.controller;

public interface CommentController {
	void writeComment(String articleId, String commentContent);
	void readCommentListByArticleSlug(Integer articleId, Integer commentStatusId, Integer userStatusId);
}
