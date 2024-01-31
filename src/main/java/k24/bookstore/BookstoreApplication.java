package k24.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import k24.bookstore.model.Book;
import k24.bookstore.model.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repo){
		return (args) -> {
			log.info("save books");
			repo.save(new Book("Kansojen historia","Carl Grimberg", "1970", "3456789", "5"));

			log.info("fetch all books");
			for (Book book: repo.findAll()){
				log.info(book.toString());
			}
		};
	}


}
