package com.farhad.Spring5webapp.repositories;

import com.farhad.Spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
