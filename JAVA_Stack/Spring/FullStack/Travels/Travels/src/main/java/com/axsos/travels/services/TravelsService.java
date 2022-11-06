package com.axsos.travels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.travels.models.Travels;
import com.axsos.travels.repositories.TravelRepository;

@Service

public class TravelsService {
    // adding the book repository as a dependency
    private final TravelRepository travelsRepository;
    
    public TravelsService(TravelRepository travelsRepository) {
        this.travelsRepository = travelsRepository;
    }

	public TravelRepository getTravelsRepository() {
		return travelsRepository;
	}
	
	 public List<Travels> allTravels() {
	        return travelsRepository.findAll();
	    }
	    // creates a book
	    public Travels createTravel(Travels travel) {
	        return travelsRepository.save(travel);
	    }
	    // retrieves a book
	    public Travels findTravel(Long id) {
	        Optional<Travels> optionalTravel = travelsRepository.findById(id);
	        if(optionalTravel.isPresent()) {
	            return optionalTravel.get();
	        } 
	        else {
	            return null;
	        }
	    }
	        //Update a travel
	        
	        public Travels updateTravel(Long id,String expenses, String vendor, String description,double amount) {
	       	 Travels travel = this.findTravel(id);
	       	 travel.setExpenses(expenses);
	       	 travel.setVendor(vendor);
	       	 travel.setAmount(amount);
	       	 travel.setDescription(description);
	         return travelsRepository.save(travel);
	    }
	        public void deleteTravel(Long id) {
	        	travelsRepository.deleteById(id);
	        }
}