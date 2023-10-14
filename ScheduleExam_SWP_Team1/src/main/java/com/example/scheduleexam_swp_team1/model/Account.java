package com.example.scheduleexam_swp_team1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @Column(name = "Email")
    private String Email;
    @Column(name = "Account_ID")
    private String Account_ID;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Gender")
    private boolean Gender;
    @Column(name = "Address")
    private String Address;
    @Column(name = "DOB")
    private Date DOB;
    @Column(name = "IMG")
    private String IMG;
    @Column(name = "rolename")
    private String rolename;

    public Account(String email, String account_ID, String name, boolean gender, String address, Date DOB, String IMG, String rolename) {
        Email = email;
        Account_ID = account_ID;
        Name = name;
        Gender = gender;
        Address = address;
        this.DOB = DOB;
        this.IMG = IMG;
        this.rolename = rolename;
    }

    public Account() {
    }
}