/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.AdminDTO;
import dto.UserDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import utils.DBUtils;

/**
 *
 * @author HoangNQ
 */
public class AdminDAO {

    private static final String ADD_TestingStaffAndTestingAdmin = "INSERT INTO [Account] (Email,Account_ID,[Password],[Name],Gender,[Address],DOB,IMG,RoleName) VALUES (?,?,?,?,?,?,?,null,?) ";

    public boolean AddRole(AdminDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD_TestingStaffAndTestingAdmin);
                ptm.setString(1, user.getEmail());
                ptm.setString(2, user.getAccountID());
                ptm.setString(3, user.getPassword());
                ptm.setString(4, user.getName());
                ptm.setString(5, user.getGender());
                ptm.setString(6, user.getAddress());
                ptm.setDate(7, new java.sql.Date(user.getDOB().getTime()));

                ptm.setString(8, user.getRole());

                check = ptm.executeUpdate() > 0 ? true : false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return check;
    }
}
