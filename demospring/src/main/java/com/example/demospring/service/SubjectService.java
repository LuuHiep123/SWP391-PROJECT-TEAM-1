package com.example.demospring.service;

import com.example.demospring.interfaceservice.SubjectInterfaceService;
import com.example.demospring.model.Subject;
import com.example.demospring.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.sql.Types;
import java.util.List;
import java.util.Objects;

@Service

public class SubjectService implements SubjectInterfaceService {

@Autowired
private JdbcTemplate jdbcTemplate;
@Autowired
private SubjectRepository subjectRepository;
    @Override
    public List<Subject> GetAllSubject() {
        try {
            return subjectRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public int DeleteSubject(String id) {
        try {
            String Delete ="DELETE FROM Subject WHERE Subject_ID = ?";
            return jdbcTemplate.update(Delete,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public int UpdateSubject(Subject subject) {
        try {
            String update = "UPDATE Sucject SET Subject_Name = ? , Exam_Code = ? , Form = ? WHERE Subject_ID = ?";
            Object[] update_sub = {subject.getSubject_Name(),subject.getExam_Code(),subject.getForm(),subject.getSubject_ID()};
            int[] type = {Types.NVARCHAR,Types.NVARCHAR,Types.NVARCHAR,Types.NVARCHAR};
            return jdbcTemplate.update(update,update_sub,type);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int CreateSubject(Subject subject) {
        try {
            String Create = "INSERT INTO Subject (Subject_ID,Subject_Name,Exam_Code,Form) VALUES (?,?,?,?)";
            Object[] Create_sub = {subject.getSubject_ID(),subject.getSubject_Name(),subject.getExam_Code(),subject.getForm()};
            int[] type = {Types.NVARCHAR,Types.NVARCHAR,Types.NVARCHAR,Types.NVARCHAR};
            return jdbcTemplate.update(Create,Create_sub,type);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int UpdateExamCode(String id,String ExamCode) {
        try {
            String update = "UPDATE Sucject SET Exam_Code = ? WHERE Subject_ID = ?";
            Object[] update_sub = {ExamCode,id};
            int[] type = {Types.NVARCHAR,Types.NVARCHAR};
            return jdbcTemplate.update(update,update_sub,type);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
