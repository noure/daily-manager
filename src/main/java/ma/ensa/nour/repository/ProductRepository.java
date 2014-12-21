package ma.ensa.nour.repository;

import ma.ensa.nour.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	
}
