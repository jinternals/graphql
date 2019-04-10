package com.jinternals.graphql;

import com.jinternals.graphql.entities.Author;
import com.jinternals.graphql.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private AuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Author author = new Author();
		author.setId(UUID.randomUUID().toString());
		author.setFirstName("Mradul");
		author.setLastName("Pandey");
		authorRepository.save(author);
	}
}
