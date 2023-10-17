package com.example.scheduleexam_swp_team1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Room")
public class Room {
    @Id
    @GeneratedValue()
    @Column(name = "Room_ID")
    private long id;
    @Column(name = "NumRoom")
    private String roomname;
    @Column(name = "Campus")
    private boolean place;

    public Room() {
    }

    public Room(long id, String roomname, boolean place) {
        this.id = id;
        this.roomname = roomname;
        this.place = place;
    }
}
