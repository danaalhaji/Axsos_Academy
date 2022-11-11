package com.axsos.languages.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.languages.models.Language;


@Repository
public interface LanguagesRepositories extends CrudRepository<Language, Long>{
	// this method retrieves all the books from the database
    List<Language> findAll();
    
}
