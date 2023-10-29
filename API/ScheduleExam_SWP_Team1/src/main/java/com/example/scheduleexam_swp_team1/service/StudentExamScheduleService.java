package com.example.scheduleexam_swp_team1.service;

import com.example.scheduleexam_swp_team1.interFaceService.StudentExamScheduleInterFace;
import com.example.scheduleexam_swp_team1.model.StudentExamSchedule;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StudentExamScheduleService implements StudentExamScheduleInterFace {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<StudentExamSchedule>  showStudentExamSchedule() {
        try {
            String sql = "SELECT SEM.SE_Name AS SE_Name, R.NumRoom AS RoomName, SL.Slot_Name AS Slot_Name, SL.Start_Time AS StartTime, SL.End_Time AS EndTime, S.Subject_Name AS SubjectName " +
                    "FROM Student_Exam_Schedule SES " +
                    "INNER JOIN Semester SEM ON SES.SE_ID = SEM.SE_ID " +
                    "INNER JOIN Room R ON SES.Room_ID = R.Room_ID " +
                    "INNER JOIN Slot SL ON SES.Slot_ID = SL.Slot_ID " +
                    "INNER JOIN Subject S ON SES.Subject_ID = S.Subject_ID";

            System.out.println("SQL Query: " + sql);

            List<StudentExamSchedule> sES = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentExamSchedule.class));
            sES.forEach(System.out::println); // Print retrieved data

            return sES;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something Wrong !!!");
        }
        return Collections.emptyList();



    }

    @Override
    public List<StudentExamSchedule> showStudentExamScheduleList() {

        return jdbcTemplate.query("select * from [Student_Exam_Schedule]",  new BeanPropertyRowMapper<>(StudentExamSchedule.class));
    }
}
