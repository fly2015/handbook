package hanbook.validation;

import javax.xml.bind.ValidationException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import handbook.dto.Article;

@Component
public class ArticleValidation {
	public void validateForm(Article article) throws ValidationException {
		if (StringUtils.isEmpty(article.getArticleTitle()))
		{
			throw new ValidationException("Article tilte must be entered !");
		}
	}

}
