package com.dao;

import java.util.List;

import com.model.Task;

public interface TaskDAO {
	public void add(Task task);
	public void edit(Task task);
	public void delete(int taskId);
	public Task getTask(int taskId);
	public List getAllTasks();
}
