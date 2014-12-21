package ma.ensa.nour.repository;

import ma.ensa.nour.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category findByName(String name);

}
