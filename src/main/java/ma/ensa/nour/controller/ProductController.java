package ma.ensa.nour.controller;

import javax.validation.Valid;

import ma.ensa.nour.entity.Category;
import ma.ensa.nour.entity.Product;
import ma.ensa.nour.service.CategoryService;
import ma.ensa.nour.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@ModelAttribute("product")
	Product prodConstruct() {

		return new Product();
	}

	@RequestMapping("/prod")
	String showProduct(Model model) {

		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("products", productService.findAll());
		return "prod";
	}

	@RequestMapping(value = "/prod", method = RequestMethod.POST)
	String addCategory(@ModelAttribute("product") @Valid Product product,BindingResult result, Model m) {
		
		int catId=product.getCategory().getId();
		Category categoryOfProduct =categoryService.findById(catId);
		product.setCategory(categoryOfProduct);
		productService.save(product);
		m.addAttribute("categories", categoryService.findAll());
		return "redirect:/prod.html?CatOperation=success";
	}

}
