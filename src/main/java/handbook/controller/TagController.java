/**
 * @author fr.quochien@gmail.com
 * @date Jul 31, 2018
 */
package handbook.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;


public interface TagController {
	String readListTag(Model model, HttpServletRequest request);
	String callAddNewTagForm();
}
