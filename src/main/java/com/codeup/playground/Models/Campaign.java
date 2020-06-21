package com.codeup.playground.Models;


import javax.persistence.*;

@Entity
@Table(name="campaigns")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
    @Column(name="campaign_id", nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "dm", referencedColumnName = "id")
    private User dm;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition="text")
    private String Description;
}
