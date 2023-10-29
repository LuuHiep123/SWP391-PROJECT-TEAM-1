/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.StudentExamDTO;
import dto.SemesterDTO;
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
 * @author Admin
 */
public class SemesterDAO {
    private static final String GET_SEMESTER = "SELECT SE_ID, SE_Name ,StartDate, EndDate"
            + " " + "FROM Student_Exam_Schedule exam"
            + " " + "JOIN Semester se ON exam.SE_ID = se.SE_ID"
            + " " + "JOIN Room ro ON exam.Room_ID = ro.Room_ID"
            + " " + "JOIN Slot sl ON exam.Slot_ID = sl.Slot_ID"
            + " " + "JOIN [Subject] su ON exam.Subject_ID = su.Subject_ID"
            + " " + "WHERE exam.Email = ?";

    public List<SemesterDTO> ListSemester(String SE_ID) throws ClassNotFoundException, SQLException {
        Connection conn = DBUtils.getConnection();
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<SemesterDTO> ListSE = new ArrayList<>();
        SemesterDTO SE = null;
        try {
            if (conn != null) {
                ptm = conn.prepareStatement(GET_SEMESTER);
                ptm.setString(1, SE_ID);
                rs = ptm.executeQuery();
                while(rs.next()) {
                    String SEID = rs.getString("SE_ID");
                    String SE_Name = rs.getString("SE_Name");
                    LocalTime StartDate = rs.getTime("StartDate").toLocalTime();
                    LocalTime EndDate= rs.getTime("EndDate").toLocalTime();
                    
                    SE = new SemesterDTO(SE_ID,SE_Name ,StartDate, EndDate);
                    ListSE.add(SE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListSE;
    }
}
