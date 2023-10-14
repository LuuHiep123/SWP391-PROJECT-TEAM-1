package com.example.scheduleexam_swp_team1.controller;

import com.example.scheduleexam_swp_team1.model.ExamRoom;
import com.example.scheduleexam_swp_team1.service.ExamRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/examroom")
public class ExamRoomController {
    @Autowired
    private ExamRoomService examRoomService;

    @GetMapping("/listExamRoom")
    public List<ExamRoom> getListExamRoom(){
        return examRoomService.getListRoom();
    }

    @PostMapping("/createExamRoom")
    public String createExamRoom(@RequestBody ExamRoom examRoom) {
        return examRoomService.creatExamRoom(examRoom) + " Created Exam Room";
    }

    @PutMapping("/updateExamRoom/{id}")
    public String updateExamRoom(@PathVariable("id") long id, @RequestBody ExamRoom examRoom) {
        return examRoomService.updateExamRoom(id, examRoom) + " Updated Exam Room";
    }


    @DeleteMapping("/deleteExamRoom/{id}")
    public String deleteExamRoom(@PathVariable(name = "id",required = true)  long id) {
        return examRoomService.deleteExamRoom(id) + " Detele Successful Exam Room";
    }


}
