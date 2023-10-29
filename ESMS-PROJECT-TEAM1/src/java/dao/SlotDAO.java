/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dto.StudentExamDTO;
import dto.SlotDTO;
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
public class SlotDAO {
   private static final String GET_SLOT = "SELECT Slot_ID, Slot_Name ,sl.Start_Time, sl.End_Time"
            + " " + "FROM Student_Exam_Schedule exam"
            + " " + "JOIN Semester se ON exam.SE_ID = se.SE_ID"
            + " " + "JOIN Room ro ON exam.Room_ID = ro.Room_ID"
            + " " + "JOIN Slot sl ON exam.Slot_ID = sl.Slot_ID"
            + " " + "JOIN [Subject] su ON exam.Subject_ID = su.Subject_ID"
            + " " + "WHERE exam.Email = ?";

    public List<SlotDTO> ListSlot(String Slot_ID) throws ClassNotFoundException, SQLException {
        Connection conn = DBUtils.getConnection();
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<SlotDTO> ListSlot = new ArrayList<>();
        SlotDTO Slot = null;
        try {
            if (conn != null) {
                ptm = conn.prepareStatement(GET_SLOT);
                ptm.setString(1, Slot_ID);
                rs = ptm.executeQuery();
                while(rs.next()) {
                    String SlotID = rs.getString("Slot_ID");
                    String Slot_Name = rs.getString("Slot_Name");
                    LocalTime StartTime = rs.getTime("Start_Time").toLocalTime();
                    LocalTime EndTime = rs.getTime("End_Time").toLocalTime();
                    
                    Slot = new SlotDTO(SlotID,Slot_Name ,StartTime, EndTime);
                    ListSlot.add(Slot);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListSlot;
    }
}


