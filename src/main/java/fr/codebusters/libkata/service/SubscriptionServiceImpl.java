package fr.codebusters.libkata.service;

import fr.codebusters.libkata.model.Subscription;
import fr.codebusters.libkata.model.SubscriptionTypes;
import fr.codebusters.libkata.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Subscription subscribe(Subscription sub) {
        var user = sub.getUser();
        if (user.getAge() < 12 && sub.getType() != SubscriptionTypes.JUNIOR) {
            throw new RuntimeException("User ...") ;
        }

        return subscriptionRepository.save(sub);
    }

    @Override
    public Optional<Subscription> getSubscriptionInfo(Integer sId) {
        return subscriptionRepository.findById(sId);
    }


}
