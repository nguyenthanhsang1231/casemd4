package com.example.casemd4.repository;

import com.example.casemd4.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PlayListRepository extends JpaRepository<Playlist, Long> {
}
