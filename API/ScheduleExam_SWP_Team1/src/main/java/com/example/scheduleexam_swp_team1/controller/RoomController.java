package com.example.scheduleexam_swp_team1.controller;

import com.example.scheduleexam_swp_team1.model.Room;
import com.example.scheduleexam_swp_team1.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/Room")
public class RoomController {
    @Autowired
    private RoomService RoomService;

    @GetMapping("/list")
    public List<Room> getListRoom(){
        return RoomService.getListRoom();
    }

    @PostMapping("/create")
    public String createRoom(@RequestBody Room Room) {
        return RoomService.creatRoom(Room) + " Created Exam Room";
    }

    @PutMapping("/update/{id}")
    public String updateRoom(@PathVariable("id") long id, @RequestBody Room Room) {
        return RoomService.updateRoom(id, Room) + " Updated Exam Room";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteRoom(@PathVariable(name = "id",required = true)  long id) {
        return RoomService.deleteRoom(id) + " Detele Successful Exam Room";
    }


}
