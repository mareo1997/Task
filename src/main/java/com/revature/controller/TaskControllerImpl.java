package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ajax.ClientMessage;
import com.revature.ajax.ClientMessageUtil;
import com.revature.model.Task;
import com.revature.model.dto.TaskDTO;
import com.revature.service.TaskService;

@RestController("taskController")
@RequestMapping("/tasks")
public class TaskControllerImpl implements TaskController {
	
//	private final TaskService taskService;
//	
//	public TaskController(TaskService taskService) {
//		this.taskService = taskService;
//	}
//	
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public ResponseEntity<List<TaskDTO>> getAllTask(){
		List<TaskDTO> body = null;
		List<Task> tasks = this.taskService.getAllTask();
		
		if(tasks == null || tasks.isEmpty()) {
			return new ResponseEntity<>(body, HttpStatus.NO_CONTENT);
		} else {
			body = new ArrayList<>();
			
			for(Task t: tasks) {
				body.add(new TaskDTO(t.getId(), t.getTitle(), t.getDescription(), t.isCompleted(), t.getCreateDate(), t.getCompletedDate()));
			}
		}
		
		return new ResponseEntity<>(body, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<TaskDTO>> getTaskById(@PathVariable("id") int id){
		List<TaskDTO> body = null;
		Task tasks = this.taskService.getTaskById(id);
		
		if(tasks == null) {
			return new ResponseEntity<>(body, HttpStatus.NO_CONTENT);
		} else {
			body = new ArrayList<>();
			
//			for(Task t: tasks) {
				body.add(new TaskDTO(tasks.getId(), tasks.getTitle(), tasks.getDescription(), tasks.isCompleted(), tasks.getCreateDate(), tasks.getCompletedDate()));
//			}
		}
		
		return new ResponseEntity<>(body, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ClientMessage> createTask(@RequestBody Task tasks){
		
//		boolean result = taskService.createTask(tasks);
//		
//		if(result) {
//			return ResponseEntity.ok(tasks);
//		} else {
//			return new ResponseEntity<>(tasks, HttpStatus.NO_CONTENT);			
//		}
		
		return (taskService.createTask(tasks)) ? 
				new ResponseEntity<>(ClientMessageUtil.REGISTRATION_SUCCESSFUL, HttpStatus.OK) :
				new ResponseEntity<>(ClientMessageUtil.INVALID_DATA, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/id")
	public ResponseEntity<ClientMessage> updateTask(/*@PathVariable("id") int id,*/ @RequestBody Task tasks){
		
//		boolean result = taskService.updateTask(tasks);
//		
//		if(result) {
//			return ResponseEntity.ok(tasks);
//		} else {
//			return new ResponseEntity<>(tasks, HttpStatus.NO_CONTENT);			
//		}
		
		return (taskService.updateTask(tasks)) ? 
				new ResponseEntity<>(ClientMessageUtil.UPDATE_SUCCESSFUL, HttpStatus.OK) :
				new ResponseEntity<>(ClientMessageUtil.INVALID_DATA, HttpStatus.BAD_REQUEST);

		
//		return (TaskService.)) ? 
//				new ResponseEntity<>(REGISTRATION_SUCCESSFUL, HttpStatus.OK) :
//				new ResponseEntity<>(INVALID_DATA, HttpStatus.BAD_REQUEST);

	}

//	@Override
//	public ResponseEntity<ClientMessage> updateTask(Task tasks) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
