package com.crm.tasks.service;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.crm.tasks.entity.TaskEntity;
import com.crm.tasks.entity.TaskStatus;

public interface TaskService extends JpaRepository<TaskEntity, Long>{

	//List<TaskEntity> findAllByIdEmployeeDoTask(Long id);
	List<TaskEntity> findByIdEmployeeDoTask(String id);
	
	TaskEntity findById(long id);
	
//	@Modifying
//    @Query("UPDATE tasks SET status = :taskStatus WHERE id = :id")
//	void updateTask(long id, TaskStatus taskStatus);

	
}
