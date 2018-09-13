/**
 * @author fr.quochien@gmail.com
 * @date Jul 31, 2018
 */
package handbook.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;


public interface TagController {
	String readListTag(Model model, HttpServletRequest request);
	ModelAndView initAddNewTagForm();
	ModelAndView addNewTag(HttpServletRequest request);
}
