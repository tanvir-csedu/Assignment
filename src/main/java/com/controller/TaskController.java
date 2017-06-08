package com.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Task;
import com.service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping("/tasks")
	public String showAlltasks(Map<String, Object> map){
		map.put("task", new Task());
		map.put("taskList", taskService.getAllTasks());
		return "task/task";
	}
	
	@RequestMapping(value="/AddUpdateTask", method=RequestMethod.POST)
	public String AddUpdateTask(@ModelAttribute Task p_task, Map<String, Object> map, HttpServletRequest p_request){
		if(p_task.getId()>0){
			taskService.edit(p_task);
		}else{
			taskService.add(p_task);
		}
		return "redirect:/tasks";
	}
	
	@RequestMapping(value="/DeleteTask/{taskId}", method=RequestMethod.GET)
	public String DeleteTask(@PathVariable("taskId") int taskId){
		taskService.delete(taskId);
		return "redirect:/tasks";
	}
}
