package k24.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import k24.bookstore.model.Book;
import k24.bookstore.model.BookRepository;
import k24.bookstore.model.Category;
import k24.bookstore.model.CategoryRepository;
import k24.bookstore.model.AppUser;
import k24.bookstore.model.AppUserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repo, CategoryRepository crepo, AppUserRepository arepo){
		return (args) -> {
			log.info("save books");

			Category category1 = new Category("Children");
			Category category2 = new Category("Encyclopedia");
			Category category3 = new Category("Novels");

			crepo.save(category1);
			crepo.save(category2);
			crepo.save(category3);

			repo.save(new Book("Kansojen historia","Carl Grimberg","3456789", 5.00, 1970, category2));
			repo.save(new Book("Peppi Pitkätossu","Astrid Lindgren","7756788", 3.00, 1980, category1));

			// Create users: admin/admin user/user
			AppUser user1 = new AppUser("user", "$2a$10$U/t1pLApu32EZPAqDSVOmOJnK/K3LWpqQppt6uKrkemcoPIkI7M5C", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$ymLMZaaoYsn/rWbKF..dLeDSQP4rBY68aNG3VkPdlaEy11YxH40vu", "ADMIN");
			arepo.save(user1);
			arepo.save(user2);

			log.info("fetch all books");
			for (Book book: repo.findAll()){
				log.info(book.toString());
			}
		};
	}


}
