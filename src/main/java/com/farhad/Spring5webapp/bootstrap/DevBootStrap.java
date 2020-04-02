package com.farhad.Spring5webapp.bootstrap;

import com.farhad.Spring5webapp.model.Author;
import com.farhad.Spring5webapp.model.Book;
import com.farhad.Spring5webapp.model.Publisher1;
import com.farhad.Spring5webapp.repositories.AuthorRepository;
import com.farhad.Spring5webapp.repositories.BookRepository;
import com.farhad.Spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        //Jon
        Publisher1 jonPublisher = new Publisher1("First Publisher", "1040 west granville");
        publisherRepository.save(jonPublisher);
        Author jon = new Author("Jon", "Doe");
        Book book = new Book("Self Help", "1213", jonPublisher);
        book.getAuthors().add(jon);
        jon.getBooks().add(book);

        authorRepository.save(jon);
        bookRepository.save(book);

        //Rob
        Publisher1 robPublisher = new Publisher1("second Publisher", "1015 west devon");
        publisherRepository.save(robPublisher);
        Author rob = new Author("Rob", "Loe");
        Book robBooks = new Book("Rob Loe", "JJJJ", robPublisher);
        book.getAuthors().add(rob);
        jon.getBooks().add(robBooks);

        authorRepository.save(rob);
        bookRepository.save(robBooks);

    }
}
