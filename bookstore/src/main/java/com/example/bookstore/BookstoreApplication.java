package com.example.bookstore;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(BookService bookService) {
		return args -> {
			Book book = new Book();
			book.setTitle("Clean Code");
			book.setAuthor("Robert C. Martin");
			book.setIsbn("9780132350884");
			book.setPrice(BigDecimal.valueOf(49.99));
			book.setDescription("A Handbook of Agile Software Craftsmanship");
			book.setCoverImage("https://example.com/image.jpg");

			bookService.save(book);

			bookService.findAll().forEach(System.out::println);
		};
	}
}
