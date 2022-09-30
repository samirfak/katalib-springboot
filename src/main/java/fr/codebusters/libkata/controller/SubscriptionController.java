package fr.codebusters.libkata.controller;

import fr.codebusters.libkata.model.Subscription;
import fr.codebusters.libkata.repository.SubscriptionRepository;
import fr.codebusters.libkata.service.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
@RestController
public class SubscriptionController {
    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionRepository subscriptionRepository, SubscriptionService subscriptionService) {
        this.subscriptionRepository = subscriptionRepository;
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("v1/subscriptions/subscribe")
    public ResponseEntity<Subscription> subscribe(@RequestBody Subscription sub) {
        Subscription newSub = subscriptionService.subscribe(sub);
        return ResponseEntity.status(CREATED).body(newSub) ;
    }

    @GetMapping ("v1/subscriptions/{subscriptionId}")
    public ResponseEntity<Subscription> getSubscriptionInfo(@PathVariable("subscriptionId") Integer sId) {
        Optional<Subscription> subOpt = subscriptionService.getSubscriptionInfo(sId);
        return subOpt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
