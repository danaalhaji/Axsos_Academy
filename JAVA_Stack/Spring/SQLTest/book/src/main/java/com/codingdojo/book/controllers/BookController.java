package com.codingdojo.book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.book.models.Book;
import com.codingdojo.book.services.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookServices;
@GetMapping("/book/{bookId}")
public String bookView(@PathVariable("bookId") long bookId, Model model) {
	Book book = bookServices.findBook(bookId);
	model.addAttribute(book);
	return"index.jsp";
	
}

}
