package com.example.scheduleexam_swp_team1.interFaceService;

import com.example.scheduleexam_swp_team1.model.Room;

import java.util.List;

public interface RoomInterFaceService {
    // ham add 1 Exam Room
    public int creatRoom(Room Room);
    // ham delete 1 Exam Room
    public boolean deleteRoom(long id);

    //ham getRoombyID
    public Room getRoomByID(long id);

    //ham getListRoom
    public List<Room> getListRoom();

    //  ham update Room
    public int updateRoom(long id, Room Room);
}
