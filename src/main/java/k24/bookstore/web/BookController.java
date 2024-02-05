package k24.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import k24.bookstore.model.Book;
import k24.bookstore.model.BookRepository;


@Controller
public class BookController {
        @Autowired
        private BookRepository repository;

        //show all books
        @RequestMapping("booklist")
        public String showIndexPage(Model model) {
                model.addAttribute("books", repository.findAll());
                return "booklist";
        }
        //add book
        @RequestMapping("add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
        //save book
        @PostMapping("save")
	public String save(Book book) {
                repository.save(book);
		System.out.println("add book : " + book);
		return "booklist";
	}
         // Delete book
        @DeleteMapping("/delete/{id}")
        public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	        repository.deleteById(bookId);
                return "booklist";
    }
        
}
