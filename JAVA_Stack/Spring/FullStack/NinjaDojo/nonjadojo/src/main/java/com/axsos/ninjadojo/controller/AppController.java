package com.axsos.ninjadojo.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.ninjadojo.models.Dojo;
import com.axsos.ninjadojo.models.Ninja;
import com.axsos.ninjadojo.repository.DojoRepository;
import com.axsos.ninjadojo.services.DojoServices;
import com.axsos.ninjadojo.services.NinjaServices;

@Controller
public class AppController {
    private DojoServices dojoService;
	private NinjaServices ninjaService;
    public AppController(DojoServices dojoService,NinjaServices ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }
	
	@GetMapping("/dojo/new")
	public String dojoCreate(@ModelAttribute("dojo") Dojo dojo) {
		return "addDojo.jsp";
	}
	@PostMapping("/dojo/create")
	public String dojoSave(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
            return "addDojo.jsp";
        } else {
        	dojoService.createDojo(dojo);
            return "redirect:/";
        }
	}
	@GetMapping("/ninja/new")
	public String ninjaFrom(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos =  dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "addNinja.jsp";
	}
	@PostMapping("/ninja/create")
	public String ninjaCreate(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Dojo> dojos =  dojoService.allDojos();
			model.addAttribute("dojos", dojos);
            return "addNinja.jsp";
        } 
		else {
        	ninjaService.createNinja(ninja);
            return "redirect:/ninja/new";
        }
}
	@GetMapping("/dojo/{dojoid}")
	public String allNinjasOneDojo(@PathVariable("dojoid") long Id, Model model) {
		List<Ninja> ninjas = ninjaService.allNinjaInDojo(Id);
		model.addAttribute("ninjas" , ninjas);
		return "allNinjasForDojojsp.jsp";
	}
}
