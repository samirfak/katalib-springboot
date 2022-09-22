package fr.codebusters.libkata.Controller;

import fr.codebusters.libkata.Model.Book;
import fr.codebusters.libkata.Model.Category;
import fr.codebusters.libkata.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("v1/books/{name}")
    public ResponseEntity<Book> findByName(@PathVariable("name") String name) {
        Optional<Book> bookOpt = bookRepository.findById(name);
        return bookOpt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("v1/books/{category}")
    public ResponseEntity<List<Book>> findByCategory(@PathVariable("category") Category cat) {
        List<Book> books = bookRepository.findByCategory(cat);
        return ResponseEntity.ok(books);
    }

    @GetMapping("v1/books/{author}")
    public ResponseEntity<List<Book>> findByAuthor(@PathVariable("author") String aut) {
        List<Book> books = bookRepository.findByAuthor(aut);
        return ResponseEntity.ok(books);
    }

    @PostMapping("v1/books/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = bookRepository.save(book);
        return ResponseEntity.status(CREATED).body(newBook) ;
    }

}
