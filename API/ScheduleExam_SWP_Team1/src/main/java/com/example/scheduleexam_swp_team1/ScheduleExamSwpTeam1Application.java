package com.example.scheduleexam_swp_team1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.scheduleexam_swp_team1.model")
public class ScheduleExamSwpTeam1Application {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleExamSwpTeam1Application.class, args);
    }

}
