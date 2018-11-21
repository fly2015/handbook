package handbook.controller.response;

import java.util.List;

import handbook.dto.Comment;

public class CommentResponse extends AbstractResponse {
	private List<Comment> comments;

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
