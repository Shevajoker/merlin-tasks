package com.crm.tasks.dto;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TaskDto {

	private long id;
	private Date createDate;
	private Date startDate;
	private Date endDate;
	private String titleTask;
	private String textTask;
	private long idEmployeeDoTask;
	private long idEmployeeCreateTask;
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deadline;
	private String taskStatus;
}
