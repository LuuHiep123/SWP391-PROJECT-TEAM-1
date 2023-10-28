/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import utils.DBUtils;

/**
 *
 * @author ADMIN
 */
public class UserDAO {
    private static final String LOGIN = "SELECT Email, Account_ID, Password, Name, Gender, Address, DOB, RoleName FROM Account WHERE Email = ? AND Password = ?";
    
    public UserDTO Login (String email, String password) throws ClassNotFoundException, SQLException{
        Connection conn = DBUtils.getConnection();
        PreparedStatement ptm = null;
        ResultSet rs = null;
        UserDTO user = null;
        try {
            if(conn != null){
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, email);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if(rs.next()){
                    String Email = rs.getString("Email");
                    String AccountID  = rs.getString("Account_ID");
                    String Name  = rs.getString("Name");
                    String Gender = rs.getString("Gender");
                    String Address = rs.getString("Address");
                    Date DOB = rs.getDate("DOB");
                    String role = rs.getString("roleName");
                    String Password = rs.getString("Password");
                    user = new UserDTO(Email, AccountID, Name, Gender, Address, DOB, role);
                    if(!email.equals(Email) || !password.equals(Password)){
                        return null;
                    }
                }  
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return user;     
    } 
}
