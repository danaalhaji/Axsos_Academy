package com.axsos.projectmanager.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
@PostMapping("/login")
public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
        BindingResult result, Model model, HttpSession session) {
    User user = appService.login(newLogin, result);
    if(result.hasErrors()) {
        model.addAttribute("newUser", new User());
        return "index.jsp";
    }
    session.setAttribute("user_id", user.getId());
    return "redirect:/home";
}
@GetMapping("/home")
public String home(@ModelAttribute("project") Project project,HttpSession session, Model model,@ModelAttribute("newProject") Project newProject) {
	User Logged = appService.findUserById((Long)session.getAttribute("user_id"));
	model.addAttribute("logged", Logged);
	List<Project> projects = appService.findAllProject();
	model.addAttribute("projects", projects);
	List<Project> myProjects = Logged.getProjectsJoined();
	myProjects.addAll(Logged.getProjectsOwned());
	model.addAttribute("myProjects", myProjects);
	System.out.println(myProjects);
	return "home.jsp";
	
}
@GetMapping("/project/add")
public String addProject(@ModelAttribute("newProject") Project newProject,HttpSession session) {
	return "addProject.jsp";
}
@PostMapping("/project/submit")
public String submitProject(@Valid @ModelAttribute("newProject") Project newProject, BindingResult result, Model model,HttpSession session) {
	User Logged = appService.findUserById((Long)session.getAttribute("user_id"));
	model.addAttribute("logged", Logged);
	if(result.hasErrors()) {
		return "addProject.jsp";
	}
	else {
		newProject.setProjectAdmin(Logged);
		appService.creatProject(newProject);
		return "redirect:/home";
	}
}
@GetMapping("/project/{projectid}/join")
public String joinTeam(@PathVariable("projectid") Long id,HttpSession session ) {
	Project project = appService.findProject(id);
	User Logged = appService.findUserById((Long)session.getAttribute("user_id"));
	List<Project> myProjects= Logged.getProjectsJoined();
	myProjects.add(project);
	appService.updateProject(project);
	return "redirect:/home";
	
}
}
