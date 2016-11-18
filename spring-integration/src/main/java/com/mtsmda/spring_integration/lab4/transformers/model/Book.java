package com.mtsmda.spring_integration.lab4.transformers.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by dminzat on 11/18/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "author")
    private String author;

    @XmlElement(name = "year")
    private String year;

    @XmlElement(name = "price")
    private String price;

    @XmlAttribute(name = "category")
    private String category;

    @XmlAttribute(name = "cover")
    private String cover;


    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                ", price='" + price + '\'' +
                ", category='" + category + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }
}