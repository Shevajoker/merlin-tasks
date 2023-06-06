package com.crm.tasks.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tasks")
public class TaskEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "cteate_date")
	private Date createDate;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "title_task")
	private String titleTask;
	
	@Column(name = "text_task")
	private String textTask;
	
	@Column(name = "id_employee_do_task")
	private long idEmployeeDoTask;
	
	@Column(name = "id_employee_create_task")
	private long idEmployeeCreateTask;
	
	@Column(name = "deadline")
	private Date deadline;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private TaskStatus taskStatus;
	
}
