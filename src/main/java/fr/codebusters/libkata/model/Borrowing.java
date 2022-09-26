package fr.codebusters.libkata.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Borrowing {
    @Id
    private Integer id;
    private Subscription subscription;
    private Integer duration;//in days
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Borrowing(Integer id, Subscription subscription, Integer duration, Book book) {
        this.id = id;
        this.subscription = subscription;
        this.duration = duration;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
