package com.axsos.projectmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.projectmanager.models.Project;
import com.axsos.projectmanager.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	List<Project> findAll();
	List<Project> findByUsersNotContains(User user);
	@Query(value="SELECT * FROM projects JOIN users WHERE projects.users_id <> ?1",  nativeQuery=true)
	List<Project> findByUsersNotContainsProjectAdmin(Long id);
}
