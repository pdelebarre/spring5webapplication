package com.pdelebarre.spring5webapp.bootstrap;

import com.pdelebarre.spring5webapp.model.Author;
import com.pdelebarre.spring5webapp.model.Book;
import com.pdelebarre.spring5webapp.model.Publisher;
import com.pdelebarre.spring5webapp.repositories.AuthorRepository;
import com.pdelebarre.spring5webapp.repositories.BookRepository;
import com.pdelebarre.spring5webapp.repositories.PublisherRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository=authorRepository;
        this.bookRepository=bookRepository;
        this.publisherRepository=publisherRepository;
    }

    private void initData() {
        Author eric = new Author("Eric", "Evans");
        Publisher harper = new Publisher("Harper");
        Book ddd = new Book("Domain Driven Design", "1234", harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(harper);

        authorRepository.save(eric);
        publisherRepository.save(harper);
        bookRepository.save(ddd);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }


}