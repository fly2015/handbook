package handbook.controller.bookmark;


import org.springframework.web.servlet.ModelAndView;


public interface BookmarkController {
	void addBookmark(Integer articleId);
	ModelAndView readAccountBookmarks();
}
