package fr.codebusters.libkata.Controller;

import fr.codebusters.libkata.Model.Subscription;
import fr.codebusters.libkata.repository.SubscriptionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

public class SubscriptionController {
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionController(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @PostMapping("v1/subscriptions/subscribe")
    public ResponseEntity<Subscription> subscribe(@RequestBody Subscription sub) {
        Subscription newSub = subscriptionRepository.save(sub);
        return ResponseEntity.status(CREATED).body(newSub) ;
    }

    @GetMapping ("v1/subscriptions/{subscriptionId}")
    public ResponseEntity<Subscription> getSubscriptionInfo(@PathVariable("subscriptionId") String sId) {
        Optional<Subscription> subOpt = subscriptionRepository.findById(sId);
        return subOpt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
