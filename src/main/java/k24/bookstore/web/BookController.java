package k24.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import k24.bookstore.model.BookRepository;

@Controller
public class BookController {
        @Autowired
        private BookRepository repository;

        @RequestMapping("index")
        public String showIndexPage(Model model) {
                model.addAttribute("books", repository.findAll());
                return "booklist";


}
}
