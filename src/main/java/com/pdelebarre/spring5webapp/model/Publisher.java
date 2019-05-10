package com.pdelebarre.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy="publisher")
    private Set<Book> books = new HashSet<>();

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Publisher() {
    }

    public Publisher(String name) {
        this.name = name;
    }
    public Publisher(String name, Set<Book> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Publisher name(String name) {
        this.name = name;
        return this;
    }

    public Publisher books(Set<Book> books) {
        this.books = books;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Publisher)) {
            return false;
        }
        Publisher publisher = (Publisher) o;
        return id!=null?id.equals(publisher.id):publisher.id==null;
    }

    @Override
    public int hashCode() {
        return id!=null?id.hashCode():0;
    }

    @Override
    public String toString() {
        return "{" +
            " id=''" + getId() + "'" +
            " name='" + getName() + "'" +
            ", books='" + getBooks() + "'" +
            "}";
    }

    

}