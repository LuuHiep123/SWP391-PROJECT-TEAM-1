package com.example.scheduleexam_swp_team1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Entity
@Data
@Table(name = "Semester")
public class Semester {
    @Id
    @Column(name = "SE_ID")
    private String se_id;
    @Column(name = "StartDate")
    private String StartDate;
    @Column(name = "EndtDate")
    private String EndtDate;

    public Semester() {
    }

    public Semester(String se_id, String startDate, String endtDate) {
        this.se_id = se_id;
        StartDate = startDate;
        EndtDate = endtDate;
    }
}
