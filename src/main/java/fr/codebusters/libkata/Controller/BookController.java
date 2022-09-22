package fr.codebusters.libkata.Controller;

import fr.codebusters.libkata.Model.Book;
import fr.codebusters.libkata.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("v1/books/{bookId}")
    public ResponseEntity<Book> subscribe(@PathVariable("bookId") String bId) {
        Optional<Book> bookOpt = bookRepository.findById(bId);
        return bookOpt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


}
