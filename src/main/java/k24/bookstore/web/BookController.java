package k24.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import k24.bookstore.model.Book;
import k24.bookstore.model.BookRepository;
import k24.bookstore.model.Category;
import k24.bookstore.model.CategoryRepository;


@Controller
public class BookController {
        @Autowired
        private BookRepository repository;

        @Autowired
        private CategoryRepository crepository;

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
                model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
        //save book
        @RequestMapping(value="save", method = RequestMethod.POST)
	public String save(Book book) {
                repository.save(book);
		System.out.println("add book : " + book);
		return "redirect:booklist";
	}
         // Delete book
        @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
        public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	        repository.deleteById(bookId);
                return "redirect:booklist";
        }
         //edit book
         @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
         public String editBook(@PathVariable("id") Long Id, Model model) {
                 model.addAttribute("edit", repository.findById(Id));
                 model.addAttribute("categories", crepository.findAll());
                 return "editbook";
        
        }
}
