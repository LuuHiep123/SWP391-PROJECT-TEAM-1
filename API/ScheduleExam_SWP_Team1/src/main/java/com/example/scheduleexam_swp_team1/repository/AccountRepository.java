package com.example.scheduleexam_swp_team1.repository;

import com.example.scheduleexam_swp_team1.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

}
