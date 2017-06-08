package com.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.TaskDAO;
import com.model.Task;

@Repository
public class TaskDAOImplementation implements TaskDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Task task) {
		session.getCurrentSession().save(task);
	}

	@Override
	public void edit(Task task) {
		session.getCurrentSession().update(task);
	}

	@Override
	public void delete(int taskId) {
		session.getCurrentSession().delete(getTask(taskId));
	}

	@Override
	public Task getTask(int taskId) {
		return (Task)session.getCurrentSession().get(Task.class, taskId);
	}

	@Override
	public List getAllTasks() {
		return session.getCurrentSession().createQuery("from Task").list();
	}

}
