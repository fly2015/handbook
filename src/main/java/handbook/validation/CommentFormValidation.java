package handbook.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import handbook.dto.AbstractDto;
import handbook.dto.Comment;
import handbook.exception.ValidationException;

@Component
public class CommentFormValidation implements Validation{

	@Override
	public <T extends AbstractDto> void validate(T t) throws ValidationException {
		// TODO Auto-generated method stub
		Comment comment = (Comment) t;
		if(comment == null)
		{
			throw new ValidationException("Comment must be not null.");
		}
		
		if(comment.getArticleId() == null)
		{
			throw new ValidationException("Article must not be null.");
		}
		
		if(StringUtils.isEmpty(comment.getCommentContent()))
		{
			throw new ValidationException("Please enter comment content");
		}
		
		if(comment.getCommentContent().length() <16 || comment.getCommentContent().length()> 5000)
		{
			throw new ValidationException("Content must be greater than 5 and lower than 5000 charactors");
		}
	}

}
