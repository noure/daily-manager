package ma.ensa.nour.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import ma.ensa.nour.entity.Category;
import ma.ensa.nour.entity.Product;
import ma.ensa.nour.entity.Role;
import ma.ensa.nour.entity.Task;
import ma.ensa.nour.entity.User;
import ma.ensa.nour.repository.CategoryRepository;
import ma.ensa.nour.repository.ProductRepository;
import ma.ensa.nour.repository.RoleRepository;
import ma.ensa.nour.repository.TaskRepository;
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
	TaskRepository taskRepository;

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

		Product prod1 = new Product();
		prod1.setCategory(cat1);
		prod1.setName("prod1");
		prod1.setPrice(15);

		Product prod2 = new Product();
		prod2.setCategory(cat1);
		prod2.setName("prod2");
		prod2.setPrice(15);

		Product prod3 = new Product();
		prod3.setCategory(cat2);
		prod3.setName("prod3");
		prod3.setPrice(15);

		Product prod4 = new Product();
		prod4.setCategory(cat2);
		prod4.setName("prod4");
		prod4.setPrice(15);

		productRepository.save(prod1);
		productRepository.save(prod2);
		productRepository.save(prod3);
		productRepository.save(prod4);

		Task task1 = new Task();

		task1.setTaskArchived(false);
		task1.setTaskName("Application Designing");
		task1.setTaskDescription("Application Designing");
		task1.setTaskPriority("MEDIUM");
		task1.setTaskStatus("ACTIVE");

		
		Task task2 = new Task();

		task2.setTaskArchived(true);
		task2.setTaskName("Unit Testing");
		task2.setTaskDescription("Unit Testing");
		task2.setTaskPriority("LOW");
		task2.setTaskStatus("DESACTIVE");
		
		
		Task task3 = new Task();

		task3.setTaskArchived(true);
		task3.setTaskName("Implementation");
		task3.setTaskDescription("Implementation ");
		task3.setTaskPriority("HIGHT");
		task3.setTaskStatus("ACTIVE");

		Task task4 = new Task();

		task4.setTaskArchived(true);
		task4.setTaskName("Maintenance");
		task4.setTaskDescription("Maintenance ");
		task4.setTaskPriority("HIGHT");
		task4.setTaskStatus("ACTIVE");
		
		
		
		taskRepository.save(task1);
		taskRepository.save(task2);
		taskRepository.save(task3);
		taskRepository.save(task4);
	}
}
