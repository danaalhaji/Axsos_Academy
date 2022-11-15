package com.axsos.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.axsos.projectmanager.models.Project;
import com.axsos.projectmanager.models.Task;
import com.axsos.projectmanager.models.User;

public interface TaskRepository extends CrudRepository<Task, Long>{
	List<Task> findAll();
	List<Task> findAllByProject(Project project);
	List<Task> findAllBycreator(User user);
}
