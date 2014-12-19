package ma.ensa.nour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

	@RequestMapping("/prod")
	public String index() {
		return "prod";
	}

}
