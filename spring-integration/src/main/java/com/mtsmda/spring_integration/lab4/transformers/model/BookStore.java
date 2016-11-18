package com.mtsmda.spring_integration.lab4.transformers.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by dminzat on 11/18/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "bookstore")
public class BookStore {

    @XmlElement(name = "book")
    private List<Book> books;

    public BookStore() {

    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "books=" + books +
                '}';
    }
}