package com.jinternals.graphql.fetchers;

import com.jinternals.graphql.entities.Author;
import com.jinternals.graphql.repositories.AuthorRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorsDataFetcher implements DataFetcher<Iterable<Author>> {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorsDataFetcher(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> get(DataFetchingEnvironment env) {
        Iterable<Author> author = authorRepository.findAll();
        return author;
    }
}
