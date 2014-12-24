package ma.ensa.nour.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import ma.ensa.nour.validation.UniqueTaskname;


@Entity
public class Task {

	@Id
	@GeneratedValue
	private int id;
	
	@UniqueTaskname(message=" this task already exists ! ")
	@Size(min=3,message="the task name length must be at least 3 characters")
	private String taskName;
	
	@Lob
	@Type(type="org.hibernate.type.StringClobType")
	@Column(length=Integer.MAX_VALUE)
	private String taskDescription;
	
	@Column(nullable=false)
	private String taskPriority;
	
	private String taskStatus;
	
	private boolean taskArchived = false;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public boolean isTaskArchived() {
		return taskArchived;
	}

	public void setTaskArchived(boolean taskArchived) {
		this.taskArchived = taskArchived;
	}
	


}
