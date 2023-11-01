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

    private static final String GET_STUDENT_EXAM = "SELECT\n"
            + "    S.SE_Name,\n"
            + "    R.NumRoom,\n"
            + "    SL.Slot_Name,\n"
            + "    Subject_ID\n"
            + " FROM Teacher_Schedule AS TS\n"
            + " JOIN Semester AS S ON TS.SE_ID = S.SE_ID\n"
            + " JOIN Room AS R ON TS.Room_ID = R.Room_ID\n"
            + " JOIN Slot AS SL ON TS.Slot_ID = SL.Slot_ID\n"
            + " WHERE [Email] = ?";

    public List<TeacherScheduleDTO> ListSchedelexam(String email) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<TeacherScheduleDTO> list = new ArrayList<>();
        TeacherScheduleDTO teacher = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_STUDENT_EXAM);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String se_name = rs.getString("SE_Name");
                    String room_ID = rs.getString("NumRoom");
                    String slot_id = rs.getString("Slot_Name");
                    String subject_ID = rs.getString("Subject_ID");
                    teacher = new TeacherScheduleDTO("", se_name, subject_ID, room_ID, slot_id, "");
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
