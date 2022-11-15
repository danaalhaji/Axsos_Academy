package com.axsos.projectmanager.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.projectmanager.models.LoginUser;
import com.axsos.projectmanager.models.Project;
import com.axsos.projectmanager.models.User;
import com.axsos.projectmanager.service.AppService;

@Controller
public class MainController {
 private final AppService appService;

public MainController(AppService appService) {
	this.appService = appService;
}

@GetMapping("/")
public String index(Model model) {
    model.addAttribute("newUser", new User());
    model.addAttribute("newLogin", new LoginUser());
    return "index.jsp";
}
// register new user
@PostMapping("/register")
public String register(@Valid @ModelAttribute("newUser") User newUser, 
        BindingResult result, Model model, HttpSession session) {
	appService.register(newUser, result);
    if(result.hasErrors()) {
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    session.setAttribute("user_id", newUser.getId());
    return "redirect:/home";
}
// login for old users
@PostMapping("/login")
public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
        BindingResult result, Model model, HttpSession session) {
	// validations
    User user = appService.login(newLogin, result);
    if(result.hasErrors()) {
        model.addAttribute("newUser", new User());
        return "index.jsp";
    }
    // success
    session.setAttribute("user_id", user.getId());
    return "redirect:/home";
}

// ************render home page **********************
@GetMapping("/home")
public String home(@ModelAttribute("project") Project project,HttpSession session, Model model,@ModelAttribute("newProject") Project newProject) {
	// get logged in user****
	User Logged = appService.findUserById((Long)session.getAttribute("user_id"));
	model.addAttribute("logged", Logged);
	//***** Retrieve all projects not the logged user is in****
	
	List<Project> projects = appService.notInProject(Logged);
	for (Project i : projects) {
	System.out.println(i.getTitle());
	}
	model.addAttribute("projects", projects);

	List<Project> myProjects = Logged.getProjectsJoined();
	myProjects.addAll(Logged.getProjectsOwned());
	model.addAttribute("myProjects", myProjects);
	return "home.jsp";
	
}
//**************** render create page*******************
@GetMapping("/project/add")
public String addProject(@ModelAttribute("newProject") Project newProject,HttpSession session) {
	return "addProject.jsp";
}

//***************** submit project ************************
@PostMapping("/project/submit")
public String submitProject(@Valid @ModelAttribute("newProject") Project newProject, BindingResult result, Model model,HttpSession session) {
	User Logged = appService.findUserById((Long)session.getAttribute("user_id"));
	//***** validation for project******
	
	model.addAttribute("logged", Logged);
	if(result.hasErrors()) {
		return "addProject.jsp";
	}
	//**** submit if correct /*******
	else {
		newProject.setProjectAdmin(Logged);
		appService.creatProject(newProject);
		System.out.println(newProject.getProjectAdmin().getUserName());
		return "redirect:/home";
	}
}
//*****************join to project*******************
@GetMapping("/project/{projectid}/join")
public String joinTeam(@PathVariable("projectid") Long id,HttpSession session ) {
	Project project = appService.findProject(id);
	User Logged = appService.findUserById((Long)session.getAttribute("user_id"));
	// add to team
	List<Project> myProjects= Logged.getProjectsJoined();
	myProjects.add(project);
	// save the edit
	appService.updateProject(project);
	return "redirect:/home";
	
}
//**********Leave team ****************

@GetMapping("/project/{projectid}/leave")
public String leaveTeam(@PathVariable("projectid") Long id,HttpSession session ) {
	Project project = appService.findProject(id);
	User Logged = appService.findUserById((Long)session.getAttribute("user_id"));
	List<Project> myProjects= Logged.getProjectsJoined();
	myProjects.remove(project);
	appService.updateProject(project);
	return "redirect:/home";
}
//************Log out ****************
@GetMapping("/logout")
public String logout(HttpSession session) { 
	//**** clear session ***//
        session.invalidate();
        return "redirect:/";

}

}
