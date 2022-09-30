package fr.codebusters.libkata.service;

import fr.codebusters.libkata.model.Book;
import fr.codebusters.libkata.model.Category;
import fr.codebusters.libkata.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    private BookRepository bookRepository;
    public BookServiceImpl() {
        super();
    }

    public BookServiceImpl(BookRepository bookRepository) {
        super();
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findByCategory(Category category) {
        return bookRepository.findByCategory(category);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public Optional<Book> findById(String name) {
        return bookRepository.findById(name);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
}
