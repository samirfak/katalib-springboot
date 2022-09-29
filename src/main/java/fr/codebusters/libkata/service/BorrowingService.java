package fr.codebusters.libkata.service;

import fr.codebusters.libkata.model.Borrowing;

public interface BorrowingService {
    Borrowing borrow (Borrowing brw);
    void returnBook(Borrowing brw);
}
