package ma.ensa.nour.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import ma.ensa.nour.entity.Category;
import ma.ensa.nour.entity.Product;
import ma.ensa.nour.entity.Role;
import ma.ensa.nour.entity.User;
import ma.ensa.nour.repository.CategoryRepository;
import ma.ensa.nour.repository.ProductRepository;
import ma.ensa.nour.repository.RoleRepository;
import ma.ensa.nour.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class InitDbService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@PostConstruct
	public void init() {

		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		System.out
				.println("++++++++++++++ I am in the Post Constract methode init ++++++++++++++++++");

		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);

		User userAdmin = new User();
		userAdmin.setEnabled(true);
		userAdmin.setName("admin");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));
		// userAdmin.setPassword("admin");
		System.out.println(" ===================================="
				+ userAdmin.getPassword()
				+ "====================================");

		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);

		userRepository.save(userAdmin);

		Category cat1 = new Category();
		cat1.setName("first");
		cat1.setDescription("a bref description of category one");
		categoryRepository.save(cat1);

		Category cat2 = new Category();
		cat2.setName("second");
		cat2.setDescription("a bref description of category two");
		categoryRepository.save(cat2);
		
		Product prod1 =new Product();
		prod1.setCategory(cat1);
		prod1.setName("prod1");
		prod1.setPrice(15);
		
		
		Product prod2 =new Product();
		prod2.setCategory(cat1);
		prod2.setName("prod2");
		prod2.setPrice(15);
		
		Product prod3 =new Product();
		prod3.setCategory(cat2);
		prod3.setName("prod3");
		prod3.setPrice(15);
		
		Product prod4 =new Product();
		prod4.setCategory(cat2);
		prod4.setName("prod4");
		prod4.setPrice(15);
		
		productRepository.save(prod1);
		productRepository.save(prod2);
		productRepository.save(prod3);
		productRepository.save(prod4);

	}
}
