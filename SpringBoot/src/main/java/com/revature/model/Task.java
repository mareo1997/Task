package com.revature.model;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="TASK")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="taskSequence")
	@SequenceGenerator(name="taskSequence", sequenceName="TASK_SEQ", allocationSize=1)
	@Column(name="ID")
	@XmlAttribute
	private int id;
	
	@Column(name="TITLE")
	@XmlElement
	private String title;
	
	@Column(name="DESCRIPTION")
	@XmlElement
	private String description;
	
	@Column(name="COMPLETED")
	@XmlElement
	private boolean completed;
	
	@Column(name="CREATEDATE")
	@XmlElement
	private Date createDate;

	@Column(name="COMPLETEDDATE")
	@XmlElement
	private Date completedDate;
	
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
	public int hashCode() {
		return Objects.hash(completed, completedDate, createDate, description, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return completed == other.completed && Objects.equals(completedDate, other.completedDate)
				&& Objects.equals(createDate, other.createDate) && Objects.equals(description, other.description)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", completed=" + completed
				+ ", createDate=" + createDate + ", completedDate=" + completedDate + "]";
	}

}
