package com.example.springbootmonolith.models;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private double length;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "user_songs",
            joinColumns = {@JoinColumn(name = "song_id")},
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    public Song() { }

    public List<User> getUsers(){ return users; }

    public void setUsers(List<User> users) { this.users = users; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}