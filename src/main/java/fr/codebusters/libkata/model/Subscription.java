package fr.codebusters.libkata.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Subscription {
    @Id
    private Integer subscriptionId;
    private SubscriptionTypes type;
    @OneToOne
    private User user;

    public Subscription(Integer subscriptionId, SubscriptionTypes type, User user) {
        this.subscriptionId = subscriptionId;
        this.type = type;
        this.user = user;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public void setType(SubscriptionTypes type) {
        this.type = type;
    }

    public void setUser(User user) {
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
