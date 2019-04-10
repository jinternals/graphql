package com.jinternals.graphql.fetchers;

import com.jinternals.graphql.entities.Author;
import com.jinternals.graphql.repositories.AuthorRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class AuthorDataFetcher implements DataFetcher<Author> {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorDataFetcher(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author get(DataFetchingEnvironment env) {
        Map<String,Object> args = env.getArguments();
        Optional<Author> author = authorRepository.findById(String.valueOf(args.get("id")));
        return author.get();
    }

}
