package fr.codebusters.libkata.repository;

import fr.codebusters.libkata.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowingRepository extends JpaRepository<Borrowing, Integer> {
    List<Borrowing> findBySubscriptionSubscriptionId (Integer subId);
}
