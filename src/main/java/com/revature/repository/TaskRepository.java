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

	@Query(value = "Select * from TASK", nativeQuery = true)
	List<Task> getAllTask();

	@Query(value = "Select * from TASK where ID = ?1", nativeQuery = true)
	List<Task> getTaskById(int id);

//	void save(Task task);
	
	@Query(value = "Insert into TASK (TITLE, DESCRIPTION, COMPLETED, CREATEDATE, COMPLETEDDATE) values (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
	Task saveTask(String title, String description, boolean completed, Date createDate, Date completedDate);
	

	@Query(value = "Update TASK t Set t.TITLE = ?1, t.DESCRIPTION = ?2, t.COMPLETED = ?3, t.CREATEDATE = ?4, t.COMPLETEDDATE = ?5 Where t.ID = ?6", nativeQuery = true)
	Task updateTask(String title, String description, boolean completed, Date createDate, Date completedDate, int id);

}
