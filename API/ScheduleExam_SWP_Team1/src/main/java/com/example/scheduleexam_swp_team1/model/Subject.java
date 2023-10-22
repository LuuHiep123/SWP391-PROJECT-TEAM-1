package com.example.scheduleexam_swp_team1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Subject")
public class Subject {
    @Id
    @Column(name = "Subject_ID")
    private String subject_ID;
    @Column(name = "Subject_Name")
    private String subject_Name;
    @Column(name = "Exam_Code")
    private String exam_Code;
    @Column(name = "Form")
    private String form;

}