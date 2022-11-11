package com.axsos.languages.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.languages.models.Language;
import com.axsos.languages.repositories.LanguagesRepositories;

@Service
public class LangaugesServices {
	public final LanguagesRepositories languagesRepository;
	public LangaugesServices(LanguagesRepositories languagesRepository) {
		this.languagesRepository = languagesRepository;
	} 
	public LanguagesRepositories getLanguagesRepository() {
		return languagesRepository;
	}
	//	create a language
	public Language createLanguage(Language lang) {
		return languagesRepository.save(lang);
		
	}
	// find a language
	public Language findLanguage(Long id) {
		Optional<Language> optinaLanuage = languagesRepository.findById(id);
		if (optinaLanuage.isPresent()){
		 return optinaLanuage.get();
	}
		else {
			return null;
		}
	}
	// get all languages
	public List<Language> findAll(){
		return languagesRepository.findAll();
		}
	// update a language
	public Language updateLanguage(Language lang) {
		return languagesRepository.save(lang);
	}
	// delete a language
	public void deleteLanguage(Language lang) {
		languagesRepository.delete(lang);
	}
	
}
