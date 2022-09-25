package fr.codebusters.libkata.Controller;

import fr.codebusters.libkata.repository.BookRepository;

public class BorrowingController {
    private final BookRepository bookRepository;

    public BorrowingController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
