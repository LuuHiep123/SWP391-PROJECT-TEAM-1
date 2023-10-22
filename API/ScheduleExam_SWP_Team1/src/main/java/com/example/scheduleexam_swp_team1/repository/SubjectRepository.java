package com.example.scheduleexam_swp_team1.repository;

import com.example.scheduleexam_swp_team1.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
