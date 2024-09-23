package com.revature.model.dto;

import java.sql.Date;

public class TaskDTO {
	
	private int id;

	private String title;
	
	private String description;
	
	private boolean completed;
	
	private Date createDate;

	private Date completedDate;

	public TaskDTO(int id, String title, String description, boolean completed, Date createDate, Date completedDate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.completed = completed;
		this.createDate = createDate;
		this.completedDate = completedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	@Override
	public String toString() {
		return "TaskDTO [id=" + id + ", title=" + title + ", description=" + description + ", completed=" + completed
				+ ", createDate=" + createDate + ", completedDate=" + completedDate + "]";
	}
	
	

}