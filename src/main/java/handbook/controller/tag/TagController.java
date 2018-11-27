/**
 * @author fr.quochien@gmail.com
 * @date Jul 31, 2018
 */
package handbook.controller.tag;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;


public interface TagController {
	ModelAndView readListTag(HttpServletRequest request);
	ModelAndView initAddNewTagForm();
	ModelAndView addNewTag(HttpServletRequest request);
}
