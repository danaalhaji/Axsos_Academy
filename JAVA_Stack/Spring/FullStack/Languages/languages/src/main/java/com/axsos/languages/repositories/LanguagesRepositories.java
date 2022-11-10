package com.axsos.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.languages.models.Languages;

@Repository
public interface LanguagesRepositories extends CrudRepository<Languages, Long>{
	// this method retrieves all the books from the database
    List<Languages> findAll();
}
