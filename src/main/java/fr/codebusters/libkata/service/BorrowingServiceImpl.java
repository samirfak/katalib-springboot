package fr.codebusters.libkata.service;

import fr.codebusters.libkata.model.*;
import fr.codebusters.libkata.repository.BorrowingRepository;
import fr.codebusters.libkata.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

@Service
public class BorrowingServiceImpl implements BorrowingService {
    private final BorrowingRepository brwRepository;
    private final SubscriptionRepository subRepository;

    public BorrowingServiceImpl(BorrowingRepository brwRepository, SubscriptionRepository subRepository) {
        this.brwRepository = brwRepository;
        this.subRepository = subRepository;
    }

    @Override
    public Borrowing borrow(Borrowing brw) {
        Subscription sub = brw.getSubscription();
        Book book = brw.getBook();
        if (sub.getType() == SubscriptionTypes.JUNIOR && book.getCategory() != Category.KIDS) {
            //return ResponseEntity.status(METHOD_NOT_ALLOWED).build() ;
           throw new RuntimeException("XXX") ;
        }
        //Todo check number of current borrows of the user
        return brwRepository.save(brw);
    }

    @Override
    public void returnBook(Borrowing brw) {
        brwRepository.delete(brw);
    }
}
