package handbook.validation;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import handbook.dto.AbstractDto;
import handbook.dto.Article;
import handbook.exception.ValidationException;

@Component
public class ArticleFormValidation implements Validation {

	@Override
	public <T extends AbstractDto> void validate(T t) throws ValidationException
	{
		Article article = (Article) t;
		if (StringUtils.isEmpty(article.getArticleTitle()))
		{
			throw new ValidationException("Tilte must be entered !");
		}
		
		if (article.getTags().isEmpty() || article.getTags().iterator().next() == null
				|| article.getTags().iterator().next().getTagId() <= 0)
		{
			throw new ValidationException("Tags must be selected !");
		}
		
		if (article.getStatus() == null && article.getStatus().getStatusId() < 0)
		{
			throw new ValidationException("Status must be selected !");
		}
		
		if (StringUtils.isEmpty(article.getArticleContent() ))
		{
			throw new ValidationException("Content must be entered !");
		}
	}

}
