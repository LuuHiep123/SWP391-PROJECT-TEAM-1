package com.example.scheduleexam_swp_team1.interFaceService;

import com.example.scheduleexam_swp_team1.model.StudentExamSchedule;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentExamScheduleInterFace {

    public List<StudentExamSchedule> showStudentExamSchedule();
    public List<StudentExamSchedule> showStudentExamScheduleList();

}
