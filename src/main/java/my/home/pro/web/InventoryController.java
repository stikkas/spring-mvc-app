package my.home.pro.web;

import java.util.HashMap;
import java.util.Map;
import my.home.pro.web.service.ProductManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(value = {"sessionForm", "commandName", "commandClass"})
public class InventoryController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ProductManager productManager;

	@RequestMapping("/hello.html")
	public ModelAndView hello() {

		String now = (new java.util.Date()).toString();
		logger.info("returning hello view with " + now);

		Map<String, Object> myModel = new HashMap<>();
		myModel.put("now", now);
		myModel.put("products", productManager.getProducts());

		return new ModelAndView("hello", "model", myModel);
	}

}
