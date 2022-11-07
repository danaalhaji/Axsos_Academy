package com.axsos.ninjadojo.services;
import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.ninjadojo.*;
import com.axsos.ninjadojo.models.Dojo;
import com.axsos.ninjadojo.models.Ninja;
import com.axsos.ninjadojo.repository.DojoRepository;


@Service
public class DojoServices {
    private final DojoRepository dojoRepository;
    
    public DojoServices(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }
	 public List<Dojo> allDojos() {
	        return dojoRepository.findAll();
	    }
	    // creates a Dojo
	    public Dojo createDojo(Dojo dojo) {
	        return dojoRepository.save(dojo);
	    }
	    
	    // retrieves a Dojo
	    public Dojo findDojo(Long id) {
	        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
	        if(optionalDojo.isPresent()) {
	            return optionalDojo.get();
	        } 
	        else {
	            return null;
	        }
	    }
	    
        //Update a dojo
    public Dojo updateDojo(Dojo dojo) {
    	dojo.getId();
    	 return dojoRepository.save(dojo);
    }
        public Dojo updateTravel(Long id,String name) {
       	 Dojo dojo = this.findDojo(id);
       	 dojo.setName(name);
         return dojoRepository.save(dojo);
    }
        public Dojo updateDojo(Long id,String name, List<Ninja> ninja) {
          	 Dojo dojo = this.findDojo(id);
          	 dojo.setName(name);
          	 dojo.setNinjas(ninja);
            return dojoRepository.save(dojo);
       }
        public void deleteDojo(Long id) {
        	dojoRepository.deleteById(id);
        }
}
