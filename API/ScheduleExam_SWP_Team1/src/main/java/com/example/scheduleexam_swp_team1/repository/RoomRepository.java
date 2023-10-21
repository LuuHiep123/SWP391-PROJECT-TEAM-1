package com.example.scheduleexam_swp_team1.repository;

import com.example.scheduleexam_swp_team1.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}
