package my.home.pro.web;

import javax.validation.Valid;
import my.home.pro.web.service.PriceIncrease;
import my.home.pro.web.service.ProductManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class FormController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ProductManager productManager;

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView showForm() {
		ModelAndView modelAndView
				= new ModelAndView("priceincrease", "percent", new PriceIncrease());
		return modelAndView;
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public ModelAndView onSubmit(@Valid PriceIncrease percent, BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView(new RedirectView("/form.html"));
		}

		int increase = percent.getPercentage();
		logger.info("Increasing prices by " + increase + "%.");

		productManager.increasePrice(increase);

		logger.info("returning from PriceIncreaseForm view to /hello.html");

		return new ModelAndView(new RedirectView("/hello.html"));
	}

}
