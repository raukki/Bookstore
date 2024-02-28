package k24.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import k24.bookstore.model.Book;
import k24.bookstore.model.BookRepository;
import k24.bookstore.model.CategoryRepository;
import k24.bookstore.model.AppUser;
import k24.bookstore.model.AppUserRepository;

@RestController
public class RestBookController {

    @Autowired
        private BookRepository repository;

    @Autowired
    private CategoryRepository crepository;

    @Autowired
    private AppUserRepository apprepository;

    	// RESTful service to get all books
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) repository.findAll();
    }    

	// RESTful service to get student by id
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
    	return repository.findById(bookId);
    } 

     //save book
     @PostMapping("/book")
     Book newBook (@RequestBody Book newBook) {       
         System.out.println("save a new book " + newBook);
         return repository.save(newBook);
     }

     //edit book
     //@PutMapping("/book/put/{id}")
     //Book editBook (@RequestBody Book (@PathVariable("id") Long bookId, Model model)) {       
        // System.out.println("edit book " + editBook());
       // repository.deleteById(bookId);
       // return " ";
    // }

     //delete book
    // @DeleteMapping("/book/delete/{id}")
    // Book deleteBook (@RequestBody Book (@PathVariable("id") Long bookId, Model model)) {       
      //   System.out.println("delete book " + deleteBook());
      //  repository.deleteById(bookId);
      // return " ";
     //}


}
