/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author HoangNQ
 */
public class TeacherScheduleDTO {
    private String email;
    private String se_ID;
    private String subject_ID;
    private String room_ID;
    private String slot_ID;
    private String regulations;

    public TeacherScheduleDTO() {
    }

    public TeacherScheduleDTO(String email, String se_ID, String subject_ID, String room_ID, String slot_ID, String regulations) {
        this.email = email;
        this.se_ID = se_ID;
        this.subject_ID = subject_ID;
        this.room_ID = room_ID;
        this.slot_ID = slot_ID;
        this.regulations = regulations;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSe_ID() {
        return se_ID;
    }

    public void setSe_ID(String se_ID) {
        this.se_ID = se_ID;
    }

    public String getSubject_ID() {
        return subject_ID;
    }

    public void setSubject_ID(String subject_ID) {
        this.subject_ID = subject_ID;
    }

    public String getRoom_ID() {
        return room_ID;
    }

    public void setRoom_ID(String room_ID) {
        this.room_ID = room_ID;
    }

    public String getSlot_ID() {
        return slot_ID;
    }

    public void setSlot_ID(String slot_ID) {
        this.slot_ID = slot_ID;
    }

    public String getRegulations() {
        return regulations;
    }

    public void setRegulations(String regulations) {
        this.regulations = regulations;
    }

   
}
