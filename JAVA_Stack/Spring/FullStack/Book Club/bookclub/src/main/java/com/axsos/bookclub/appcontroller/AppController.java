package com.axsos.bookclub.appcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.axsos.bookclub.models.Book;
import com.axsos.bookclub.models.LoginUser;
import com.axsos.bookclub.models.User;
import com.axsos.bookclub.service.AppServices;

@Controller
public class AppController {
	AppServices appServices;
	public AppController(AppServices appServices) {
		this.appServices = appServices;
	}
	
	@GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
		appServices.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/home";
	}
	@GetMapping("/home")
	public String welcomePage(HttpSession session, Model model, @ModelAttribute("newBook") Book newBook) {
		User Logged = appServices.findUserById((Long)session.getAttribute("user_id"));
		model.addAttribute("logged", Logged);
		List <Book> books = appServices.allBooks();
		model.addAttribute("books", books);
		return "home.jsp";
	}
    @GetMapping("/homeu")
    public String home(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
        Long user_id = (Long) session.getAttribute("user_id");
        User thisUser = appServices.findUserById(user_id);
        model.addAttribute("logged", thisUser);
		List <Book> books = appServices.allBooks();
		model.addAttribute("books", books);
        return "home.jsp";
    }
        else {
            return "redirect:/";
        }
    }
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = appServices.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/homeu";
    }

	@GetMapping("/book/add")
	public String addBookForm(HttpSession session,@ModelAttribute("newBook") Book newBook,Model model) {
    	Long user_id = (Long) session.getAttribute("user_id");
    	User thisUser = appServices.findUserById(user_id);
    	model.addAttribute("logged", thisUser);
		return "addBook.jsp";
	}
	@PostMapping("/book/submit")
	public String bookSubmit(@Valid @ModelAttribute("newBook") Book newBook, HttpSession session, BindingResult result, Model model) {
		User Logged = appServices.findUserById((Long)session.getAttribute("user_id"));
		model.addAttribute("logged", Logged);
		if(result.hasErrors()) {
			model.addAttribute("newBook", newBook);
			return "addBook.jsp";
		}
		else {
			newBook.setUser(Logged);
			appServices.createBook(newBook);
			return "redirect:/home";
		}
	}
    @GetMapping("/book/{bookId}")
    public String bookView(@PathVariable("bookId") long bookId, Model model, HttpSession session, 
    		@ModelAttribute("book")Book book) {
    	Long user_id = (Long) session.getAttribute("user_id");
    	User thisUser = appServices.findUserById(user_id);
    	model.addAttribute("logged", thisUser);
    	book = appServices.findBook(bookId);
    	model.addAttribute(book);
    	return"showBook.jsp";
	
}
    @GetMapping("/book/{bookid}/delete")
    public String deleteBook(@PathVariable("bookid") long bookId) {
    	appServices.deleteBook(bookId);
    	return "redirect:/homeu";
    }
    @GetMapping("/book/{bookid}/edit")
    public String edit(@PathVariable("bookid") Long id, Model model,@ModelAttribute("book") Book book) {
    	System.out.println("hi");
    	System.out.println(book.getId());
        book = appServices.findBook(id);
        System.out.println(book.getId());
        model.addAttribute("book", book);
        return "editBook.jsp";
    }
    @PutMapping("/book/{bookid}/submit")
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result,
    		@PathVariable("bookid") Long id) {
    	
        if (result.hasErrors()) {
            return "/books/edit.jsp";
        } 
        else {
        	book = appServices.findBook(id);
        	System.out.println(book.getId());
            appServices.updateBook(book);
            return "redirect:/home";
        }
    }
    @PutMapping("/book/{bookid}/borrow")
    public String borrowBook(@PathVariable("bookid") Long id, HttpSession session ) {
    	Book book = appServices.findBook(id);
    	Long user_id = (Long) session.getAttribute("user_id");
    	User thisUser = appServices.findUserById(user_id);
    	book.setUser_borower(thisUser);
    	appServices.updateBook(book);
    	return "redirect:/home";
    }
}
