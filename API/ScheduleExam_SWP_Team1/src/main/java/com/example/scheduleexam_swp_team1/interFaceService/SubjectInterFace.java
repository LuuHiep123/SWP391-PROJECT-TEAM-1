package com.example.scheduleexam_swp_team1.interFaceService;

import com.example.scheduleexam_swp_team1.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectInterFace {
    //get list subject
    public List<Subject> listSubject();

    //ham add subject
    public int addSubject(Subject subject);

    //ham delete subject
    public int deleteSubject(String subject_ID);

    //ham update Exam code
    public int updateExamCode(String subject_ID, String exam_Code);

    //ham update subject
    public int updateSubject(Subject subject,String subject_ID);
}
