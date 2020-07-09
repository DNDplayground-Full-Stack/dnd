package com.codeup.playground.Models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "campaigns")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "text")
    private String description;

    @ManyToOne
    @JoinColumn(name = "dm")
    private User dm;

    @Column(columnDefinition = "text")
    private ArrayList imageUrls;

    public Campaign(Campaign copy) {
        this.id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        this.dm = copy.dm;
        this.name = copy.name;
        this.description = copy.description;
    }

    public Campaign(User dm, String name, String description, long id, ArrayList imageUrls) {
        this.dm = dm;
        this.name = name;
        this.description = description;
        this.id = id;
        this.imageUrls = imageUrls;
    }

    public Campaign() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getDm() {
        return dm;
    }

    public void setDm(User dm) {
        this.dm = dm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImageUrl() {
        return imageUrls;
    }

    public void setImageUrl(ArrayList imageUrl) {
        this.imageUrls = imageUrl;
    }
}
