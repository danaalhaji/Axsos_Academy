package com.axsos.lookify.controller;

import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.lookify.models.Lookify;
import com.axsos.lookify.repository.LookifyRepository;
import com.axsos.lookify.services.AppService;


@Controller
public class AppController {
	private final AppService appService;

	public AppController(AppService appService) {
		this.appService = appService;
	}
	//Render index
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	//Render Home page 
	@GetMapping("/home")
	public String home() {
		return "home.jsp";
	}
	//render add a new song page
	@GetMapping("/song/new")
	public String addNew(@ModelAttribute("newSong")Lookify newSong, Model model) {
		return "addSong.jsp";	
	}
	// submit the new song
	@PostMapping("/book/submitnew")
	public String submitNewSong(@Valid @ModelAttribute("newSong")Lookify newSong, BindingResult result) {
		if(result.hasErrors()) {
			return "addSong.jsp";
		}
		else {
			appService.create(newSong);
			return "redirect:/home";
		}	
	}
	// get top 10 songs by rating
	@GetMapping("/top10")
	public String topTen(Model model) {
		System.out.println(appService.topTen());	
		return"redirect:/home";
	}
}
