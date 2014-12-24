package ma.ensa.nour.service;

import java.util.List;

import javax.transaction.Transactional;

import ma.ensa.nour.entity.Task;
import ma.ensa.nour.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskService {

	
	@Autowired
	
	TaskRepository taskRepository;

	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	public void save(Task task) {
		taskRepository.save(task);
	}

	
	public Task findOne(int taskId){
		
		
		return taskRepository.findOne(taskId);
	}
	
	@Transactional
	public void update(Task task) {
		Task oldTask=findOne(task.getId());
		
		oldTask.setTaskArchived(task.isTaskArchived());
		oldTask.setTaskDescription(task.getTaskDescription());
		oldTask.setTaskName(task.getTaskName());
		oldTask.setTaskPriority(task.getTaskPriority());
		oldTask.setTaskStatus(task.getTaskStatus());
		
	
	}

	public void add(Task task) {
		
		taskRepository.save(task);
		
		
	}

	public void delete(int id) {
		taskRepository.delete(id);
	}

	public Task findByTaskName(String taskName) {
		return taskRepository.findByTaskName(taskName);
	}
	
	
}
