package fr.codebusters.libkata.Model;

import javax.persistence.Id;

public class Subscription {
    @Id
    private Integer subscriptionId;
    private SubscriptionTypes type;
    private User user;

    public Subscription(Integer subscriptionId, SubscriptionTypes type, User user) {
        this.subscriptionId = subscriptionId;
        this.type = type;
        this.user = user;
    }

    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public SubscriptionTypes getType() {
        return type;
    }

    public User getUser() {
        return user;
    }
}