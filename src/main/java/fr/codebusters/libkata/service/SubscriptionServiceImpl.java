package fr.codebusters.libkata.service;

import fr.codebusters.libkata.model.Subscription;
import fr.codebusters.libkata.model.SubscriptionTypes;
import fr.codebusters.libkata.model.User;
import fr.codebusters.libkata.repository.SubscriptionRepository;

import java.util.Optional;

public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Subscription subscribe(Subscription sub) {
        User user = sub.getUser();
        if (user.getAge() < 12 && sub.getType() != SubscriptionTypes.JUNIOR) {
            return null ;
        }

        Subscription newSub = subscriptionRepository.save(sub);
        return newSub;
    }

    @Override
    public Optional<Subscription> getSubscriptionInfo(Integer sId) {
        Optional<Subscription> subOpt = subscriptionRepository.findById(sId);
        return subOpt;
    }


}
