package ma.ensa.nour.repository;

import ma.ensa.nour.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Integer> {

}
