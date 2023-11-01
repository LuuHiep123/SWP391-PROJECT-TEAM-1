/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.StudentExamDTO;
import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author ADMIN
 */
public class StudentExamDAO {

    private static final String GET_STUDENT_EXAM = "SELECT exam.Subject_ID, sl.Start_Time, sl.End_Time,ro.[Date],ro.NumRoom,ro.Campus,su.Form"
            + " " + "FROM Student_Exam_Schedule exam"
            + " " + "JOIN Semester se ON exam.SE_ID = se.SE_ID"
            + " " + "JOIN Room ro ON exam.Room_ID = ro.Room_ID"
            + " " + "JOIN Slot sl ON exam.Slot_ID = sl.Slot_ID"
            + " " + "JOIN [Subject] su ON exam.Subject_ID = su.Subject_ID"
            + " " + "WHERE exam.Email = ?";

    private static final String SEARCH_KEY_SUBJECT= "SELECT exam.Subject_ID, sl.Start_Time, sl.End_Time,ro.[Date],ro.NumRoom,ro.Campus,su.Form"
            + " " + "FROM Student_Exam_Schedule exam"
            + " " + "JOIN Semester se ON exam.SE_ID = se.SE_ID"
            + " " + "JOIN Room ro ON exam.Room_ID = ro.Room_ID"
            + " " + "JOIN Slot sl ON exam.Slot_ID = sl.Slot_ID"
            + " " + "JOIN [Subject] su ON exam.Subject_ID = su.Subject_ID"
            + " " + "WHERE exam.Email = ? AND exam.Subject_ID like ?";

    public List<StudentExamDTO> ListStudentExam(String email) throws ClassNotFoundException, SQLException {
        Connection conn = DBUtils.getConnection();
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<StudentExamDTO> ListExam = new ArrayList<>();
        StudentExamDTO exam = null;
        try {
            if (conn != null) {
                ptm = conn.prepareStatement(GET_STUDENT_EXAM);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String SubjectID = rs.getString("Subject_ID");
                    LocalTime StartTime = rs.getTime("Start_Time").toLocalTime();
                    LocalTime EndTime = rs.getTime("End_Time").toLocalTime();
                    Date date = rs.getDate("Date");
                    int NumRoom = rs.getInt("NumRoom");
                    String Campus = rs.getString("Campus");
                    String Form = rs.getString("Form");
                    exam = new StudentExamDTO(SubjectID, StartTime, EndTime, date, NumRoom, Campus, Form);
                    ListExam.add(exam);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListExam;
    }
    
        public List<StudentExamDTO> SearchKeySubject( String email ,String keysubject) throws ClassNotFoundException, SQLException {
        Connection conn = DBUtils.getConnection();
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<StudentExamDTO> ListExam = new ArrayList<>();
        StudentExamDTO exam = null;
        try {
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_KEY_SUBJECT);
                ptm.setString(1, email);
                ptm.setString(2, "%" + keysubject + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String SubjectID = rs.getString("Subject_ID");
                    LocalTime StartTime = rs.getTime("Start_Time").toLocalTime();
                    LocalTime EndTime = rs.getTime("End_Time").toLocalTime();
                    Date date = rs.getDate("Date");
                    int NumRoom = rs.getInt("NumRoom");
                    String Campus = rs.getString("Campus");
                    String Form = rs.getString("Form");
                    exam = new StudentExamDTO(SubjectID, StartTime, EndTime, date, NumRoom, Campus, Form);
                    ListExam.add(exam);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListExam;
    }

   

}
