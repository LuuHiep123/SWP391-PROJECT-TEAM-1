/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class StudentExamDTO {
    public String SubjectID;
    public LocalTime StartTime;
    public LocalTime EndTime;
    public Date Date;
    public int Room;
    public String Campus;
    public String Form;

    public StudentExamDTO() {
    }

    public StudentExamDTO(String SubjectID, LocalTime StartTime, LocalTime EndTime, Date Date, int Room, String Campus, String Form) {
        this.SubjectID = SubjectID;
        this.StartTime = StartTime;
        this.EndTime = EndTime;
        this.Date = Date;
        this.Room = Room;
        this.Campus = Campus;
        this.Form = Form;
    }

    public String getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(String SubjectID) {
        this.SubjectID = SubjectID;
    }

    public LocalTime getStartTime() {
        return StartTime;
    }

    public void setStartTime(LocalTime StartTime) {
        this.StartTime = StartTime;
    }

    public LocalTime getEndTime() {
        return EndTime;
    }

    public void setEndTime(LocalTime EndTime) {
        this.EndTime = EndTime;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public int getRoom() {
        return Room;
    }

    public void setRoom(int Room) {
        this.Room = Room;
    }

    public String getCampus() {
        return Campus;
    }

    public void setCampus(String Campus) {
        this.Campus = Campus;
    }

    public String getForm() {
        return Form;
    }

    public void setForm(String Form) {
        this.Form = Form;
    }
    
    
    
    
    
}
