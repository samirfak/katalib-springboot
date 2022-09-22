package fr.codebusters.libkata.Controller;

import fr.codebusters.libkata.Model.Book;
import fr.codebusters.libkata.Model.Category;
import fr.codebusters.libkata.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Book> findByAuthor(@PathVariable("author") String aut) {
        Optional<Book> bookOpt = bookRepository.findByAuthor(aut);
        return bookOpt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public static long getIdealNums(long low, long high) {
        long count = 0L;
        // Write your code here
        for (long i = 0; i <= high; i++) {
            long powerOfThree = (long)Math.pow(3, i);
            for (long j = 0 ; j <= high; j++) {
                long powerOfFive = (long)Math.pow(5, j);
                long product = powerOfThree * powerOfFive;
                if (low <= product && high >= product) {
                    count++;
                }
                if (product > high) {
                    break;
                }
            }
        }
        return count;
    }

}
