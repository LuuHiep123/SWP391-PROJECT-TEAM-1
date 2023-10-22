package com.example.scheduleexam_swp_team1.controller;

import com.example.scheduleexam_swp_team1.model.Account;
import com.example.scheduleexam_swp_team1.model.Subject;
import com.example.scheduleexam_swp_team1.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/list")
    public List<Subject> listSubject() {
        return subjectService.listSubject();
    }

    @PostMapping("/add")
    public String addSubject(@RequestBody Subject subject) {
        return subjectService.addSubject(subject) + " Add Subject Successfull";
    }

    @PutMapping("/update/{subjectId}")
    public String updateSubject(@RequestBody Subject subject, @PathVariable String subjectId) {
        return subjectService.updateSubject(subject, subjectId) + " Update Subject Successful ";

    }

    @PutMapping("/updateExamCode/{subjectId}")
    public String updateExamCode(@RequestBody String examCode, @PathVariable String subjectId) {
        return subjectService.updateExamCode(subjectId, examCode) + " Update ExamCode Successful ";
    }

    @DeleteMapping("/delete/{subjectId}")
    public String deleteSubject(@PathVariable String subjectId) {
        return subjectService.deleteSubject(subjectId) + " Delete Successfull";
    }

}
