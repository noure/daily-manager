package ma.ensa.nour.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import ma.ensa.nour.entity.Role;
import ma.ensa.nour.entity.User;
import ma.ensa.nour.repository.RoleRepository;
import ma.ensa.nour.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class InitDbService {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@PostConstruct
	public void init() {

		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		System.out.println("++++++++++++++ I am in the Post Constract methode init ++++++++++++++++++");

		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);

		User userAdmin = new User();
		userAdmin.setEnabled(true);
		userAdmin.setName("admin");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));
		//userAdmin.setPassword("admin");
		System.out.println( " ===================================="
				+ userAdmin.getPassword()+"====================================");
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);

		userRepository.save(userAdmin);
	}
}
