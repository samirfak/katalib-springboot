package fr.codebusters.libkata.repository;

import fr.codebusters.libkata.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
}
