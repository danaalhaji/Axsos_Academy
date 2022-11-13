package com.axsos.projectmanager.service;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.axsos.projectmanager.models.LoginUser;
import com.axsos.projectmanager.models.Project;
import com.axsos.projectmanager.models.User;
import com.axsos.projectmanager.repositories.ProjectRepository;
import com.axsos.projectmanager.repositories.UserRepository;

@Service
public class AppService {
	private final ProjectRepository projectRepo;
	private final UserRepository userRepo;
	public AppService(ProjectRepository projectRepo, UserRepository userRepo) {
		this.projectRepo = projectRepo;
		this.userRepo = userRepo;
	}
	
	// create new users
	public User register(User newUser, BindingResult result) {
        if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
            result.rejectValue("email", "Unique", "This email is already in use!");
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepo.save(newUser);
        }
    }
    // login
    public User login(LoginUser newLogin, BindingResult result) {
        if(result.hasErrors()) {
            return null;
        }
        Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
        if(!potentialUser.isPresent()) {
            result.rejectValue("email", "Unique", "Unknown email!");
            return null;
        }
        User user = potentialUser.get();
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            return user;
        }
    }
    // find users by id
    public User findUserById(Long id) {
        Optional<User> u = userRepo.findById(id);

        if(u.isPresent()) {
            return u.get();
            } else {
            return null;
        }
    }
    // find user by email
    public Optional<User> findByEmail(String email) {
    	return userRepo.findByEmail(email);
    }
    // find all project
    public List<Project> findAllProject(){
    	return projectRepo.findAll();
    }
    //find a project
    public Project findProject(Long id) {
        Optional<Project> optionalProject = projectRepo.findById(id);
        if(optionalProject.isPresent()) {
            return optionalProject.get();
        } else {
            return null;
        }
    }
    // create a project
    public Project creatProject(Project project) {
    	
    	return projectRepo.save(project);
    }
    //update project
    public Project updateProject(Project project) {
    	return projectRepo.save(project);
    }
    // find users not in project
    public List<Project> notInProject(User user) {
    	return projectRepo.findByUsersNotContains(user);
    }
    // add team member
    public Project addToTeam(User user, Project project) {
    	List <User> team = project.getUsers();
    	team.add(user);
    	project.setUsers(team);
    	return projectRepo.save(project);
    }
    // un-join
    public Project unJoin(User user, Project project) {
    	List <User> team = project.getUsers();
    	team.remove(user);
    	project.setUsers(team);
    	return projectRepo.save(project);	
    }
    // delete project
    public void deleteProject(Project project) {
    	 projectRepo.delete(project);
    }
}
