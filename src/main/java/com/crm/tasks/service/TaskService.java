package com.crm.tasks.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.tasks.entity.TaskEntity;

public interface TaskService extends JpaRepository<TaskEntity, Long>{

	//List<TaskEntity> findAllByIdEmployeeDoTask(Long id);
	List<TaskEntity> findByIdEmployeeDoTask(long idEmployeeDoTask);

}
