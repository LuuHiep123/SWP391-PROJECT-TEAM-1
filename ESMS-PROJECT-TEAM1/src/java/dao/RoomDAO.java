/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dto.StudentExamDTO;
import dto.RoomDTO;
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
public class RoomDAO {
    private static final String GET_ROOM = "SELECT Room_ID, NumRoom ,Campus"
            + " " + "FROM Student_Exam_Schedule exam"
            + " " + "JOIN Semester se ON exam.SE_ID = se.SE_ID"
            + " " + "JOIN Room ro ON exam.Room_ID = ro.Room_ID"
            + " " + "JOIN Slot sl ON exam.Slot_ID = sl.Slot_ID"
            + " " + "JOIN [Subject] su ON exam.Subject_ID = su.Subject_ID"
            + " " + "WHERE exam.Email = ?";

    public List<RoomDTO> ListSlot(String Room_ID) throws ClassNotFoundException, SQLException {
        Connection conn = DBUtils.getConnection();
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<RoomDTO> ListRoom = new ArrayList<>();
        RoomDTO Room = null;
        try {
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ROOM);
                ptm.setString(1, Room_ID);
                rs = ptm.executeQuery();
                while(rs.next()) {
                    String RoomID = rs.getString("Room_ID");
                    int NumRoom = rs.getInt("NumRoom");
                    String Campus = rs.getString("Campus");
                    
                    
                    Room = new RoomDTO(RoomID,NumRoom ,Campus);
                    ListRoom.add(Room);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListRoom;
    }
}
