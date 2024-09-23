package com.revature.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Task;

@Repository("taskRepository")
@Transactional
public interface TaskRepository extends JpaRepository<Task, Long> {

	@Query(value = "Select * from Task", nativeQuery = true)
	List<Task> getAllTask();

	@Query(value = "Select * from Task where id = ?1", nativeQuery = true)
	List<Task> getTaskById(int id);

//	void save(Task task);
	
	@Query(value = "Insert into Task (title, description, completed, createDate, completedDate) values (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
	Task saveTask(String title, String description, boolean completed, Date createDate, Date completedDate);
	

	@Query(value = "Update Task t Set t.title = ?1, t.description = ?2, t.completed = ?3, t.createDate = ?4, t.completedDate = ?5 Where t.id = ?6", nativeQuery = true)
	Task updateTask(String title, String description, boolean completed, Date createDate, Date completedDate, int id);

}
