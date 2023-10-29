/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.time.LocalTime;

/**
 *
 * @author Admin
 */
public class SemesterDTO {
    private String SE_ID;
    private String SE_Name;
    public LocalTime StartDate;
    public LocalTime EndDate;

    public SemesterDTO(String SE_ID, String SE_Name, LocalTime StartDate, LocalTime EndDate) {
        this.SE_ID = SE_ID;
        this.SE_Name = SE_Name;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
    }

    public String getSE_ID() {
        return SE_ID;
    }

    public void setSE_ID(String SE_ID) {
        this.SE_ID = SE_ID;
    }

    public String getSE_Name() {
        return SE_Name;
    }

    public void setSE_Name(String SE_Name) {
        this.SE_Name = SE_Name;
    }

    public LocalTime getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalTime StartDate) {
        this.StartDate = StartDate;
    }

    public LocalTime getEndDate() {
        return EndDate;
    }

    public void setEndDate(LocalTime EndDate) {
        this.EndDate = EndDate;
    }





}

