package com.axsos.lookify.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.lookify.models.Lookify;
@Repository
public interface LookifyRepository extends CrudRepository<Lookify, Long>{
    // this method retrieves all the books from the database
    List<Lookify> findAll();
    // this method retrieves a song by a singer
    Optional<List<Lookify>> findBySingerContaining(String title);
    //This method finds top 10 songs rated
    @Query(value = "SELECT * From lookfies ORDER BY rating DESC LIMIT 10 ", nativeQuery = true)
    List<Lookify> getTopTen();
}
