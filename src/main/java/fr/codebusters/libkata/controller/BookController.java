package fr.codebusters.libkata.controller;

import fr.codebusters.libkata.model.Book;
import fr.codebusters.libkata.model.Category;
import fr.codebusters.libkata.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("v1/books/{name}")
    public ResponseEntity<Book> findByName(@PathVariable("name") String name) {
        Optional<Book> bookOpt = bookService.findById(name);
        return bookOpt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("v1/books/{category}")
    public ResponseEntity<List<Book>> findByCategory(@PathVariable("category") Category cat) {
        List<Book> books = bookService.findByCategory(cat);
        return ResponseEntity.ok(books);
    }

    @GetMapping("v1/books/{author}")
    public ResponseEntity<List<Book>> findByAuthor(@PathVariable("author") String aut) {
        List<Book> books = bookService.findByAuthor(aut);
        return ResponseEntity.ok(books);
    }

    @PostMapping("v1/books/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = bookService.addBook(book);
        return ResponseEntity.status(CREATED).body(newBook) ;
    }

}
