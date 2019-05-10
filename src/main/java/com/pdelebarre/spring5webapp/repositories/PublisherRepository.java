package com.pdelebarre.spring5webapp.repositories;

import com.pdelebarre.spring5webapp.model.Publisher;

import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}