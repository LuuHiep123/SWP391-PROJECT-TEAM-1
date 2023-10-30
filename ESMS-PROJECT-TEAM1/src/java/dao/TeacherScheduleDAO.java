/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.TeacherScheduleDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author HoangNQ
 */
public class TeacherScheduleDAO {

    private static final String GET_STUDENT_EXAM = "SELECT"
            + " S.SE_Name,"
            + " R.NumRoom,"
            + " SL.Slot_Name,"
            + " Subject_ID "
            + " FROM Teacher_Schedule AS TS"
            + " JOIN Semester AS S ON TS.SE_ID = S.SE_ID"
            + " JOIN Room AS R ON TS.Room_ID = R.Room_ID"
            + " JOIN Slot AS SL ON TS.Slot_ID = SL.Slot_ID ";

    public List<TeacherScheduleDTO> ListSchedelexam() throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<TeacherScheduleDTO> list = new ArrayList<>();
        TeacherScheduleDTO teacher = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_STUDENT_EXAM);               
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String se_name = rs.getNString("SE_Name");
                    String NumRoom = rs.getNString("NumRoom");
                    String Slot_Name = rs.getNString("Slot_Name");
                    String Subject_ID = rs.getNString("Subject_ID");
                    teacher = new TeacherScheduleDTO("", se_name, Subject_ID, NumRoom, Slot_Name, "");
                    list.add(teacher);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

}
