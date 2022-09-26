package fr.codebusters.libkata.service;

import fr.codebusters.libkata.model.Book;
import fr.codebusters.libkata.model.Category;

import java.util.List;

public interface BookService {
    List<Book> findByCategory(Category category);
    List<Book> findByAuthor(String author);
}
