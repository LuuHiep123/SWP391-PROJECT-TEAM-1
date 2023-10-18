package com.example.scheduleexam_swp_team1.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Student_Exam_Schedule")
public class StudentExamSchedule {
    @Id
    private long id;
    @OneToOne
    @JoinColumn(name = "Email", referencedColumnName = "email")
    private Account email;

    @ManyToOne
    @JoinColumn(name = "SE_ID", referencedColumnName = "SE_ID")
    private Semester SE_ID;

    @ManyToOne
    @JoinColumn(name = "Subject_ID", referencedColumnName = "Subject_ID")
    private Subject Subject_ID;

    @ManyToOne
    @JoinColumn(name = "Room_ID", referencedColumnName = "Room_ID")
    private Room Room_ID;

    @ManyToOne
    @JoinColumn(name = "Slot_ID", referencedColumnName = "Slot_ID")
    private Slot Slot_ID;

    @Column(name = "regulations")
    private String regulations;

}
