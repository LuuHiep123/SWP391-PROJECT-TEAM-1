package com.example.demospring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Subject")
public class Subject{
    @Id
    @Column(name = "Subject_ID")
    private String Subject_ID;
    @Column(name = "Subject_Name")
    private String Subject_Name;
    @Column(name = "Exam_Code")
    private String Exam_Code;
    @Column(name = "Form")
    private String Form;

    public Subject() {
    }

    public Subject(String subject_ID, String subject_Name, String exam_Code, String form) {
        Subject_ID = subject_ID;
        Subject_Name = subject_Name;
        Exam_Code = exam_Code;
        Form = form;
    }


}
