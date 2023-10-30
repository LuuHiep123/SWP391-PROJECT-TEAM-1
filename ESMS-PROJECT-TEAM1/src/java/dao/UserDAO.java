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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utils.DBUtils;
import java.text.SimpleDateFormat;



/**
 *
 * @author ADMIN
 */
public class UserDAO {
    private static final String LOGIN = "SELECT Email, Account_ID, Password, Name, Gender, Address, DOB, RoleName FROM Account WHERE Email = ? AND Password = ?";
    private static final String SEARCH  = "SELECT fullName, roleID, status, userID  from tblUsers WHERE fullName LIKE ? ORDER BY [userID] OFFSET 10*? ROWS FETCH NEXT 10 ROWS ONLY";
    private static final String DELETE  = "DELETE FROM tblUsers WHERE userID=?";
    private static final String UPDATE  = "UPDATE tblUsers SET fullName=?, roleID=? WHERE userID=?";
    private static final String CHECK_DUPLICATE  = "SELECT roleID from tblUsers WHERE userID = ?";
    private static final String INSERT = "INSERT INTO tblUsers(userID, fullName, roleID, password, status)" + "VALUES(?,?,?,?,1)";
    
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
    
    public static List<UserDTO> getListUser(String search, String pageNumber) throws SQLException{
        List<UserDTO> listUser = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
          conn = DBUtils.getConnection();
          if(conn != null){
              ps = conn.prepareStatement(SEARCH);
              ps.setString(1, "%"+search+"%");
              ps.setString(2, ""+(Integer.parseInt(pageNumber)-1));
              rs = ps.executeQuery();
              while(rs.next()){
                    String Email = rs.getString("Email");
                    String AccountID = rs.getString("AccountID");
                    String Name = rs.getString("Name");
                    String Gender = rs.getString("Gender");
                    String Address = rs.getString("Address");
                    Date DOB = rs.getDate("DOB");
                    String Roles = rs.getString("Roles");
                    UserDTO newUser = new UserDTO(Email, AccountID, Name, Gender,Address,DOB,Roles);
                    listUser.add(newUser);
              }
          }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
        return listUser;
    }

    public boolean delete(String userID) throws SQLException {
        boolean isDeleted = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                ps = conn.prepareStatement(DELETE);
                ps.setString(1, userID);
                isDeleted = ps.executeUpdate()> 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(ps!=null) ps.close();
            if(conn!=null); conn.close();
        }
        return isDeleted;
    }

    public boolean update(UserDTO user) throws SQLException {
        boolean checkUpdate = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                ps = conn.prepareStatement(UPDATE);
                ps.setString(1, user.getAccountID());
                ps.setString(2, user.getName());
                ps.setString(3, user.getGender());
                ps.setString(4, user.getAddress());
                ps.setDate(5, new java.sql.Date(user.getDOB().getTime()));
                checkUpdate = ps.executeUpdate()> 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(ps!=null) ps.close();
            if(conn!=null); conn.close();
        }
        return checkUpdate;
    }

      public boolean checkDuplicate(String userID) throws SQLException {
        boolean check = false;
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, userID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
        return check;
    }

    public boolean insert(UserDTO user) throws SQLException, ClassNotFoundException{
        boolean checkInsert = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, user.getAccountID());
                ptm.setString(2, user.getName());
                ptm.setString(3, user.getAddress());
                ptm.setString(4, user.getGender());
                ptm.setDate(5, new java.sql.Date(user.getDOB().getTime()));
                checkInsert = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception ex) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkInsert;
    }
   
}
