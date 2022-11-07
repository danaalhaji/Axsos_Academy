package com.axsos.ninjadojo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.axsos.ninjadojo.models.*;
public interface DojoRepository extends CrudRepository<Dojo, Long>{
	// this method retrieves all the travel from the database
    List<Dojo> findAll();
    // this method finds travels with expenses containing the search string
//    List<Dojo> findByNinjaContaining(Dojo dojo);
//    // method to find all ninja
//    List<Ninja> findByIdContaining(Long id);

}
