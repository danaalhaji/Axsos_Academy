package com.axsos.bookclub.service;

import javax.naming.Binding;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.axsos.bookclub.models.Book;
import com.axsos.bookclub.models.LoginUser;
import com.axsos.bookclub.models.User;
import com.axsos.bookclub.repositories.BookRepository;
import com.axsos.bookclub.repositories.UserRepository;

@Service
public class AppServices {
	private final BookRepository bookRepository;
	private final UserRepository userRepository;
	public AppServices(BookRepository bookRepository, UserRepository userRepository) {
		this.bookRepository=bookRepository;
		this.userRepository=userRepository;
	}
	// register new user validation and confirmation method 
    public User register(User newUser, BindingResult result) {
        if(userRepository.findByEmail(newUser.getEmail()).isPresent()) {
            result.rejectValue("email", "Unique", "This email is already in use!");
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepository.save(newUser);
        }
    } 
	// old user login and confirmation
	public User login(LoginUser newLogin, BindingResult result) {
        if(result.hasErrors()) {
            return null;
        }
        Optional<User> potentialUser = userRepository.findByEmail(newLogin.getEmail());
        if(!potentialUser.isPresent()) {
            result.rejectValue("email", "Unique", "Unknown email!");
            return null;
        }
        User user = potentialUser.get();
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            return user;
        }
	}
    public User findUserById(Long id) {
        Optional<User> u = userRepository.findById(id);

        if(u.isPresent()) {
            return u.get();
            } else {
            return null;
        }
    }
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }

    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public Book updateBook(Long id,String title, String desc , String Auther , BindingResult result) {
    	if(result.hasErrors()) {
            return null; 
    	}
            else{
            	Book book = this.findBook(id);
            	book.setAuther(Auther);
            	book.setDescription(desc);
            	book.setTitle(title);
        return bookRepository.save(book);
            }
    }
    public Book updateBook(Book book) {
    	System.out.println(book.getTitle());
    	return bookRepository.save(book);
    }
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}