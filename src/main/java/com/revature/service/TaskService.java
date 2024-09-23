package com.revature.service;

import java.util.List;

import com.revature.model.Task;

public interface TaskService {
	
	public List<Task> getAllTask();
	public List<Task> getTaskById(int id);
	public boolean createTask(Task task);
	public boolean updateTask(Task tasks);
	
}
