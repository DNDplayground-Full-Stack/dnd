package com.codeup.playground.Models;

import javax.persistence.*;

@Entity
@Table(name = "characters")
public class Characters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    //    @Column(length =25, nullable = false)
//    private String race;
//
//    @Column(length =25, nullable = false)
//    private String playerClass;
//
//    @Column(length =25, nullable = false)
//    private String level;
//

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @ManyToOne
//    @JoinColumn(name = "campaign")
//    private Campaign campaign;

//    @Column(length =25, nullable = false)
//    private String background;
//
//    @Column(length =25, nullable = false)
//    private String alignment;
//
//    @Column(nullable = false)
//    private long xp;
//
//    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
//    private int proficiencyBonus;
//
//    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
//    private int strength;
//
//    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
//    private int dexterity;
//
//    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
//    private int constitution;
//
//    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
//    private int intelligence;
//
//    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
//    private int wisdom;
//
//    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
//    private int charisma;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "player")
//    private List<String> skillProficiencies;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
//    private List<String> savingThrows;

//    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
//    private int armourClass;
//
//    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
//    private int initiative;
//
//    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
//    private int movement;
//
//    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
//    private int maxHitpoints;
//
//    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
//    private int currentHitPoints;
//
//    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
//    private int temporaryHitPoints;
//
//    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
//    private int maxHitDice;
//
//    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
//    private int currentHitDice;
//
//    @Column(nullable = false, columnDefinition = "text")
//    private String biography;


    public Characters() {
    }

    public Characters(Characters copy) {
        name = copy.name;
        user = copy.user;
        id = copy.id;
    }

    public Characters(String name, User user, long id) {
        this.name = name;
        this.user = user;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
