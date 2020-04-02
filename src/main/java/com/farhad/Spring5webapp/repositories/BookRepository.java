package com.farhad.Spring5webapp.repositories;

import com.farhad.Spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
