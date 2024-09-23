package com.revature.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.ajax.ClientMessage;
import com.revature.model.Task;
import com.revature.model.dto.TaskDTO;

public interface TaskController {

	public ResponseEntity<List<TaskDTO>> getAllTask();
	public ResponseEntity<List<TaskDTO>> getTaskById(@RequestParam int id);
	public ResponseEntity<ClientMessage> createTask(@RequestBody Task tasks);
	public ResponseEntity<ClientMessage> updateTask(@RequestBody Task tasks);
}
