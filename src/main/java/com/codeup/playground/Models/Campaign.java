//package com.codeup.playground.Models;
//
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="campaigns")
//public class Campaign {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
//    private long id;
//
//    @Column(length = 200, nullable = false)
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name="DM")
//    private User user;
//
//    @Column(nullable = false, columnDefinition="text")
//    private String Description;
//}
