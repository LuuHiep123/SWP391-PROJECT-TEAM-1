/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

/**
 *
 * @author HoangNQ
 */
public class AdminDTO {
     private String Email;
    private String AccountID;
    private String Password;
    private String Name;
    private String Gender;
    private String Address;
    private Date DOB;
    private String roleName;
    

    public AdminDTO(){
    }

    public AdminDTO(String Email, String AccountID, String Password, String Name, String Gender, String Address, Date DOB, String roleName) {
        this.Email = Email;
        this.AccountID = AccountID;
        this.Password = Password;
        this.Name = Name;
        this.Gender = Gender;
        this.Address = Address;
        this.DOB = DOB;
        this.roleName = roleName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String AccountID) {
        this.AccountID = AccountID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getRole() {
        return roleName;
    }

    public void setRole(String role) {
        this.roleName = roleName;
    }

  
   
    
}
