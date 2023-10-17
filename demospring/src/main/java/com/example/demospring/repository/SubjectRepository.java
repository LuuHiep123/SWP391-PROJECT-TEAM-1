package com.example.demospring.repository;

import com.example.demospring.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface SubjectRepository extends JpaRepository<Subject,Long> {

}
