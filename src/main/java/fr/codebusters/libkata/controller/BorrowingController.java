package fr.codebusters.libkata.controller;

import fr.codebusters.libkata.model.Borrowing;
import fr.codebusters.libkata.repository.BorrowingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static javax.security.auth.callback.ConfirmationCallback.OK;
import static org.springframework.http.HttpStatus.CREATED;
@RestController
public class BorrowingController {
    private final BorrowingRepository brwRepository;

    public BorrowingController(BorrowingRepository brwRepository) {
        this.brwRepository = brwRepository;
    }

    /*@GetMapping("v1/borrowings/{subscriptionId}")
    public ResponseEntity<List<Borrowing>> findBySubId(@PathVariable("subscriptionId") Subscription sub) {
        List<Borrowing> brw = brwRepository.findBySubcription(sub);
        return ResponseEntity.ok(books);
    }*/

    @PostMapping("v1/borrowings/borrow")
    public ResponseEntity<Borrowing> borrow(@RequestBody Borrowing brw) {
        Borrowing newBrw = brwRepository.save(brw);
        return ResponseEntity.status(CREATED).body(newBrw) ;
    }

    @PostMapping("v1/borrowings/return")
    public ResponseEntity<Borrowing> returnBook (@RequestBody Borrowing brw) {
        brwRepository.delete(brw);
        return ResponseEntity.status(OK).body(brw) ;
    }
}
