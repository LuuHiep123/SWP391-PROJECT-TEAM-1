/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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
            + " JOIN Slot AS SL ON TS.Slot_ID = SL.Slot_ID;";

}
