package com.pdelebarre.spring5webapp.repositories;

import com.pdelebarre.spring5webapp.model.Author;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}