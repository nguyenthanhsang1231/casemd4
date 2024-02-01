package com.example.casemd4.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String artist;
    private String genre;

//    @ManyToMany(mappedBy = "songs")
//    private Set<Playlist> playlists;


    public Song() {

    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public Song(Long id, String name, String artist, String genre) {
        Id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
    }




//    public void setPlaylists(Set<Playlist> playlists) {
//        this.playlists = playlists;
//    }
}
