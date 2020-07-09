package com.codeup.playground.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "characters")
public class Characters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String race;

    @Column(nullable = false)
    private String playerClass;

    @Column(nullable = false)
    private String level;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "campaign")
    private Campaign campaign;

    @Column(length =25, nullable = false)
    private String background;

    @Column(length =25, nullable = false)
    private String alignment;

    @Column(nullable = false)
    private long xp;

    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
    private int proficiencyBonus;

    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
    private int strength;

    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
    private int dexterity;

    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
    private int constitution;

    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
    private int intelligence;

    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
    private int wisdom;

    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
    private int charisma;

    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
    private int armourClass;

    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
    private int initiative;

    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
    private int movement;

    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
    private int maxHitpoints;

    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
    private int currentHitPoints;

    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
    private int temporaryHitPoints;

    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
    private int maxHitDice;

    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
    private int currentHitDice;

    @Column(nullable = false, columnDefinition = "text")
    private String biography;


    public Characters() {
    }

    public Characters(Characters copy) {
        id = copy.id;
        name = copy.name;
        race = copy.race;
        playerClass = copy.playerClass;
        level = copy.level;
        user = copy.user;
        campaign = copy.campaign;
        background = copy.background;
        alignment = copy.alignment;
        xp = copy.xp;
        proficiencyBonus = copy.proficiencyBonus;
        strength = copy.strength;
        dexterity = copy.dexterity;
        constitution = copy.constitution;
        intelligence = copy.intelligence;
        wisdom = copy.wisdom;
        charisma = copy.charisma;
//        skillProficiencies = copy.skillProficiencies;
//        savingThrows = copy.savingThrows;
        armourClass = copy.armourClass;
        initiative = copy.initiative;
        movement = copy.movement;
        maxHitpoints = copy.maxHitpoints;
        currentHitPoints = copy.currentHitPoints;
        temporaryHitPoints = copy.temporaryHitPoints;
        maxHitDice = copy.maxHitDice;
        currentHitDice = copy.currentHitDice;
        biography = copy.biography;
    }

    public Characters(long id, String name, String race, String playerClass, String level, User user, Campaign campaign, String background, String alignment, long xp, int proficiencyBonus, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, int armourClass, int initiative, int movement, int maxHitpoints, int currentHitPoints, int temporaryHitPoints, int maxHitDice, int currentHitDice, String biography) {//List<String> skillProficiencies, List<String> savingThrows,
        this.id = id;
        this.name = name;
        this.race = race;
        this.playerClass = playerClass;
        this.level = level;
        this.user = user;
        this.campaign = campaign;
        this.background = background;
        this.alignment = alignment;
        this.xp = xp;
        this.proficiencyBonus = proficiencyBonus;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
//        this.skillProficiencies = skillProficiencies;
//        this.savingThrows = savingThrows;
        this.armourClass = armourClass;
        this.initiative = initiative;
        this.movement = movement;
        this.maxHitpoints = maxHitpoints;
        this.currentHitPoints = currentHitPoints;
        this.temporaryHitPoints = temporaryHitPoints;
        this.maxHitDice = maxHitDice;
        this.currentHitDice = currentHitDice;
        this.biography = biography;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public long getXp() {
        return xp;
    }

    public void setXp(long xp) {
        this.xp = xp;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(int proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getArmourClass() {
        return armourClass;
    }

    public void setArmourClass(int armourClass) {
        this.armourClass = armourClass;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getMaxHitpoints() {
        return maxHitpoints;
    }

    public void setMaxHitpoints(int maxHitpoints) {
        this.maxHitpoints = maxHitpoints;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    public int getTemporaryHitPoints() {
        return temporaryHitPoints;
    }

    public void setTemporaryHitPoints(int temporaryHitPoints) {
        this.temporaryHitPoints = temporaryHitPoints;
    }

    public int getMaxHitDice() {
        return maxHitDice;
    }

    public void setMaxHitDice(int maxHitDice) {
        this.maxHitDice = maxHitDice;
    }

    public int getCurrentHitDice() {
        return currentHitDice;
    }

    public void setCurrentHitDice(int currentHitDice) {
        this.currentHitDice = currentHitDice;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
