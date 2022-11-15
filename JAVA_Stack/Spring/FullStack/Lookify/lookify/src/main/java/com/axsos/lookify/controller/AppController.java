package com.axsos.lookify.controller;

import java.util.List;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String home(Model model) {	
		List<Lookify> songs = appService.findAll();
		model.addAttribute("songs", songs);
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
	
	@GetMapping("/search/song")
	public String seravhBySinger(Model model, @RequestParam("search") String singer, HttpSession session){
		List<Lookify> songs = appService.findBySinger(singer);
			System.out.println(songs);
			model.addAttribute("songss", songs);
			session.setAttribute("singer", singer);
			return "searchResult.jsp";
	}
	// get top 10 songs by rating
	@GetMapping("/top10")
	public String topTen(Model model) {
		List<Lookify> songs=appService.topTen();	
		model.addAttribute("songss", songs);
		return "topTen.jsp";
	}
}
