package handbook.controller.article;

import org.springframework.http.ResponseEntity;

public interface ArticleSearchController {
	ResponseEntity<?> searchArticles(String searchString);
}
