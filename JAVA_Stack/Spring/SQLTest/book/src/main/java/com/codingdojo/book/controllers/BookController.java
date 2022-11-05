package com.codingdojo.book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.book.models.Book;
import com.codingdojo.book.services.BookService;

@Controller
public class BookController {
	@Autowired
    private BookService bookService;
    
    public void BooksController(BookService bookService) {
        this.bookService = bookService;
    }
    
//    Method to show all books

    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/index.jsp";
    }
    
// Method to show one book by ID
    
    @GetMapping("/book/{bookId}")
    public String bookView(@PathVariable("bookId") long bookId, Model model) {
    	Book book = this.bookService.findBook(bookId);
    	model.addAttribute(book);
    	return"index.jsp";
	
}

}
