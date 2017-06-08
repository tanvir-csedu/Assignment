package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TaskDAO;
import com.model.Task;
import com.service.TaskService;

@Service
public class TaskServiceImplementation implements TaskService {

	@Autowired
	private TaskDAO taskDAO;
	
	@Transactional
	public void add(Task task) {
		taskDAO.add(task);
	}

	@Transactional
	public void edit(Task task) {
		taskDAO.edit(task);
	}

	@Transactional
	public void delete(int taskId) {
		taskDAO.delete(taskId);
	}

	@Transactional
	public Task getTask(int taskId) {
		return taskDAO.getTask(taskId);
	}

	@Transactional
	public List getAllTasks() {
		return taskDAO.getAllTasks();
	}

}
