package com.axsos.ninjadojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.ninjadojo.models.Dojo;
import com.axsos.ninjadojo.models.Ninja;
import com.axsos.ninjadojo.repository.DojoRepository;
import com.axsos.ninjadojo.repository.NinjaRepository;

@Service
public class NinjaServices {

private final NinjaRepository ninjaRepository;
    
    public NinjaServices(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    
    
    public List<Ninja> allNinja() {
	        return ninjaRepository.findAll();
	    }
    public List<Ninja> allNinjaInDojo(Long id) {
        return ninjaRepository.findDojosByDojoId(id);
    }
	    // creates a ninja
	    public Ninja createNinja(Ninja ninja) {
	        return ninjaRepository.save(ninja);
	    }
	    
	    // retrieves a Ninja
	    public Ninja findNinja(Long id) {
	        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
	        if(optionalNinja.isPresent()) {
	            return optionalNinja.get();
	        } 
	        else {
	            return null;
	        }
	    }
	    
        //Update Ninnja
    public Ninja updateDojo(Ninja ninja) {
    	ninja.getId();
    	 return ninjaRepository.save(ninja);
    }
        public Ninja updateNinja(Long id,Dojo dojo) {
        	Ninja ninja = this.findNinja(id);
       	 		ninja.setDojo(dojo);
       	 return ninjaRepository.save(ninja);
    }
        public Ninja updateTravel(Long id,String name, Dojo dojo, double age,String Lname) {
          	 Ninja ninja = this.findNinja(id);
          	 ninja.setAge(age);
          	 ninja.setDojo(dojo);
          	 ninja.setFirstName(name);
          	 ninja.setLastName(Lname);
            return ninjaRepository.save(ninja);
       }
        public void deleteNinja(Long id) {
        	ninjaRepository.deleteById(id);
        }
}

