package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Task;
import com.revature.repository.TaskRepository;

@Service("taskService")
public class TaskServiceImpl implements TaskService {
	
//	private final TaskRepository taskRepository;
//	
//	public TaskService(TaskRepository taskRepository) {
//		this.taskRepository = taskRepository;
//	}
	
	@Autowired
	private TaskRepository taskRepository;

	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		
		return taskRepository.getAllTask();
		
//		return null;
	}

	public Task getTaskById(int id) {
		// TODO Auto-generated method stub
		
		try {
			List<Task> list = taskRepository.getTaskById(id);
			
			return list.get(0);
		} catch (NullPointerException e) {
			return null;
		} catch (IndexOutOfBoundsException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
		
	}

	public boolean createTask(Task tasks) {
		// TODO Auto-generated method stub
		
		try {
			taskRepository.saveTask(tasks.getTitle(), tasks.getDescription(), tasks.isCompleted(), tasks.getCreateDate(), tasks.getCompletedDate());
			return tasks.getId() != 0;
		} catch (NullPointerException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
		
//		List<Task> t = taskRepository.getTaskById(task.getId());
//		
//		if(t.size() == 1) {
//			return true;
//		} else {
//			return false;
//		}
	}

	public boolean updateTask(Task tasks) {
		// TODO Auto-generated method stub
		
		try {
			List<Task> t1 = taskRepository.getTaskById(tasks.getId());
			
			 taskRepository.updateTask(tasks.getTitle(), tasks.getDescription(), tasks.isCompleted(), tasks.getCreateDate(), tasks.getCompletedDate(), tasks.getId());
			//	Task updateTask(String title, String description, boolean completed, Date createDate, Date completedDate, int id);
			  
//			taskRepository.save(tasks);
			 
			List<Task> t2 = taskRepository.getTaskById(tasks.getId());
			
			if(t1.get(0).equals(t2.get(0))) {
				return false;
			} else {
				return true;
			}
				
//			if(t.size() == 1) {
//				return true;
//			} else {
//				return false;
//			}			
		} catch (NullPointerException e) {
//			e.printStackTrace(s);
			return false;
		} catch (Exception e) {
			return false;
		}

	}

}
