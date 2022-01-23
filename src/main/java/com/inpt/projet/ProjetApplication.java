package com.inpt.projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.inpt.projet.Clients.Books;
import com.inpt.projet.Clients.User;
import com.inpt.projet.dao.BookRepository;
import com.inpt.projet.dao.UserRepository;

@SpringBootApplication
public class ProjetApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProjetApplication.class, args);
	}
	
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private BookRepository bookrepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Books book1 = new Books();
//		book1.setBookName("Things Fall Apart");
//		book1.setAuthor("Louis-Ferdinand Céline");
//		book1.setPrix("20");
//		book1.setDisponibility(true);
//		bookrepository.save(book1);

		
	}
}
