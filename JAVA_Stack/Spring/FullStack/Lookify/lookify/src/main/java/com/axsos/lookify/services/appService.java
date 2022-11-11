package com.axsos.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.lookify.models.Lookify;
import com.axsos.lookify.repository.LookifyRepository;

@Service
public class appService {
	private final LookifyRepository lookRepo;
	public appService(LookifyRepository lookRepo) {
		this.lookRepo = lookRepo;
	}
    // returns all the Songs
    public List<Lookify> allSongs() {
        return lookRepo.findAll();
    }
    //create song
    public Lookify create(Lookify song) {
    	return lookRepo.save(song);
    }
    // find by id
    public Lookify findBook(Long id) {
        Optional<Lookify> optionalLookify = lookRepo.findById(id);
        if(optionalLookify.isPresent()) {
            return optionalLookify.get();
        } else {
            return null;
        }
    }
    //find by singer
    public List<Lookify> songBySinger(String title) {
        Optional<List<Lookify>> optionalLookify = lookRepo.findBySingerContaining(title);
        if(optionalLookify.isPresent()) {
            return optionalLookify.get();
        } else {
            return null;
        }
    }
    // find top 10 rating songs
    public List<Lookify> topTen(){
    	return lookRepo.findTopOrderByRatingDesc();
    }
}
