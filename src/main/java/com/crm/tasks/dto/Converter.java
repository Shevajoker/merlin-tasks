package com.crm.tasks.dto;

import com.crm.tasks.entity.TaskEntity;

public class Converter {
	
	
	public static TaskDto taskEntityToTaskDto(TaskEntity taskEntity) {
		TaskDto taskDto = new TaskDto();
		taskDto.setId(taskEntity.getId());
		taskDto.setCreateDate(taskEntity.getCreateDate());
		taskDto.setEndDate(taskEntity.getEndDate());
		taskDto.setStartDate(taskEntity.getStartDate());
		taskDto.setIdEmployeeCreateTask(taskEntity.getIdEmployeeCreateTask());
		taskDto.setIdEmployeeDoTask(taskEntity.getIdEmployeeDoTask());
		taskDto.setTitleTask(taskEntity.getTitleTask());
		taskDto.setTextTask(taskEntity.getTextTask());
		taskDto.setDeadline(taskEntity.getDeadline());
		taskDto.setTaskStatus(taskEntity.getTaskStatus().toString());
		
		
		return taskDto;
	}
	
	public static TaskEntity taskDtoToTaskEntity(TaskDto taskDto) {
		TaskEntity taskEntity = new TaskEntity();
		
		taskEntity.setId(taskDto.getId());
		taskEntity.setCreateDate(taskDto.getCreateDate());
		taskEntity.setEndDate(taskDto.getEndDate());
		taskEntity.setStartDate(taskDto.getStartDate());
		taskEntity.setIdEmployeeCreateTask(taskDto.getIdEmployeeCreateTask());
		taskEntity.setIdEmployeeDoTask(taskDto.getIdEmployeeDoTask());
		taskEntity.setTitleTask(taskDto.getTitleTask());
		taskEntity.setTextTask(taskDto.getTextTask());
		taskEntity.setDeadline(taskDto.getDeadline());
		//taskEntity.setTaskStatus(TaskStatus.NEW);
		
		
		
		return taskEntity;
	}
	

}
