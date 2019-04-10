package com.jinternals.graphql.repositories;

import com.jinternals.graphql.entities.Author;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository extends PagingAndSortingRepository<Author, String> {
}
