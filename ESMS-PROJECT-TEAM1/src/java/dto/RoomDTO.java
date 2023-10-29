/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Admin
 */
public class RoomDTO {
    private String  Room_ID;
    private Integer NumRoom;
    private String Campus;

    public String getRoom_ID() {
        return Room_ID;
    }

    public void setRoom_ID(String Room_ID) {
        this.Room_ID = Room_ID;
    }

    public Integer getNumRoom() {
        return NumRoom;
    }

    public void setNumRoom(Integer NumRoom) {
        this.NumRoom = NumRoom;
    }

    public String getCampus() {
        return Campus;
    }

    public void setCampus(String Campus) {
        this.Campus = Campus;
    }

    public RoomDTO(String Room_ID, Integer NumRoom, String Campus) {
        this.Room_ID = Room_ID;
        this.NumRoom = NumRoom;
        this.Campus = Campus;
    }
    
    
     
}
