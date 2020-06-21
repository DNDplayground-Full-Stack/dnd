package com.codeup.playground.Models;


import javax.persistence.*;

@Entity
@Table(name="campaigns")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="campaign_id", nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "dm")
    private User dm;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition="text")
    private String description;

    public Campaign(Campaign copy) {
        this.id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        this.dm = copy.dm;
        this.name = copy.name;
        this.description = copy.description;
    }

    public Campaign(User dm, String name, String description, long id) {
        this.dm = dm;
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public Campaign (){

    }
}
