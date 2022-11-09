package com.axsos.productsandcategories.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.productsandcategories.models.Category;
import com.axsos.productsandcategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	// find all products
	List<Product> findAll();
	//	Find by id	
	Optional<Product> findById(Long Id); 
	// does not belong to.
    List<Product> findByCategoriesNotContains(Category category);
}
