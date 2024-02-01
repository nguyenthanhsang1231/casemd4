package com.example.casemd4.controller;

import com.example.casemd4.model.Song;
import com.example.casemd4.repository.PlayListRepository;
import com.example.casemd4.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    PlayListRepository playListRepository;
    @Autowired
    SongRepository songRepository;
    @GetMapping
    public ResponseEntity<?> showList() {
        return new ResponseEntity<>(songRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Song> song = songRepository.findById(id);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Song song) {
        return new ResponseEntity<>(songRepository.save(song), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody Song song, @PathVariable Long id) {
        song.setId(id);
        return new ResponseEntity<>(songRepository.save(song), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        songRepository.deleteById(id);
        return new ResponseEntity<>("delete thanh cong", HttpStatus.OK);
    }

    @GetMapping("/artists")
    public ResponseEntity<?> showArtists() {
        List<String> artists = songRepository.findAllArtists();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }
    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<Song>> findByTitle(@PathVariable String keyword){
        List<Song> posts = songRepository.findAllByArtistContainingIgnoreCase(keyword);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}
