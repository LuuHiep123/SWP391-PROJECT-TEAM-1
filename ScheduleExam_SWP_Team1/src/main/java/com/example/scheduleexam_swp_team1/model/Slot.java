package com.example.scheduleexam_swp_team1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;

@Entity
@Data
@Table(name = "Slot")
public class Slot {

    @Column(name = "Slot_ID")
    @Id
    private long  slot_id;
    @Column(name = "SlotName")
    private String slotName;
    @Column(name = "From_date")
    private Date from_date;
    @Column(name = "To_date")
    private Date to_date;
    @Column(name = "Time")
    private Time time;

    public Slot() {
    }

    public Slot(long slot_id, String slotName, Date from_date, Date to_date, Time time) {
        this.slot_id = slot_id;
        this.slotName = slotName;
        this.from_date = from_date;
        this.to_date = to_date;
        this.time = time;
    }
}
