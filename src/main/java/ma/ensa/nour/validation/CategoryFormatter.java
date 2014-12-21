package ma.ensa.nour.validation;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import ma.ensa.nour.entity.Category;
import ma.ensa.nour.service.CategoryService;


@Component
public class CategoryFormatter implements Formatter<Category> {

	@Autowired
	CategoryService categoryService;
	
	
	@Override
	public String print(Category cat, Locale arg1) {

		return cat.getName();
	}

	@Override
	public Category parse(String name, Locale arg1) throws ParseException {
		
		return categoryService.findByName(name);
	}

}
