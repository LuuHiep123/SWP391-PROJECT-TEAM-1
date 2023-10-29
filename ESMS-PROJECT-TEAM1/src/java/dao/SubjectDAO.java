/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.StudentExamDTO;
import dto.SubjectDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class SubjectDAO {
     private static final String GET_SUBJECT = "SELECT Subject_ID, Subject_Name, Exam_Code, Form FROM Subject WHERE ?";
    
    public List<SubjectDTO> ListSubjectDTO(String Subject_ID) throws ClassNotFoundException, SQLException {
        Connection conn = DBUtils.getConnection();
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<SubjectDTO> ListSubject = new ArrayList<>();
        SubjectDTO subject = null;
        try {
            if (conn != null) {
                ptm = conn.prepareStatement(GET_SUBJECT);
                ptm.setString(1, Subject_ID);
                rs = ptm.executeQuery();
                while(rs.next()) {
                    String SubjectID = rs.getString("Subject_ID");
                    String Subject_Name = rs.getString("Subject_Name");
                    String Exam_Code = rs.getString("Exam_Code");
                    String Form= rs.getString("Form");
                    subject = new SubjectDTO(SubjectID,Subject_Name, Exam_Code,Form );
                    ListSubject.add(subject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListSubject;
    }
}
