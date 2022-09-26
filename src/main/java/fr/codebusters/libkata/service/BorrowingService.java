package fr.codebusters.libkata.service;

import fr.codebusters.libkata.model.Borrowing;
import org.springframework.http.ResponseEntity;

public interface BorrowingService {
    ResponseEntity<Borrowing> borrow (Borrowing brw);
}
