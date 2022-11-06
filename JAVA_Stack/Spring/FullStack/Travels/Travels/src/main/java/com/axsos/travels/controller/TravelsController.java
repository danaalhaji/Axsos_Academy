package com.axsos.travels.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.print.Book;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.travels.models.Travels;
import com.axsos.travels.services.TravelsService;
// ... other imports removed for brevity
@Controller
public class TravelsController {
	@Autowired
    private TravelsService travelsService;
    
    public void TravelsController(TravelsService travelsService) {
        this.travelsService = travelsService;
    }
    
    @GetMapping("/travels/new")
    public String newBook(@ModelAttribute("travel") Travels travel,Model model) {
        List<Travels> travels = travelsService.allTravels();
        model.addAttribute("travels", travels);
        return "index.jsp";
    }
    @PostMapping("/travels")
    public String create(@Valid @ModelAttribute("travel") Travels travel, BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        } else {
        	travelsService.createTravel(travel);
            return "redirect:/travels/new";
        }
    }
@GetMapping("/travels/{travelId}")
        public String travelView(@PathVariable("travelId") long Id, Model model) {
        	Travels travel = this.travelsService.findTravel(Id);
        	model.addAttribute(travel);
        	System.out.println(travel.getAmount());
        	
        	return"/travels/index.jsp";
    	
    }
@GetMapping("/travels/{travelId}/edit")
public String edit(@PathVariable("travelId") long Id, Model model) {
	Travels travel = travelsService.findTravel(Id);
	model.addAttribute("travel", travel);
	return "travels/edit.jsp";
}
    }

