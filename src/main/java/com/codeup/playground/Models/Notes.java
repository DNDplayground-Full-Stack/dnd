package com.codeup.playground.Models;


import javax.persistence.*;

@Entity
@Table(name="notes")
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
    private long id;

    //New Entity for Joiner table
    private String note;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    String commentedAt;

    public Notes(){}

    public Notes(String note, User user, String commentedAt) {
        this.note = note;
        this.user = user;
        this.commentedAt = commentedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCommentedAt() {
        return commentedAt;
    }

    public void setCommentedAt(String commentedAt) {
        this.commentedAt = commentedAt;
    }
}
