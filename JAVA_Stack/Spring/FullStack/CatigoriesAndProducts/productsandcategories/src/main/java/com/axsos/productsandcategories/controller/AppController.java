package com.axsos.productsandcategories.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.productsandcategories.models.Category;
import com.axsos.productsandcategories.models.Product;
import com.axsos.productsandcategories.repository.CategoryRepository;
import com.axsos.productsandcategories.service.AppServices;

@Controller
public class AppController {
private final AppServices appService;
public AppController(AppServices appService) {
	this.appService = appService;
}
// Render Home page
@GetMapping("/")
public String index(Model model) {
	model.addAttribute("categories", appService.allCategories());
	model.addAttribute("products", appService.allProducts());
	return "index.jsp";
}

// Render add categorey page
@GetMapping("/categorey/add")
public String addCat(@ModelAttribute("categorey") Category cat) {
	
	return "catAdd.jsp";
}

// route to handle the categorey form 
@PostMapping("/cat/create")
public String createCat(@ModelAttribute("categorey") Category cat) {
	appService.creatCategory(cat);
	return "catAdd.jsp";
}

//Render add product page
@GetMapping("/product/add")
public String addProduct(@ModelAttribute("product") Product product) {
	return "productAdd.jsp";

}

//handle the product form
@PostMapping("/product/create")
public String createProduct(@ModelAttribute("product") Product product) {
	appService.creatProducts(product);
	return "productAdd.jsp";

}

//render a product
@GetMapping("/product/{id}")
public String showProduct(@PathVariable("id") Long id , @ModelAttribute("product") Product product,Model model) {
	Product pro = appService.findProduct(product.getId());
	model.addAttribute("product", pro);
	model.addAttribute("cat", appService.productsNotInCat(pro));
	return "productShow.jsp";
}

// add category to product
@PostMapping("/products/addcat")
public String addCate(@RequestParam("product") Long id,@RequestParam("categories") Long idC ) {
	Product prod = appService.findProduct(id);
	Category cat = appService.findCategory(idC);
	List<Category> produCat = prod.getCategories();
	produCat.add(cat);
	prod.setCategories(produCat);
	appService.updateProduct(prod);
	return "redirect:/";
}
//Render product page
@GetMapping("/category/{id}")
public String showCategory(@ModelAttribute("category") Category category,@PathVariable("id") Long id, Model model) {
	Category cat = appService.findCategory(id);
	System.out.println(cat.getName());
	model.addAttribute("cate", cat);
	model.addAttribute("product", appService.categoriesNotInprod(cat));
	return "showCategory.jsp";
}

//add product to category
@PostMapping("/category/addcat")
public String addProduct(@RequestParam("category") Long id,@RequestParam("products") Long idp ) {
	
	Category cat = appService.findCategory(id);
	Product prod = appService.findProduct(idp);
	List<Product> catProducts =  cat.getProducts();
	catProducts.add(prod);
	cat.setProducts(catProducts);
	appService.updateCategory(cat);
	return "redirect:/";
}
}