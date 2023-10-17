package com.example.demospring.controller;

import com.example.demospring.model.Subject;
import com.example.demospring.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @GetMapping("/")
    public List<Subject> getSubject(){
        return subjectService.GetAllSubject();
    }
    @DeleteMapping("/{id}")
    public String deleteSubject(@PathVariable String id){
        return subjectService.DeleteSubject(id) + "delete success";
    }
}
