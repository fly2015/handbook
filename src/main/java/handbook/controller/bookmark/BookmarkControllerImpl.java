package handbook.controller.bookmark;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BookmarkControllerImpl implements BookmarkController{

	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/bookmark/add"})
	public void addBookmark(Integer articleId) {
		// TODO Auto-generated method stub
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = { "/bookmarks"})
	public ModelAndView readAccountBookmarks() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("bookmarkList");
		return modelAndView;
	}

}
