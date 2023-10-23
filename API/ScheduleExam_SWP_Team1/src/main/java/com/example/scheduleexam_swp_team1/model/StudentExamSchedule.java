package com.example.scheduleexam_swp_team1.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Student_Exam_Schedule")
public class StudentExamSchedule {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Email", referencedColumnName = "email")
    private Account email;

    @ManyToOne
    @JoinColumn(name = "SE_ID", referencedColumnName = "SE_ID")
    private Semester SE_ID;

    @ManyToOne
    @JoinColumn(name = "Subject_ID", referencedColumnName = "Subject_ID")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "Room_ID", referencedColumnName = "Room_ID")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "Slot_ID", referencedColumnName = "Slot_ID")
    private Slot slot;

    @Column(name = "regulations")
    private String regulations;

    public StudentExamSchedule(Long id, Account email, Semester SE_ID, Subject subject, Room room, Slot slot, String regulations) {
        this.id = id;
        this.email = email;
        this.SE_ID = SE_ID;
        this.subject = subject;
        this.room = room;
        this.slot = slot;
        this.regulations = regulations;
    }

    public StudentExamSchedule() {
    }
}
