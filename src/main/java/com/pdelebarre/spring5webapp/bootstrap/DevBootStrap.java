package com.pdelebarre.spring5webapp.bootstrap;

import com.pdelebarre.spring5webapp.model.Author;
import com.pdelebarre.spring5webapp.model.Book;
import com.pdelebarre.spring5webapp.repositories.AuthorRepository;
import com.pdelebarre.spring5webapp.repositories.BookRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository=authorRepository;
        this.bookRepository=bookRepository;
    }

    private void initData() {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }


}