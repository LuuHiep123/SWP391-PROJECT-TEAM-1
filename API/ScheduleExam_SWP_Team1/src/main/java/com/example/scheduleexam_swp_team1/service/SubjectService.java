package com.example.scheduleexam_swp_team1.service;

import com.example.scheduleexam_swp_team1.interFaceService.SubjectInterFace;
import com.example.scheduleexam_swp_team1.model.Subject;
import com.example.scheduleexam_swp_team1.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.util.List;

@Service
public class SubjectService implements SubjectInterFace {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Subject> listSubject() {
        return subjectRepository.findAll();
    }

    @Override
    public int addSubject(Subject subject) {
        try {
            String querryAddSubjcet = "INSERT INTO [Subject] (Subject_ID,Subject_Name,Exam_Code,Form) VALUES (?,?,?,?)";
            Object[] addSubject = {subject.getSubject_ID(), subject.getSubject_Name(), subject.getExam_Code(), subject.getForm()};
            return jdbcTemplate.update(querryAddSubjcet, addSubject);
        } catch (Exception e) {
        }
        return 0;
    }

    @Override
    public int deleteSubject(String subject_ID) {
        try {

            return jdbcTemplate.update("DELETE FROM [Subject] WHERE Subject_ID = ? ", subject_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateExamCode(String subject_ID, String exam_Code) {
        try {
            String querryUpdateExamCode = "UPDATE Subject " +
                    "SET Exam_Code = ?  " +
                    "WHERE Subject_ID = ?";
            return jdbcTemplate.update(querryUpdateExamCode, exam_Code, subject_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateSubject(Subject subject, String subject_ID) {
        try {
            String queryUpdateSubject = "UPDATE Subject " +
                    "SET Subject_Name = ?, Exam_Code = ?, Form = ? " +
                    "WHERE Subject_ID = ?";
            Object[] updateExamCode = {subject.getSubject_Name(), subject.getExam_Code(), subject.getForm(), subject_ID};
            int[] types = {Types.NVARCHAR, Types.NVARCHAR, Types.NVARCHAR, Types.NVARCHAR};
            return jdbcTemplate.update(queryUpdateSubject, updateExamCode, types);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
