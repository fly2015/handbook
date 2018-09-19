package handbook.validation;

import javax.xml.bind.ValidationException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import handbook.dto.Article;

@Component
public class ArticleValidation {
	public void validateForm(Article article) throws ValidationException {
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
