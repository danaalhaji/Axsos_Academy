package com.axsos.languages.controller;

import java.util.List;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.axsos.languages.models.Language;
import com.axsos.languages.repositories.LanguagesRepositories;
import com.axsos.languages.service.LangaugesServices;

@Controller
public class appController {
	private final LangaugesServices appService;
	public appController(LangaugesServices appService) {
		this.appService = appService;
	}
	// route to route the home page
	@GetMapping("/")
	public String homeRedirect() {
		return "redirect:/language";
	}
	// home page render
	@GetMapping("/language")
	public String index(Model model ,@ModelAttribute("newLang") Language newlang) {
		List <Language> languages = appService.findAll();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	// submit new language 
	@PostMapping("/language/submit")
	public String addLanguage(@Valid @ModelAttribute("newLang") Language newlang, BindingResult result,Model model) {
		if (result.hasErrors()) {
			List <Language> languages = appService.findAll();
			model.addAttribute("languages", languages);
            return "index.jsp";
        } else {
            appService.createLanguage(newlang);
            return "redirect:/language";
        }
	}
	// view a language details
	@GetMapping("/language/{id}")
	public String viewLanguage(@PathVariable("id") Long id, Model model){
		model.addAttribute("lang", appService.findLanguage(id));
		return "show.jsp";
	}
	// delete a language
	@GetMapping("/language/{id}/delete")
	public String deleteLanguage(@PathVariable("id") Long id) {
		appService.deleteLanguage(appService.findLanguage(id));
		return "redirect:/language";
	}
	// render edit  a language 
	@GetMapping("/language/{id}/edit")
	public String updateLanguage(@PathVariable("id") Long id,@ModelAttribute("editLang") Language editLang, Model model) {
		Language lang = appService.findLanguage(id);
		model.addAttribute("editLang", lang);
		return "edit.jsp";
	}
	// submit edit
	@PutMapping("/language/edit/{id}")
	public String submitEditLanguage(@Valid @ModelAttribute("editLang") Language editLang, Model model, BindingResult result ) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            appService.updateLanguage(editLang);
            return "redirect:/language";
        }
}
}
