package fr.codebusters.libkata.service;

import fr.codebusters.libkata.model.Subscription;

import java.util.Optional;

public interface SubscriptionService {
    Subscription subscribe(Subscription sub);
    Optional<Subscription> getSubscriptionInfo(Integer sId);
}
