package ma.ensa.nour.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import ma.ensa.nour.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class UniqueTasknameValidator implements
ConstraintValidator<UniqueTaskname, String>{
	@Autowired
	TaskRepository taskRepository;
	
	
	@Override
	public void initialize(UniqueTaskname constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(taskRepository==null) return true;
		
		return taskRepository.findByTaskName(value)==null;
	}

}
