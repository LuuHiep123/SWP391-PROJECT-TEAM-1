/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class SlotDTO {
    private String Slot_ID;
    private String Slot_Name;
    public LocalTime Start_Time;
    public LocalTime End_Time;

    public SlotDTO(String Slot_ID, String Slot_Name, LocalTime Start_Time, LocalTime End_Time) {
        this.Slot_ID = Slot_ID;
        this.Slot_Name = Slot_Name;
        this.Start_Time = Start_Time;
        this.End_Time = End_Time;
    }

    public String getSlot_ID() {
        return Slot_ID;
    }

    public void setSlot_ID(String Slot_ID) {
        this.Slot_ID = Slot_ID;
    }

    public String getSlot_Name() {
        return Slot_Name;
    }

    public void setSlot_Name(String Slot_Name) {
        this.Slot_Name = Slot_Name;
    }

    public LocalTime getStart_Time() {
        return Start_Time;
    }

    public void setStart_Time(LocalTime Start_Time) {
        this.Start_Time = Start_Time;
    }

    public LocalTime getEnd_Time() {
        return End_Time;
    }

    public void setEnd_Time(LocalTime End_Time) {
        this.End_Time = End_Time;
    }


}
