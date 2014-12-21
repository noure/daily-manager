package ma.ensa.nour.service;

import java.util.List;

import ma.ensa.nour.entity.Product;
import ma.ensa.nour.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

	
	@Autowired
	ProductRepository productRepository;
	public void save(Product product){
		
		productRepository.save(product);
	}
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
}
