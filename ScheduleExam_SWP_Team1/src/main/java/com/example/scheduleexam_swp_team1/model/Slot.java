package com.example.scheduleexam_swp_team1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "Slot")
@Data
public class Slot {
    @Id
    @Column(name = "Slot_ID")
    private long id;
    @Column(name = "Slot_Name")
    private String slotName;
    @Column(name = "Start_Time")
    private Date startTime;
    @Column(name = "End_Time")
    private Date endTime;
    @Column(name = "Time")
    private Time time;

    public Slot(long id, String slotName, Date startTime, Date endTime, Time time) {
        this.id = id;
        this.slotName = slotName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.time = time;
    }

    public Slot() {
    }
}
