package com.example.casemd4.repository;

import com.example.casemd4.model.Song;
import jakarta.validation.constraints.Past;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    @Query("SELECT DISTINCT s.artist FROM Song s")
    List<String> findAllArtists();

    List<Song> findAllByArtistContainingIgnoreCase(String artist);
}
