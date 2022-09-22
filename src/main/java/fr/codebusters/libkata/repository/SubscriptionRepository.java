package fr.codebusters.libkata.repository;

import fr.codebusters.libkata.Model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, String> {
}
