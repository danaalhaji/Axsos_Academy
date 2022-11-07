package com.axsos.ninjadojo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.axsos.ninjadojo.models.*;
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	// this method retrieves all the travel from the database
    List<Ninja> findAll();
    List<Ninja> findDojosByDojoId(Long Id);
    // this method finds travels with expenses containing the search string
//    Dojo findByDojoContaining(Ninja ninja);

}

