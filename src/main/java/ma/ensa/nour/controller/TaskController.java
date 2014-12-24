package ma.ensa.nour.controller;


import javax.validation.Valid;

import ma.ensa.nour.entity.Task;
import ma.ensa.nour.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {

	@Autowired
	TaskService taskService;

	@RequestMapping("/task")
	String addTask(Model model) {
		init(model);
		return "task";
	}

	public void init(Model model) {

		String[] stt = new String[] { "ACTIVE", "SUSPENDED", "DESACTIVE" };
		String[] pr = new String[] { "HIGHT", "MEDIUM", "LOW" };

		model.addAttribute("priorities", pr);
		model.addAttribute("stt", stt);
		model.addAttribute("tasks", taskService.findAll());
	}

	@ModelAttribute("task")
	Task taskConstruct() {
		return new Task();
	}

	@RequestMapping(value = "/task.do", method = RequestMethod.POST)
	String actionTask(@Valid @ModelAttribute("task") Task task,BindingResult result,
			@RequestParam String action, Model model) {
		if(result.hasErrors()){
			return "task";
		}
		Task resultTask;
		switch (action.toLowerCase()) {
		case "add":
			taskService.add(task);
			resultTask = task;
			init(model);
			model.addAttribute("task", resultTask);
			return "redirect:/task.html?add=succes";
		case "edit":
			taskService.update(task);
			System.out.println("id task editing = "+ task.getId());
			resultTask = task;
			init(model);
			model.addAttribute("task", resultTask);
			return "redirect:/task.html?update=succes";

		case "delete":
			taskService.delete(task.getId());
			init(model);
			return "redirect:/task.html?delete=succes";

		case "search":
			Task searchedTask = taskService.findByTaskName(task.getTaskName());
			init(model);
			resultTask = searchedTask != null ? searchedTask : new Task();
			model.addAttribute("task", resultTask);
			return "task";
		}
		return null;
	}

}
