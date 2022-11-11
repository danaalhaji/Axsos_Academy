package com.axsos.lookify.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

import com.axsos.lookify.models.Lookify;
import com.axsos.lookify.repository.LookifyRepository;

@Controller
public class appController {
	private final LookifyRepository lookifyRepository;
	public appController(LookifyRepository lookifyRepository) {
		this.lookifyRepository=lookifyRepository;
	}
	// create song
	public Lookify create(Lookify song) {
		return lookifyRepository.save(song);
	}
	// update song
	public Lookify update(Lookify song) {
		return lookifyRepository.save(song);
	}
	// delete song
	public void  delete(Lookify song) {
		 lookifyRepository.delete(song);
	}
	// find all
	public List<Lookify> findAll(){
		return lookifyRepository.findAll();
	}
	// find by singer
	public Optional<List<Lookify>> findBySinger(String name){
		return lookifyRepository.findBySingerContaining(name);
	}
	// find by id
	public Lookify findSong(Long id) {
		Optional<Lookify> optionalSong = lookifyRepository.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		}else {
			return null;
		}
	}
	// find top ten by rating 
	public List<Lookify> topTen(){
		return lookifyRepository.getTopTen();
	}
}
