package fr.codebusters.libkata.Model;

import javax.persistence.Id;

public class Book {
    @Id
    private String name;
    private String author;

    private Category category;
    public Book(String name, String author, Category category) {
        this.name = name;
        this.author = author;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }
}
