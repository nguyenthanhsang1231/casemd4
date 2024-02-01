package com.example.casemd4.repository;

import com.example.casemd4.model.Feeling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeelingRepository extends JpaRepository<Feeling, Long> {
}
