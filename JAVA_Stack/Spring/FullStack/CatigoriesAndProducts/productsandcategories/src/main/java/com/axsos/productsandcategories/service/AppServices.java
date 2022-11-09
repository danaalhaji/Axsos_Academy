package com.axsos.productsandcategories.service;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.productsandcategories.models.Category;
import com.axsos.productsandcategories.models.Product;
//import com.axsos.productsandcategories.repository.CategoryProductRepository;
import com.axsos.productsandcategories.repository.CategoryRepository;
import com.axsos.productsandcategories.repository.ProductRepository;

@Service
public class AppServices {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
//	private final CategoryProductRepository categoryProductRepository;
	
	public AppServices(ProductRepository productRepository , CategoryRepository categoryRepository) {
//		this.categoryProductRepository = categoryProductRepository;
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}
//	Services for Products
		// find all products
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
		// save new product object
	public Product creatProducts(Product pro) {
		return productRepository.save(pro);
	}
		//find a product by id
    public Product findProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } 
        else {
            return null;
        }
    }
    
//	Services for Categories
		// find all Categories
	public List<Category> allCategories(){
		return categoryRepository.findAll();
	}
		// save new category object
	public Category creatCategory(Category cat) {
		return categoryRepository.save(cat);
	}
		//find a category by id
    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } 
        else {
            return null;
        }
    }
    // update a product
    public Product updateProduct(Product pro) {
    	pro.getId();
    	return productRepository.save(pro);
    }
    // find all products not in category
    public List<Category> productsNotInCat(Product product){
    	return categoryRepository.findByProductsNotContains(product);
    }
    //update category 
    public Category updateCategory(Category c) {
    	return categoryRepository.save(c);
    }
    public List<Product> categoriesNotInprod(Category c){
    	return productRepository.findByCategoriesNotContains(c);
    }
    //    public List<Category> allCatInProd(Product p) {
//    	return categoryRepository.findAllByProducts(p);
//    }
//    public List<Category> allCatNotInProd(Product pro) {
//    	return categoryRepository.findCategoriesNotContains(pro);
//    }
//// Services for Categories and Repositories model
//    public CategoryProduct createCategoryProduct(CategoryProduct CatPro) {
//    	return categoryProductRepository.save(CatPro);
//    }
}
