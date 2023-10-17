package com.example.demospring.interfaceservice;

import com.example.demospring.model.Subject;

import java.util.List;

public interface SubjectInterfaceService {
    //function get all subject
     public List<Subject> GetAllSubject();
     public int DeleteSubject(String id);
     public int UpdateSubject(Subject subject);
     public int CreateSubject(Subject subject);
     public int UpdateExamCode(String id,String ExamCode);



}
