package ma.ensa.nour.controller;

import javax.validation.Valid;

import ma.ensa.nour.entity.Category;
import ma.ensa.nour.service.CategoryService;
import ma.ensa.nour.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;

	@ModelAttribute("category")
	Category catConstruct() {

		return new Category();

	}

	@RequestMapping(value = "/cat")
	String showProd(Model m) {

		m.addAttribute("categotries", categoryService.findAll());
		return "cat";
	}

	@RequestMapping(value = "/cat", method = RequestMethod.POST)
	String addCategory(@Valid @ModelAttribute("category") Category category,
			BindingResult result, Model m) {
		if (result.hasErrors()) {
			return "cat";
		}
		categoryService.save(category);
		m.addAttribute("categories", categoryService.findAll());
		return "redirect:/cat.html?CatOperation=success";
	}

}
