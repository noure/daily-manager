package ma.ensa.nour.repository;

import ma.ensa.nour.entity.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	Task findByTaskName(String taskName);

}
