package com.crm.tasks.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crm.tasks.dto.Converter;
import com.crm.tasks.dto.TaskDto;
import com.crm.tasks.entity.TaskEntity;
import com.crm.tasks.entity.TaskStatus;
import com.crm.tasks.service.TaskService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/v1/task")
public class MainController {
	
	@Autowired
	TaskService taskService;
	

	@GetMapping
	public String test () {
		return "HEllo";
	} 
	
	@PostMapping("/save")
	@ResponseBody
	public TaskDto saveTask(@RequestBody TaskDto taskDto) {
		log.info(taskDto);
		
		TaskEntity taskEntity = new TaskEntity();
		
		taskDto.setCreateDate(new Date());
		
		taskEntity = Converter.taskDtoToTaskEntity(taskDto);
		taskEntity.setTaskStatus(TaskStatus.NEW);	
		taskService.save(taskEntity);
		
		log.info(taskEntity);
		return taskDto;
	}
	
	
	@GetMapping("/allTasks/{id}")
	@CircuitBreaker(name = "breaker", fallbackMethod = "defoultTask")
	public List<TaskDto> allTasks(@PathVariable Long id) throws TimeoutException{
		log.info(id);

		List<TaskEntity> taskEntities = taskService.findByIdEmployeeDoTask(id);
		List<TaskDto> taskDtos = new ArrayList<>();
		
		for (TaskEntity entity : taskEntities) {
			taskDtos.add(Converter.taskEntityToTaskDto(entity));
		}
		

		return taskDtos;
	}
	
	public List<TaskDto> defoultTask(@PathVariable Long id, Throwable t){
		List<TaskDto> resList = new ArrayList<>();
		resList.add(new TaskDto());
		return resList;
	}
	

	
}
