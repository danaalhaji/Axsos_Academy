package com.axsos.travels.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.axsos.travels.models.*;
public interface TravelRepository extends CrudRepository<Travels, Long>{
	
	// this method retrieves all the travel from the database
    List<Travels> findAll();
    // this method finds travels with expenses containing the search string
    List<Travels> findByExpensesContaining(String search);
}
