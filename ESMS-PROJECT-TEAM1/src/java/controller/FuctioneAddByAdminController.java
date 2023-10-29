/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AdminDAO;
import dto.AdminDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HoangNQ
 */
public class FuctioneAddByAdminController extends HttpServlet {

    private static final String ERROR = "AddTestingStaffAndTestingAdmin.jsp";
    private static final String SUCCESS = "AddTestingStaffAndTestingAdmin.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String email = request.getParameter("Email");
            String accountID = request.getParameter("Account_ID");
            String password = request.getParameter("Password");
            String name = request.getParameter("Name");
            String gender = request.getParameter("Gender");
            String address = request.getParameter("Address");
            String dobString = request.getParameter("DoB"); // Correct variable name
            Date dob = null;
            dob = dateFormat.parse(dobString); // Correct variable name
            String roleName = request.getParameter("RoleName");
            AdminDAO dao = new AdminDAO();
            AdminDTO admin = new AdminDTO(email, accountID, password, name, gender, address, dob, roleName);
            boolean check = dao.AddRole(admin);
            if (check) {
                url = SUCCESS;

            }
        } catch (Exception e) {
            log("Error at AddTestingStaffController!" + e.toString());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
