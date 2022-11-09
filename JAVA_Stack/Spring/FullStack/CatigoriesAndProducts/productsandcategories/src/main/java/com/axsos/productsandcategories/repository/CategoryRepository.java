package com.axsos.productsandcategories.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.productsandcategories.models.Category;
import com.axsos.productsandcategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	// Find all categories	
	List <Category> findAll();
	// Find by Id	
	Optional<Category> findById(Long Id); 
	// Find all products with on category
    // Retrieves a list of all categories for a particular product
    List<Category> findAllByProducts(Product product);
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Category> findByProductsNotContains(Product product);
}
