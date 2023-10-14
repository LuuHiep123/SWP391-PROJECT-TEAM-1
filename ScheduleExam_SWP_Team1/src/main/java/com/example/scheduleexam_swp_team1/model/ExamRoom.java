package com.example.scheduleexam_swp_team1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "examroom")
public class ExamRoom {
    @Id
    @GeneratedValue()
    @Column(name = "room_id")
    private long id;
    @Column(name = "roomname")
    private String roomname;
    @Column(name = "place")
    private boolean place;

    public ExamRoom() {
    }

    public ExamRoom(long id, String roomname, boolean place) {
        this.id = id;
        this.roomname = roomname;
        this.place = place;
    }
}
