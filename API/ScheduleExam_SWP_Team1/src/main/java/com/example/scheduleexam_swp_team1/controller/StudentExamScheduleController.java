package com.example.scheduleexam_swp_team1.controller;

import com.example.scheduleexam_swp_team1.model.StudentExamSchedule;
import com.example.scheduleexam_swp_team1.service.StudentExamScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/StudentExamSchedule")
public class StudentExamScheduleController {
    @Autowired
    private StudentExamScheduleService studentScheduleService;

    @GetMapping("/")
    public List<StudentExamSchedule> showExamSchedule() {
        return  studentScheduleService.showStudentExamSchedule();

    }
    @GetMapping("/")
    public List<StudentExamSchedule> showExamSchedulex() {
        return  studentScheduleService.showStudentExamScheduleList();

    }
}
