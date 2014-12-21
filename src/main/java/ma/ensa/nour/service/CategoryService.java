package ma.ensa.nour.service;

import java.util.List;

import ma.ensa.nour.entity.Category;
import ma.ensa.nour.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public void save(Category category) {
		categoryRepository.save(category);
	}

	public List<Category> findAll() {

		return categoryRepository.findAll();
	}

	public Category findByName(String name) {
	
		return categoryRepository.findByName(name);
	}

	public Category findById(int catId) {
		return categoryRepository.findOne(catId);
	}

}
