package com.example.casemd4.controller;
import com.example.casemd4.model.Playlist;
import com.example.casemd4.repository.PlayListRepository;
import com.example.casemd4.repository.SongRepository;
import com.example.casemd4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/playlists")
public class PlaylistController {
    @Autowired
    PlayListRepository playListRepository;
    @Autowired
    SongRepository songRepository;
    @Autowired
    UserRepository userRepository;
    @GetMapping
    public ResponseEntity<?> showList() {
        return new ResponseEntity<>(playListRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Playlist> playlist = playListRepository.findById(id);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Playlist playlist) {
        return new ResponseEntity<>(playListRepository.save(playlist), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody Playlist playlist, @PathVariable Long id) {
        playlist.setId(id);
        return new ResponseEntity<>(playListRepository.save(playlist), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        playListRepository.deleteById(id);
        return new ResponseEntity<>("delete thanh cong", HttpStatus.OK);
    }
}
